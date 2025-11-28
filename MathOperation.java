// MyExceptions.java
class TooLongAddition extends Exception { TooLongAddition(String msg){ super(msg); } }
class NegativeAnswer extends Exception { NegativeAnswer(String msg){ super(msg); } }
class TooLongMultiplication extends Exception { TooLongMultiplication(String msg){ super(msg); } }

// MathOperation.java
public class MathOperation {
    public int add(int a,int b) throws TooLongAddition {
        int r = a+b;
        if (r > 1000) throw new TooLongAddition("Addition > 1000");
        return r;
    }
    public int subtract(int a,int b) throws NegativeAnswer {
        int r = a-b;
        if (r < 0) throw new NegativeAnswer("Subtraction < 0");
        return r;
    }
    public int multiply(int a,int b) throws TooLongMultiplication {
        int r = a*b;
        if (r > 5000) throw new TooLongMultiplication("Multiplication > 5000");
        return r;
    }
    public int divide(int a,int b) {
        return a / b; // assume b!=0 for simplicity
    }

    public static void main(String[] args) {
        MathOperation m = new MathOperation();
        try {
            System.out.println("Add: " + m.add(400, 500));
            System.out.println("Sub: " + m.subtract(10,5));
            System.out.println("Mul: " + m.multiply(50,60)); // will throw
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
