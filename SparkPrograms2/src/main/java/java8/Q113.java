package java8;

/**
 * Created by sivakumaran on 6/27/2016.
 */
public class Q113 {
    public static void main(String args[]){
        Thread t = new MyThread(){
            public void run(){
                System.out.print("case");
            }
        };
        t.start();
    }
}
class MyThread extends Thread{
    MyThread(){
        System.out.print("Sample");
    }
    public void run(){
        System.out.print("example");
    }
    public void run(String s){
        System.out.print(" model");
    }
}
