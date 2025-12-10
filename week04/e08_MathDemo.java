package week04;

public class e08_MathDemo {
    class BasicMath {
        double addition(double a, double b) {
            return a + b;
        }
        double subtract(double a, double b) {
            return a - b;
        }
    }

    class AdvancedMath extends BasicMath {
        double multiply(double a, double b) {
            return a * b;
        }
        double divide(double a, double b) {
            if (b == 0)
                throw new ArithmeticException("Division by zero");
            return a / b;
        }
    }

    public static void main(String[] args) {
        BasicMath bm = new e08_MathDemo().new BasicMath();
        System.out.println(bm.addition(6, 9));
        System.out.println(bm.subtract(6, 9));

        AdvancedMath am = new e08_MathDemo().new AdvancedMath();
        System.out.println(am.addition(6, 9));
        System.out.println(am.subtract(6, 9));
        System.out.println(am.multiply(6, 9));
        System.out.println(am.divide(6, 9));
    }
}