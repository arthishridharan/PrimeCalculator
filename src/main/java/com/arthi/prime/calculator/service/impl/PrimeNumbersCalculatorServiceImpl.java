package com.arthi.prime.calculator.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.arthi.prime.calculator.bean.Primes;
import com.arthi.prime.calculator.service.PrimeNumbersCalculatorService;

@Service
public class PrimeNumbersCalculatorServiceImpl implements PrimeNumbersCalculatorService {

    private static Integer MIN_PRIME = 1;
    public static String MIN_NUMBER_ERROR = "Number supplied to generate prime series is less than expected minimum of 1";

    @Override
    public Primes getAllPrimeNumbersUptoGivenNumber(Integer maxNumber) {
        List<Integer> primesList =  IntStream.rangeClosed(MIN_PRIME, maxNumber)
                .filter(i -> isPrime(i))
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        Primes primes = new Primes(maxNumber, primesList);
        return primes;
    }
    
    private boolean isPrime(Integer number) {
        return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
    }

}
