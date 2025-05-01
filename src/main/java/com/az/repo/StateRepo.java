package com.az.repo;


import com.az.model.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class StateRepo  {

    @Autowired
    private MongoTemplate mongoTemplate;

    public States saveState(Map<String, String> map) {
        States state = mongoTemplate.findOne(new Query(Criteria.where("_id").is("US_STATES")), States.class);
        if (state == null) {
            state = new States("US_STATES", new ConcurrentHashMap<>());
        }
        state.getStateMaps().putAll(map);
        return mongoTemplate.save(state);
    }


    public States getStateDetails() {
        return  mongoTemplate.findOne(new Query(Criteria.where("_id").is("US_STATES")), States.class);
    }
}
