package com.amazevalley.javatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AbstractMethodExample obj = new AbstractMethodCalling();
        obj.reverseString("Sanjeev");
        obj.swapNumbers(20,30);
        obj.stringContainsVowels("mnpltrszd");
        obj.printFibonacciSeries(5);
        Log.d("IS pRIME :", ""+obj.isPrime(5));
    }
}


//abstract class
abstract class AbstractMethodExample
{
    //abstract method declaration
    abstract void reverseString(String in);
    abstract boolean isPrime(int n);
    abstract void swapNumbers(int a, int b);
    abstract void stringContainsVowels(String val);
    abstract void printFibonacciSeries(int count);
}

class AbstractMethodCalling extends AbstractMethodExample
{

    @Override
    void reverseString(String in) {
        Log.d("Data :", "Called");
        if (in == null)
            throw new IllegalArgumentException("Null is not valid input");

        StringBuilder out = new StringBuilder();

        char[] chars = in.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--)
            out.append(chars[i]);
        Log.d("Result :", out.toString());
    }

    @Override
    boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    void swapNumbers(int a, int b) {
        b = b + a;
        a = b - a;
        b = b - a;
        Log.d("Swap Result :", a + " :: "+b);
    }

    @Override
    void stringContainsVowels(String input) {
        Log.d("Vowels :", ""+input.toLowerCase().matches(".*[aeiou].*"));
    }

    @Override
    void printFibonacciSeries(int count) {
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 1; i <= count; i++) {
            System.out.print(a + ", ");
            Log.d("FibonacciSeries:", a + " :: ");
            a = b;
            b = c;
            c = a + b;
        }
    }
}