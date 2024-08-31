package org.example;

public class Server
{
    public static void main(String[] args)
    {
        java.util.List<String> extraArgs = new java.util.ArrayList<>();
        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args,"config.server",extraArgs))
        {
            // Adaptador para la impresora
            com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapter("Printer");
            com.zeroc.Ice.Object object = new PrinterI();
            adapter.add(object, com.zeroc.Ice.Util.stringToIdentity("SimplePrinter"));
            adapter.activate();

            // Adaptador para la calculadora
            com.zeroc.Ice.ObjectAdapter adapterCalculator = communicator.createObjectAdapter("calculatorAdapter");
            com.zeroc.Ice.Object objectCalculator = new CalculatorI();
            adapterCalculator.add(objectCalculator, com.zeroc.Ice.Util.stringToIdentity("Calculator"));  // Corregido el nombre de la identidad
            adapterCalculator.activate();

            // Esperar la señal de apagado
            communicator.waitForShutdown();
        }
    }
}
