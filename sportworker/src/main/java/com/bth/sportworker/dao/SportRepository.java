package com.bth.sportworker.dao;

import com.bth.sportworker.entity.Sport;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SportRepository extends MongoRepository<Sport, String> {
    List<Sport> findBySportName(String name);
}
