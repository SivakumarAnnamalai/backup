package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by sivakumaran on 6/26/2016.
 */
public class Example<B> {
    B b;

    public <B> void printMe(B b){
        System.out.println(b.getClass().getName());
    }
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Example<Example> b = new Example<Example>();
        b.printMe("Hello World");
        b.printMe('c');
        b.printMe(new Example());

        int count=0,i=0;
        do{
            count+=i;
            i++;
            if(count>5)break;
        }while(i<=4);

        System.out.println("Count: "+count);

        /*FileInputStream f = new FileInputStream("store");
        ObjectInputStream in = new ObjectInputStream(f);
        Object obj = in.readObject();
        System.out.println(obj.getClass());*/

        


    }
}
