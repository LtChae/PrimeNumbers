package com.regant;

import java.util.*;
import java.lang.Math;

/**
 * Created by Timothy on 6/25/2015.
 */
public class PrimeNumberGen implements PrimeNumberGenerator{

    public static void main(String[] args) {
        int startingValue;
        int endingValue;

        if (args.length == 0){
            System.out.println("usage: com.regant.PrimeNumberGen startingValue endingValue");
            return;
        }

        try { startingValue = Integer.parseInt(args[0]);}
        catch (NumberFormatException e){
            System.out.println("Invalid argument " + args[0] + ". Arguments must be whole numbers");
            return;
        }

        try { endingValue = Integer.parseInt(args[1]);}
        catch (NumberFormatException e){
            System.out.println("Invalid argument " + args[1] + ". Arguments must be whole numbers");
            return;
        }

        PrimeNumberGen generator = new PrimeNumberGen();

        List<Integer> primes = generator.generate(startingValue, endingValue);

        System.out.println("There are " + primes.size() + " prime numbers between " + startingValue + " and " + endingValue + ":");
        System.out.println(primes.toString());
    }

    public List<Integer> generate(int startingValue, int endingValue){
        int maximum = Math.max(startingValue, endingValue);
        int minimum = Math.min(startingValue, endingValue);

        List<Integer> primeNumbers = new ArrayList<>();
        for (int number = minimum; number <= maximum; number++){
            if (isPrime(number)){
                primeNumbers.add(number);
            }
        }
        return primeNumbers;
    }

    public boolean isPrime(int value){
        if (value <= 0){
            return false;
        }
        for (int number = 2; number <= value / 2; number++) {
            if ((value % number) == 0) {
                return false;
            }
        }
        return true;
    }
}
