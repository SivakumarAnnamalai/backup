package java8;

import test.Example;

/**
 * Created by sivakumaran on 6/27/2016.
 */
public class Q139 {
    public static void main(String args[]) throws Exception {
        try{
            throw new Exception();
        }catch (Exception e){
            System.out.println("Inside Catch");
            throw new Exception();
        }finally {
            System.out.println("Inside finally");
        }
    }
}
