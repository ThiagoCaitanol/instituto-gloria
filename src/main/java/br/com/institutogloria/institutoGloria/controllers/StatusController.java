package br.com.institutogloria.institutoGloria.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping(path = "/on")
    public String check(){
        return "online";
    }

}