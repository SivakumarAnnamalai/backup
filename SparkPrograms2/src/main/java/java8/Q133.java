package java8;

/**
 * Created by sivakumaran on 6/27/2016.
 */
public class Q133 {
    public static void main(String args[]){
        TopLevel1 z = new TopLevel1();
        z.call1();
    }
}
interface X1{
    default void call1(){
        System.out.println("call1 - X1");
    }
}
interface Y1{
     void call1();
}
class TopLevel1 implements X1,Y1{
    public void call1(){
        System.out.println("call1 - TopLevel1");
    }
}


