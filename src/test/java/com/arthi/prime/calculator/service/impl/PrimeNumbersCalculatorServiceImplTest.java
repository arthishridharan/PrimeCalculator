package com.arthi.prime.calculator.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.StringJoiner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.arthi.prime.calculator.bean.Primes;
import com.arthi.prime.calculator.service.PrimeNumbersCalculatorService;

/**
 * Unit tests for PrimeNumbersCalculatorServiceImpl
 * @author arthi.shridharan
 *
 */
@RunWith(Parameterized.class)
public class PrimeNumbersCalculatorServiceImplTest {

    private PrimeNumbersCalculatorService primeNumbersCalculatorService;
    private Integer number;
    private Primes primeSeries;

    public PrimeNumbersCalculatorServiceImplTest(Integer number, Primes primeSeries) {
        this.number = number;
        this.primeSeries = primeSeries;
    }

    @Parameters
    public static Collection<Object[]> bunchOfPrimes() {
        return Arrays.asList(new Object[][] { 
                    { 1, getPrimes(1, new Integer[] { 1 }) },
                    { 2, getPrimes(2, new Integer[] { 1, 2 }) },
                    { 3, getPrimes(3, new Integer[] { 1, 2, 3 }) },
                    { 5, getPrimes(5, new Integer[] { 1, 2, 3, 5 }) },
                    { 7, getPrimes(7, new Integer[] { 1, 2, 3, 5, 7 }) },
                    { 11, getPrimes(11, new Integer[] { 1, 2, 3, 5, 7, 11 }) },
                    { 13, getPrimes(13, new Integer[] { 1, 2, 3, 5, 7, 11, 13 }) },
                    { 17, getPrimes(17, new Integer[] { 1, 2, 3, 5, 7, 11, 13, 17 }) },
                    { 19, getPrimes(19, new Integer[] { 1, 2, 3, 5, 7, 11, 13, 17, 19 }) },
                    { 23, getPrimes(23, new Integer[] { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23 }) } });
    }

    private static Primes getPrimes(final Integer maxNumber, final Integer[] primes) {
        return new Primes(maxNumber, Arrays.asList(primes));
    }

    @Before
    public void setup() {
        primeNumbersCalculatorService = new PrimeNumbersCalculatorServiceImpl();
    }

    @Test
    public void testPrime() {
        Primes primes = primeNumbersCalculatorService.getAllPrimeNumbersUptoGivenNumber(this.number);
        StringJoiner sjExpected = new StringJoiner(",");
        StringJoiner sjActual = new StringJoiner(",");
        this.primeSeries.getPrimes().stream().forEach(i -> sjExpected.add(String.valueOf(i)));
        primes.getPrimes().stream().forEach(i -> sjActual.add(String.valueOf(i)));
        String message = "Expected prime series: " + sjExpected.toString() + " Actual prime series: " + sjActual.toString();
        assertEquals(message, this.primeSeries, primes);
    }

}
