package com.az.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.concurrent.ConcurrentHashMap;

@Document(collection = "states")
@Getter
@Setter
@AllArgsConstructor
public class States {
    @Id
    private String id;
    private ConcurrentHashMap<String,String> stateMaps;
}
