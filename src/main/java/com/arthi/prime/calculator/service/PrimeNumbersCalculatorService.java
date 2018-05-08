package com.arthi.prime.calculator.service;

import com.arthi.prime.calculator.bean.Primes;

public interface PrimeNumbersCalculatorService {

    Primes getAllPrimeNumbersUptoGivenNumber(final Integer maxPrime);

}
