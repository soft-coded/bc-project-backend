package com.project.MultiCurrencyTransfer.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.project.MultiCurrencyTransfer.entities.Transfer;

@Repository
public interface TransferRepository extends MongoRepository<Transfer, String> {
  List<Transfer> findByUserId(String userId);
}
