package eu.daiad.web.repository.application;

import java.util.List;
import java.util.UUID;

import org.joda.time.Interval;

import eu.daiad.web.domain.application.AccountAnnouncementEntity;
import eu.daiad.web.domain.application.AccountEntity;
import eu.daiad.web.domain.application.AccountStaticRecommendationEntity;

public interface IAccountAnnouncementRepository
{
    AccountAnnouncementEntity findOne(int id);
    
    Long countAll();
    
    List<AccountAnnouncementEntity> findByAccount(UUID accountKey);
    
    Long countByAccount(UUID accountKey);
    
    List<AccountAnnouncementEntity> findByAccount(UUID accountKey, Interval interval);
    
    Long countByAccount(UUID accountKey, Interval interval);
    
    List<AccountAnnouncementEntity> findByType(int announcementType);
    
    Long countByType(int announcementType);
    
    List<AccountAnnouncementEntity> findByType(int announcementType, Interval interval);
    
    Long countByType(int announcementType, Interval interval);
    
    List<AccountAnnouncementEntity> findByAccountAndType(UUID accountKey, int announcementType);
    
    Long countByAccountAndType(UUID accountKey, int announcementType);
    
    List<AccountAnnouncementEntity> findByAccountAndType(UUID accountKey, int announcementType, Interval interval);
    
    Long countByAccountAndType(UUID accountKey, int announcementType, Interval interval);
    
    AccountAnnouncementEntity create(AccountAnnouncementEntity e);
    
    AccountAnnouncementEntity createWith(UUID accountKey, int announcementType);
    
    AccountAnnouncementEntity createWith(AccountEntity account, int announcementType);
    
    void delete(int id);
    
    void delete(AccountAnnouncementEntity e);
}
