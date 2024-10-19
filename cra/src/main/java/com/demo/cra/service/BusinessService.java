package com.demo.cra.service;

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

}
