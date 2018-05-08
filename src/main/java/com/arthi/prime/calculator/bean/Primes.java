package com.arthi.prime.calculator.bean;

import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Primes {

    private Integer initial;
    private List<Integer> primes;

    public Primes() {
    }

    public Primes(final Integer initial, final List<Integer> primes) {
        this.initial = initial;
        this.primes = primes;
    }

    public Integer getInitial() {
        return initial;
    }

    public List<Integer> getPrimes() {
        return primes;
    }
    
    public void setInitial(Integer initial) {
        this.initial = initial;
    }

    public void setPrimes(List<Integer> primes) {
        this.primes = primes;
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o) 
            return true;
        if(o == null)
            return false;
        if(getClass() != o.getClass())
            return false;
        Primes primes = (Primes) o;
        return Objects.equals(initial, primes.getInitial()) && (getPrimes().containsAll(primes.getPrimes()) && primes.getPrimes().containsAll(getPrimes()));
    }

}
