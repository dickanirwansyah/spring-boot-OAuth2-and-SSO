package com.dicka.springboot.demointegratedangular.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHallo {

    @RequestMapping(value = "/hallo")
    public ResponseEntity<String> getHalloCategoryPage(){
        return new ResponseEntity<String>("Ini page category", HttpStatus.OK);
    }

}
