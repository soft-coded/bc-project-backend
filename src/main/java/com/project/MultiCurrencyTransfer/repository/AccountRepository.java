package com.project.MultiCurrencyTransfer.repository;

import org.springframework.stereotype.Repository;
import com.project.MultiCurrencyTransfer.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface AccountRepository extends MongoRepository<Account, Integer> {

}
