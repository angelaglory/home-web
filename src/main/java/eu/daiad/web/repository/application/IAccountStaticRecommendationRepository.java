package eu.daiad.web.repository.application;

import java.util.List;
import java.util.UUID;

import org.joda.time.Interval;

import eu.daiad.web.domain.application.AccountEntity;
import eu.daiad.web.domain.application.AccountStaticRecommendationEntity;

public interface IAccountStaticRecommendationRepository
{
    AccountStaticRecommendationEntity findOne(int id);
    
    Long countAll();
    
    AccountStaticRecommendationEntity findLastForAccount(UUID accountKey);
    
    List<AccountStaticRecommendationEntity> findByAccount(UUID accountKey);
    
    Long countByAccount(UUID accountKey);
    
    List<AccountStaticRecommendationEntity> findByAccount(UUID accountKey, Interval interval);
    
    Long countByAccount(UUID accountKey, Interval interval);
    
    List<AccountStaticRecommendationEntity> findByType(int recommendationType);
    
    Long countByType(int recommendationType);
    
    List<AccountStaticRecommendationEntity> findByType(int recommendationType, Interval interval);
    
    Long countByType(int recommendationType, Interval interval);
    
    List<AccountStaticRecommendationEntity> findByAccountAndType(UUID accountKey, int recommendationType);
    
    Long countByAccountAndType(UUID accountKey, int recommendationType);
    
    List<AccountStaticRecommendationEntity> findByAccountAndType(UUID accountKey, int recommendationType, Interval interval);
    
    Long countByAccountAndType(UUID accountKey, int recommendationType, Interval interval);
    
    AccountStaticRecommendationEntity create(AccountStaticRecommendationEntity e);
    
    AccountStaticRecommendationEntity createWith(UUID accountKey, int recommendationType);
    
    AccountStaticRecommendationEntity createWith(AccountEntity account, int recommendationType);
    
    void delete(int id);
    
    void delete(AccountStaticRecommendationEntity e);
}
