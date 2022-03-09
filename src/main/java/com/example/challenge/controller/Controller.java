package com.example.challenge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {
    @GetMapping
    public String get(){
        return "Back-end Challenge 2021 🏅 - Space Flight News";
    }
}
