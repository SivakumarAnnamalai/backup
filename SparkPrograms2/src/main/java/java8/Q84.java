package java8;

/**
 * Created by sivakumaran on 6/28/2016.
 */
public class Q84 {
    public static void main(String args[]){
        double a =0.5;
        double b= 0.49999999999999994;
        print(a);
        print(b);
        print(a+b);
        print(1.0);

        //3fe0000000000000
        //3fdfffffffffffff
        //3ff0000000000000
        //3ff0000000000000
    }
    public static void print(double d){
        System.out.printf("%016x\n",Double.doubleToLongBits(d));
    }
}
