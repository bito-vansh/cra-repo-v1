package com.demo.cra.controller;

import com.demo.cra.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class represents a REST controller for business-related operations.
 *
 * @author Vansh
 */
@RestController
@RequestMapping(value = "/business/v1")
public class BusinessControllerV1 {

    @Autowired
    private BusinessService businessService;

    /**
     * Endpoint for health check.
     * Returns "OK" to indicate the service is running.
     */
    @GetMapping("/health/check")
    public String healthCheck() {

        return "OK";

    }

    /**
     * Endpoint to check if a given number is prime.
     * This method handles GET requests to "/check/prime" and expects a query parameter "n".
     * It delegates the prime number check to the businessService.
     */
    @GetMapping("/check/prime")
    public String checkPrime(
            @RequestParam(name = "n") Integer n
    ) {

        return businessService.isNumberPrime(n);


    }

}
