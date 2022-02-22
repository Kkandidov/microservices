package org.astashonok.library.services.impl;

import org.astashonok.library.entities.Subscription;
import org.astashonok.library.repositories.SubscriptionRepository;
import org.astashonok.library.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl extends AbstractCommonEntityService<Subscription>
    implements SubscriptionService {

  @Autowired
  private SubscriptionRepository subscriptionRepository;

  @Override
  protected JpaRepository<Subscription, Long> getRepository() {
    return subscriptionRepository;
  }

}
