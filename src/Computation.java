import java.util.Scanner;
import java.util.*;
import java.math.BigInteger;

public class Computation {
    Scanner scanner = new Scanner(System.in);
    Integer radix = scanner.nextInt();
    String operation = scanner.next();
    String xstring = scanner.next(); //
    String ystring = scanner.next();
    Integer x=Integer.parseInt(xstring,radix);
    Integer y=Integer.parseInt(ystring,radix);
//    BigInteger x = new BigInteger(xstring,radix);
//    BigInteger y = new BigInteger(ystring,radix);
    int a, b, c = 0, r = 0, f;
    //a and b will be used as the digits of x and y
    //c is the carry
    //r is the result
    //f is the digit of the result
    String result;
    int j = String.valueOf(Math.max(x, y)).length();

    //j is the length of either x or y depending on which is bigger
    void compute() {
        System.out.println("f:  "+x);
        System.out.println("s: "+y);
        switch (operation) {
            case "[add]":
                System.out.println(addition(x, y));
                break;
            case "[subtraction]":
                System.out.println(subtraction(x, y));
                break;
            //result = Integer.toString(Integer.parseInt(Integer.toString(f), 10), radix);
            case "k":
                System.out.println(Integer.toString(karatsuba(x, y), radix));
                break;
            default:
                break;
        }

        //System.out.println(Integer.toString(r, radix)+ " " + r);
    }

    int addition(Integer x, Integer y) {
        for (double i = 0; i < j + 1; i++) {
            a=x%10;
            a = x % 10;
            b = y % 10;
            f = (a + b + c) % 10; //radix
            c = (a + b + c) / 10; //radix
            r = r + (f) * ((int) Math.pow(10, i));
            System.out.println(x + "  " + y);
            x = x / 10;
            y = y / 10;
        }
        return r;
    }

    /**
     *
     * @param x first number to subtract
     * @param y  second number to subtract
     * @return
     */
    int subtraction(int x, int y) {
        int x1;
        int y2;
        x1 = Math.max(x, y);
        y2 = Math.min(x, y);
        for (double i = 0; i < j + 1; i++) {

            a = x1 % 10;
            b = y2 % 10;
            f = (a - b - c) % 10;
            r = r + (10 - (f) * ((int) Math.pow(10, i)));
            System.out.println(x1 + "  " + y2);
            x1 = x1 / 10;
            y2 = y2 / 10;
            if (b > a) c = 1;
            else c = 0;

        }
        if (y > x) r = -r;
        r = x - y;
        return r;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    int multiplication(int x,int y) {
        return 1;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    int karatsuba(int x, int y) {
        //both numbers are only with one digit
        if (x < 10 && y < 10) {
            return x * y;
        }
        int length = String.valueOf(Math.max(x, y)).length();
        length=((length+1)/2 )*2;
      //lower half of the first number
        int x2 = 0;
        for (double i = 0; i < length/2 ; i++) {
            x2 = x2 + (x % 10) * (int) Math.pow(10, (i));
            if (x != 0) {
                x = x / 10;
            }
        }
        //higher half of the first number
        int x1 = 0;
        for (double i2 = 0; i2 < length; i2++) {
            x1 = x1 + (x % 10) * (int) Math.pow(10, (i2));
            if (x != 0) {
                x = x / 10;
            }
        }
        //lower part of the second number
        int y2 = 0;
        for (double i = 0; i < length / 2; i++) {
            y2 = y2 + (y % 10) * (int) Math.pow(10, (i));
            if (y != 0) {
                y = y / 10;
            }
        }
        //higher part of the second number
        int y1 = 0;
        for (double i2 = 0; i2 < length; i2++) {
            y1 = y1 + (y % 10) * (int) Math.pow(10, (i2));
            if (y != 0) {
                y = y / 10;
            }
        }
        System.out.println(x1 + "ss " + x2 + " ss " + y1 + y2);

        int p1 = karatsuba(x1, y1);
        int p2 = karatsuba(x2, y2);
        int p3 = karatsuba(x1 + x2, y1 + y2) - p1 - p2;
        return (p1 * (int) Math.pow(10, length)+ p3 * (int) Math.pow(10, length/2) + p2);
    }

    public static void main(String[] args) {
        Computation program = new Computation();
        program.compute();
    }
}