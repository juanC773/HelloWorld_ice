package org.example;

import Demo.*;

public class Client {
    public static void main(String[] args) {
        java.util.List<String> extraArgs = new java.util.ArrayList<>();
        try (com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "config.client",
                extraArgs)) {
            // Proxy para SimplePrinter
            com.zeroc.Ice.ObjectPrx basePrinter = communicator.propertyToProxy("Printer.Proxy");
            PrinterPrx printer = PrinterPrx.checkedCast(basePrinter);
            if (printer == null) {
                throw new Error("Invalid proxy for PrinterI");
            }

            Response response = printer.printString("Hello, World!");
            System.out.println("Server Response Value: " + response.value);
            System.out.println("Server Response Time: " + response.responseTime);

            // Proxy para Calculator
            com.zeroc.Ice.ObjectPrx baseCalculator = communicator.propertyToProxy("Calculator.Proxy");
            CalculatorPrx calculator = CalculatorPrx.checkedCast(baseCalculator);
            if (calculator == null) {
                throw new Error("Invalid proxy for CalculatorI");
            }

            int result = calculator.add(10, 20);
            System.out.println("Result: " + result);
        }
    }
}
