package com.demo.cra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo/v1")
public class DemoControllerV1 {

    @GetMapping("/health/check")
    public String healthCheck() {

        return "OK";

    }

}
