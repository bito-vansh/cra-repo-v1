package com.demo.cra.controller;

import com.demo.cra.dto.ResponseDtoV1;
import com.demo.cra.dto.UserDtoV1;
import com.demo.cra.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * Endpoint to check for duplicates in a list of integers.
     * Accepts a list of integers in the request body and returns a string
     * indicating whether duplicates were found or not.
     */
    @GetMapping(value = "/check/duplicate")
    public String checkDuplicate(
            @RequestBody List<Integer> numsList
    ) {

        boolean containsDuplicate = businessService.doesListContainDuplicates(numsList);

        if (containsDuplicate) {
            return "Duplicates found";
        } else {
            return "No duplicates found";
        }

    }

    /**
     * Endpoint to check if a given number is even or odd.
     * Accepts an integer parameter 'n' and returns a string indicating whether the number is even or odd.
     */
    @GetMapping(value = "/check/even")
    public String checkEven(
            @RequestParam(name = "n") Integer n
    ) {

        boolean isNumberEven = businessService.isNumberEven(n);

        if (isNumberEven) {
            return "Number is even";
        } else {
            return "Number is odd";
        }

    }

    /**
     * Creates a new user by processing the provided user data.
     * This endpoint handles POST requests to create a user, validates the input,
     * saves the user information, and returns an appropriate response.
     */
    @PostMapping(value = "/create/user")
    public ResponseEntity<?> createUser(
            @RequestBody UserDtoV1 userDto
    ) {

        ResponseDtoV1<?> responseDto = businessService.saveUserInfo(userDto);
        return new ResponseEntity<>(responseDto, responseDto.getHttpStatus());

    }

}
