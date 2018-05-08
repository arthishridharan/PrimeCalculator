package com.arthi.prime.calculator.bean;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class PrimesTest {
    
    private boolean isEqual;
    private Primes primeSeries1;
    private Primes primeSeries2;
    
    public PrimesTest(Primes primeSeries1, Primes primeSeries2, boolean isEqual) {
        this.primeSeries1 = primeSeries1;
        this.primeSeries2 = primeSeries2;
        this.isEqual = isEqual;
    }

    @Parameters
    public static Collection<Object[]> bunchOfPrimes() {
        Primes samePrimesObj = getPrimes(1, new Integer[] { 85 });
        return Arrays.asList(new Object[][] { 
                    { samePrimesObj, samePrimesObj, true },
                    { getPrimes(1, new Integer[] { 1 }), getPrimes(1, new Integer[] { 1 }), true },
                    { getPrimes(2, new Integer[] { 1 }), getPrimes(1, new Integer[] { 1 }), false },
                    { getPrimes(1, new Integer[] { 1, 3 }), getPrimes(1, new Integer[] { 3, 1 }), true },
                    { getPrimes(1, new Integer[] { 1, 3, 5 }), getPrimes(1, new Integer[] { 3, 1 }), false },
                    { getPrimes(1, new Integer[] { 1, 3, 5, 45, 47, 30 }), getPrimes(1, new Integer[] { 30, 1, 3, 45, 5, 47}), true },
                    { getPrimes(1, new Integer[] { 1, 3 }), getPrimes(1, new Integer[] { 30, 1, 3 }), false },
                    { getPrimes(1, new Integer[] { 1, 3, 5, 45, 47, 30 }), null, false }
                });
    }

    private static Primes getPrimes(final Integer maxNumber, final Integer[] primes) {
        return new Primes(maxNumber, Arrays.asList(primes));
    }

    @Test
    public void testEquals() {
        if(this.isEqual) {
            assertEqual(this.primeSeries1, this.primeSeries2);
        } else {
            assertNotEqual(this.primeSeries1, this.primeSeries2);
        }
    }
    
    public void assertEqual(Primes primeSeries1, Primes primeSeries2) {
        assertTrue(primeSeries1.equals(primeSeries2));
    }
    
    public void assertNotEqual(Primes primeSeries1, Primes primeSeries2) {
        assertFalse(primeSeries1.equals(primeSeries2));
    }

}
