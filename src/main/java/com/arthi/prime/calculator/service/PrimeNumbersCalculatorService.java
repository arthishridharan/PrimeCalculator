package com.arthi.prime.calculator.service;

import com.arthi.prime.calculator.bean.Primes;

/**
 * Service interface for generating prime number series upto and including the number supplied
 * @author arthi.shridharan
 *
 */
public interface PrimeNumbersCalculatorService {

    /**
     * Method to calculate prime numbers upto and including given number
     * @param maxPrime number upto which the prime series should be calculated
     * @return
     */
    Primes getAllPrimeNumbersUptoGivenNumber(final Integer maxPrime);

}
