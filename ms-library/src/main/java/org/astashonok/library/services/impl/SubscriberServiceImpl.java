package org.astashonok.library.services.impl;

import org.astashonok.library.entities.Subscriber;
import org.astashonok.library.repositories.SubscriberRepository;
import org.astashonok.library.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriberServiceImpl extends AbstractCommonEntityService<Subscriber>
    implements SubscriberService {

  @Autowired
  private SubscriberRepository subscriberRepository;

  @Override
  protected JpaRepository<Subscriber, Long> getRepository() {
    return subscriberRepository;
  }

}
