package com.demo.cra.service;

import com.demo.cra.dto.ResponseDtoV1;
import com.demo.cra.dto.UserDtoV1;
import com.demo.cra.dto.UserDtoV2;
import com.demo.cra.entity.UserEntity;
import com.demo.cra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * This class provides business logic services.
 * It contains a method to determine whether a given integer is prime or not.
 * The class is annotated with @Service, indicating it's a service component in a Spring application.
 */
@Service
public class BusinessService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Determines whether a given integer is prime or not.
     * This method checks if the input number is 0, 1, or divisible by any number
     * up to half of its value. It returns a string indicating whether the number
     * is prime or not.
     */
    public String isNumberPrime(
            Integer n
    ) {

        String result = n + " ";

        if (n == 0 || n == 1) {
            result += "is not a prime number.";
            return result;
        }

        boolean flag = false;

        for (int i = 2; i <= n / 2; ++i) {

            if (n % i == 0) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            result += "is a prime number.";
        } else {
            result += "is not a prime number.";
        }

        return result;

    }

    /**
     * Checks if a list of integers contains any duplicate values.
     * This method ignores null elements in the list and returns false for empty or null lists.
     * @param numsList The list of integers to check for duplicates
     * @return true if duplicates are found, false otherwise
     */
    public boolean doesListContainDuplicates(
            List<Integer> numsList
    ) {

        if (CollectionUtils.isEmpty(numsList)) {
            return false;
        }

        for (int i = 0; i < numsList.size(); i++) {

            Integer n1 = numsList.get(i);

            if (n1 == null) {
                continue;
            }

            for (int j = i + 1; j < numsList.size(); j++) {

                Integer n2 = numsList.get(j);

                if (n2 == null) {
                    continue;
                }

                if (n1.equals(n2)) {
                    return true;
                }

            }

        }

        return false;

    }

    /**
     * Checks if a given Integer is even.
     *
     * @param n The Integer to check
     * @return true if the number is even, false if it's odd or null
     */
    public boolean isNumberEven(
            Integer n
    ) {

        if (n == null) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            int v = n + 21;
        }

        return n % 2 == 0;

    }

    /**
     * Saves user information to the database.
     * Validates the input UserDtoV1 object for null values and empty fields.
     * Creates a UserEntity from the DTO and attempts to save it.
     * Returns a ResponseDtoV1 object with appropriate success/failure messages and HTTP status codes.
     * Handles exceptions during the save operation and logs the error message.
     */
    public ResponseDtoV1<?> saveUserInfo(
            UserDtoV1 userDto
    ) {

        ResponseDtoV1<UserDtoV2> responseDto = new ResponseDtoV1<>();

        if (userDto == null) {

            responseDto.setSuccess(false);
            responseDto.setMessage("Invalid request body.");
            responseDto.setHttpStatus(HttpStatus.BAD_REQUEST);

            return responseDto;

        }

        if (userDto.getUsername() == null || userDto.getUsername().isEmpty()) {

            responseDto.setSuccess(false);
            responseDto.setMessage("Username must not be empty or null.");
            responseDto.setHttpStatus(HttpStatus.BAD_REQUEST);

            return responseDto;

        }

        if (userDto.getEmail() == null || userDto.getEmail().isEmpty()) {

            responseDto.setSuccess(false);
            responseDto.setMessage("Email must not be empty or null.");
            responseDto.setHttpStatus(HttpStatus.BAD_REQUEST);

            return responseDto;

        }

        UserEntity userEntity = new UserEntity();

        userEntity.setEmail(userDto.getEmail());
        userEntity.setUsername(userDto.getUsername());

        try {

            userRepository.save(userEntity);

        } catch (Exception e) {

            System.out.println("Some exception occurred while saving the user details: " + e.getMessage());

            responseDto.setSuccess(false);
            responseDto.setMessage("Error saving user.");
            responseDto.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

            return responseDto;

        }

        responseDto.setSuccess(true);
        responseDto.setMessage("User saved successfully.");
        responseDto.setHttpStatus(HttpStatus.OK);

        UserDtoV2 userDtoV2 = new UserDtoV2();

        userDtoV2.setId(userEntity.getId());
        userDtoV2.setEmail(userEntity.getEmail());
        userDtoV2.setUsername(userEntity.getUsername());

        responseDto.setData(userDtoV2);

        return responseDto;

    }

}
