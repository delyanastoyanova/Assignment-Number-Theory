import java.util.Scanner;
import java.util.*;

public class Computation {
    Scanner scanner = new Scanner(System. in);
    Integer radix = scanner. nextInt();
    String operation = scanner.next();
    String t = scanner.next();
    String p = scanner.next();
    Integer x=Integer.parseInt(t,radix);
    Integer y=Integer.parseInt(p,radix);
    int a, b, c = 0, r = 0, f;
    String result;
    int j = String.valueOf(Math.max(x, y)).length();
    void compute(){
        switch (operation) {
            case "[add]":
                for (double i = 0; i < j + 1; i++){

                    a = x % 10;
                    b = y % 10;
                    f =(a + b + c)%10;
                    c = (a + b + c) / 10;
                    r = r + (f) * ((int)Math.pow(10,i));
                    System.out.println(x+"  " +y);
                    x=x/10;
                    y=y/10;
                }
                break;
            case "[s]":
                int x1;
                int y2;
                x1 = Math.max(x,y);
                y2 = Math.min(x,y);
                for (double i = 0; i < j + 1; i++){

                    a = x1 % 10;
                    b = y2 % 10;
                    f =(a -b - c)%10;
                    r = r +(10- (f) * ((int)Math.pow(10,i)));
                    System.out.println(x1+"  " +y2);
                    x1=x1/10;
                    y2=y2/10;
                    if (b>a) c = 1;
                    else c = 0;

                }
                if (y>x) r = -r;
                r = x-y;
                break;
            //result = Integer.toString(Integer.parseInt(Integer.toString(f), 10), radix);
            case "k":
                System.out.println(Integer.toString(karatsuba(x,y), radix));
                break;
            default: break;
        }

        //System.out.println(Integer.toString(r, radix)+ " " + r);
    }
    int karatsuba(int x, int y){
        if (x<10 && y<10) return x*y;
        int j = String.valueOf(Math.max(x, y)).length();
        int xleng = j;
        int xrl = xleng;
        int yleng = j;
        int yrl = yleng;
        int x2=0;
        int x1=0;
        for (double i = 0; i <(xleng +1) /2 ; i++){
            x2 = x2 + (x%10)*(int)Math.pow(10,(i));
            if (x!=0) x=x/10;
        }
        xleng = String.valueOf(x).length();
        for (double i2 = 0; i2 < xleng; i2++){
            x1 = x1 + (x%10)*(int)Math.pow(10,(i2));
            if (x!=0) x=x/10;
        }
        int y2=0;
        int y1=0;
        for (double i = 0; i <(yleng+1)/2; i++){
            y2 = y2 + (y%10)*(int)Math.pow(10,(i));
            if(y!=0) y=y/10;
        }
        xleng = String.valueOf(y).length();
        for (double i2 = 0; i2 < yleng; i2++){
            y1 = y1 + (y%10)*(int)Math.pow(10,(i2));
            if(y!=0) y=y/10;
        }
        System.out.println(x1 + "ss " + x2 + " ss " + y1 + y2);

        int p1 = karatsuba(x1,y1);
        int p2 = karatsuba(x2,y2);
        int p3 = karatsuba(x1 + x2, y1 + y2) - p1 -p2;
        return  (p1*(int)Math.pow(10,(((xrl+1)/2)*2)) + p3 *(int)Math.pow(10,(xrl+1)/2) + p2);

    }

    public static void main (String[] args){

        Computation program = new Computation();
        program.compute();
    }
}