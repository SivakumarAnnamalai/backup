package java8;

/**
 * Created by sivakumaran on 6/27/2016.
 */
public class Q136 {
    public static void main(String args[]){
        Z z = new TopLevel();
        z.call1();
    }
}
interface X{
    default void call1(){
        System.out.println("call1 - X");
    }
}
interface Y extends X{
    default void call1(){
        System.out.println("call1 - Y");
    }
}
interface Z extends X{}
class TopLevel implements Y,Z{
}



