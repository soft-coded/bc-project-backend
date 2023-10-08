package com.project.MultiCurrencyTransfer.repositories;

import org.springframework.stereotype.Repository;

import com.project.MultiCurrencyTransfer.entities.Account;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

}
