/*
 * My Math class with 
 * - factorial (a)
 * - surface cal for rectangle(a,b) and circle(r)
 * - min, max check 5 parameters. 
 */
package week03;

public class e06_mathClassII {
    static class MathII {
        static float factorial(float a) {
            if (a < 2)
                return 1;
            return a * factorial(--a);
        }
        static float rectangleSurface(float a, float b){
            return a*b;
        }
        static float circleSurface(float a){
            return (float)3.14*a*a;
        }
        static float min(float a, float b, float c, float d, float e){
            return a < b ?
            (a < c ?
                (a < d ?
                    (a < e ? a : e)
                : (d < e ? d : e))
            : (c < d ?
                    (c < e ? c : e)
                : (d < e ? d : e)))
        : (b < c ?
                (b < d ?
                    (b < e ? b : e)
                : (d < e ? d : e))
            : (c < d ?
                    (c < e ? c : e)
                : (d < e ? d : e)));
        }
        static float max(float a, float b, float c, float d, float e){
            float val = a;
            if(val<b) val=b;
            else if(val<c) val=c;
            else if (val<d) val=d;
            else if(val<e) val=e;
            return val;
        }
    }

    public static void main(String[] args) {
        float a = 6f, b = 3.3f, c = 3f, d = 4, e = 5;
        System.out.println("== Math class showcase ==");
        System.out.println(MathII.factorial(a));
        System.out.println(MathII.rectangleSurface(a, b));
        System.out.println(MathII.circleSurface(a));
        System.out.println(MathII.min(a, b, c, d, e));
        System.out.println(MathII.max(a, b, c, d, e));
    }
}
