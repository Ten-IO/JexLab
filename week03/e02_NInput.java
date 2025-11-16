/*
 *  Write a program to allow user to input N times of Number and find the values of average, max, min and sum
 */
package week03;

import java.util.Scanner;

public class e02_NInput {
    static float[] calc(float[] arr){
        float min = Float.MAX_VALUE, max = Float.MIN_VALUE, total = 0;
        for (float i : arr){
            total +=i;
            min = i < min?i:min;
            max = i >max?i:max;
        }
        return new float[]{max, min, total/arr.length, total};
    }
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            System.out.print("How many number to be input?\nNumber of input: ");
            int n = scan.nextInt();
            float arr[] = new float[n];
            for (int i = 0; i<n;i++){
                System.out.printf("Value #%d: ", i+1);
                arr[i] = scan.nextFloat();
            }
            float []res = calc(arr);
            System.out.printf("\nMax: %.2f%nMin: %.2f%nAverage: %.2f%nTotal: %.2f", res[0], res[1], res[2], res[3]);
        }catch(Exception e){
            System.out.println("[!] Error: " + e.getClass().getSimpleName());
        }
    }
}
