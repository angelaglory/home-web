package eu.daiad.web.repository.application;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.vividsolutions.jts.geom.Geometry;

import eu.daiad.web.domain.application.AccountEntity;
import eu.daiad.web.domain.application.AreaGroupMemberEntity;
import eu.daiad.web.domain.application.DeviceMeterEntity;
import eu.daiad.web.repository.BaseRepository;

@Repository
public class JpaSpatialRepository extends BaseRepository implements ISpatialRepository {

    @PersistenceContext(unitName = "default")
    EntityManager entityManager;

    @Override
    public Geometry getUserLocationByUserKey(UUID userKey) {
        // Get account
        TypedQuery<AccountEntity> accountQuery = entityManager.createQuery("select a from account a where a.key = :userKey",
                        AccountEntity.class).setFirstResult(0).setMaxResults(1);

        accountQuery.setParameter("userKey", userKey);

        List<AccountEntity> accounts = accountQuery.getResultList();

        if (accounts.isEmpty()) {
            return null;
        }

        // If account location is set, return it
        AccountEntity account = accounts.get(0);
        if (account.getLocation() != null) {
            return account.getLocation();
        }

        // Attempt to find user location from the meter
        TypedQuery<DeviceMeterEntity> meterQuery = entityManager.createQuery(
                        "select d from device_meter d where d.account.key = :userKey", DeviceMeterEntity.class).setFirstResult(0);

        meterQuery.setParameter("userKey", userKey);

        List<DeviceMeterEntity> meters = meterQuery.getResultList();

        for (DeviceMeterEntity meter : meters) {
            if (meter.getLocation() != null) {
                return meter.getLocation();
            }
        }

        return null;
    }

    @Override
    public List<AreaGroupMemberEntity> getAreasByAreaGroupKey(UUID groupKey) {
        TypedQuery<AreaGroupMemberEntity> areaQuery = entityManager.createQuery(
                        "select a from area_group_item a where a.group.key = :groupKey", AreaGroupMemberEntity.class)
                        .setFirstResult(0);

        areaQuery.setParameter("groupKey", groupKey);

        return areaQuery.getResultList();
    }

    @Override
    public List<AreaGroupMemberEntity> getAllAreas() {
        Integer utilityId = getCurrentUtilityId();

        if (utilityId == null) {
            return new ArrayList<AreaGroupMemberEntity>();
        }

        return getAllAreasByUtilityId(utilityId);
    }

    @Override
    public List<AreaGroupMemberEntity> getAllAreasByUtilityId(int utilityId) {
        TypedQuery<AreaGroupMemberEntity> areaQuery = entityManager.createQuery(
                        "select a from area_group_item a where a.utility.id = :utilityId", AreaGroupMemberEntity.class);

        areaQuery.setParameter("utilityId", utilityId);

        return areaQuery.getResultList();
    }

    @Override
    public List<AreaGroupMemberEntity> getAllAreasByUtilityKey(UUID utilityKey) {
        TypedQuery<AreaGroupMemberEntity> areaQuery = entityManager.createQuery(
                        "select a from area_group_item a where a.utility.key = :utilityKey", AreaGroupMemberEntity.class);

        areaQuery.setParameter("utilityKey", utilityKey);

        return areaQuery.getResultList();
    }
    
    @Override
    public AreaGroupMemberEntity getAreaByKey(UUID areaKey) {
        TypedQuery<AreaGroupMemberEntity> areaQuery = entityManager.createQuery(
                        "select a from area_group_item a where a.key = :areaKey", AreaGroupMemberEntity.class)
                        .setFirstResult(0).setMaxResults(1);

        areaQuery.setParameter("groupKey", areaKey);

        List<AreaGroupMemberEntity> areas = areaQuery.getResultList();

        if (areas.isEmpty()) {
            return null;
        }

        return areas.get(0);
    }
}
