/**
 * My Math class with (add, subtract, multiply, divide, min, max) all accept 2 parameters. 
 */
package week03;

public class e05_mathClassI {
    static class MathI{
        static float add(float n1, float n2){
            return n1+n2;
        }
        static float subtract(float n1, float n2){
            return n1-n2;
        }
        static float multiply(float n1, float n2){
            return n1*n2;
        }
        static float divide(float n1, float n2){
            return n1/n2;
        }
        static float min(float n1, float n2){
            return n1<n2?n1:n2;
        }
        static float max(float n1, float n2){
            return n1>n2?n1:n2;
        }
    }

    public static void main(String args[]){
        float a = 3.5f, b=1.33f;
        System.out.println("== Math class showcase ==");
        System.out.println(MathI.add(a,b));
        System.out.println(MathI.subtract(a,b));
        System.out.println(MathI.multiply(a,b));
        System.out.println(MathI.divide(a,b));
        System.out.println(MathI.min(a,b));
        System.out.println(MathI.max(a,b));
    }
}
