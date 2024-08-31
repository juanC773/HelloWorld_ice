module Demo
{
    class Response{
        long responseTime;
        string value;
    }
    interface Printer
    {
        Response printString(string s);
    }


     interface Calculator {
        int add(int a, int b);
    }
}