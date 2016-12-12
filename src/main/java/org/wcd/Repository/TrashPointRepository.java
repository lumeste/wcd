package org.wcd.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.wcd.model.TrashPoint;

import java.math.BigInteger;


public interface TrashPointRepository extends MongoRepository<TrashPoint, BigInteger> {

}