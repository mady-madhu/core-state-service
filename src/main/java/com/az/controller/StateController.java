package com.az.controller;

import com.az.exception.StateNotFoundException;
import com.az.model.States;
import com.az.service.StateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/states")
public class StateController {
    private static final Logger logger = LoggerFactory.getLogger(StateController.class);
    private final StateService stateService;
    public StateController(StateService  stateService) {
        this.stateService = stateService;
    }

    @PostMapping("/createOrUpdate")
    public ResponseEntity<States> saveState(@RequestBody HashMap<String, String> states) {
        States savedState = stateService.createOrUpdate(states);
        return ResponseEntity.ok(savedState);
    }

    @GetMapping("/{stateCode}")
    public ResponseEntity<String> getStateDetails(@PathVariable String stateCode) throws StateNotFoundException {
        logger.info("inside controller");
        String stateDetails = stateService.getStateDetails(stateCode);
        return ResponseEntity.ok(stateDetails);
    }
}
