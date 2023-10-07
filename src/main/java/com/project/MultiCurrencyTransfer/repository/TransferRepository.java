package com.project.MultiCurrencyTransfer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.project.MultiCurrencyTransfer.entity.Transfer;

@Repository
public interface TransferRepository extends MongoRepository<Transfer, String> {

}
