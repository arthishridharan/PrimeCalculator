package com.arthi.prime.calculator.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arthi.prime.calculator.bean.Primes;
import com.arthi.prime.calculator.service.PrimeNumbersCalculatorService;

@RestController
public class PrimeCalculatorController {
    
    @Autowired
    private PrimeNumbersCalculatorService primeNumberCalculatorService;
    
    @Cacheable("byMaxNumber")
    @RequestMapping(value = "/primes/{maxNumber}", method = RequestMethod.GET, produces = { "application/json",
            "application/xml" }, consumes = MediaType.ALL_VALUE)
    public @ResponseBody Primes getPrimeNumbersUptoIncluding(@PathVariable Integer maxNumber) {
        return primeNumberCalculatorService.getAllPrimeNumbersUptoGivenNumber(maxNumber);
    }

}
