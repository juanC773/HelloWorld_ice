package org.example;

import com.zeroc.Ice.Current;

public class CalculatorI implements Demo.Calculator {

   

    @Override
    public int add(int a, int b, Current current) {
        
        
        return  a+b;
    }


    
    
}
