package com.az.service;

import com.az.exception.StateCodeNotFoundException;
import com.az.exception.StateNotFoundException;
import com.az.model.States;
import com.az.repo.StateRepo;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StateService {

    private final StateRepo repository;

    public StateService(StateRepo repository) {
        this.repository = repository;
    }

    public States createOrUpdate(Map map){
        return repository.saveState(map);
    }


    public String getStateDetails(String code) throws StateNotFoundException {
        if(code.length() > 2){
           throw  new StateCodeNotFoundException("Statecode is more than 2 characterts");
        }
        States stateDetails = repository.getStateDetails();
        if(stateDetails == null || null==stateDetails.getStateMaps().get(code)){
            throw new StateNotFoundException("State NotFound::"+code);
        }
        return stateDetails.getStateMaps().get(code);
    }
}
