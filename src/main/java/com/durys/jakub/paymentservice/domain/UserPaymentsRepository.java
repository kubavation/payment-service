package com.durys.jakub.paymentservice.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserPaymentsRepository extends MongoRepository<User, Long> {

}
