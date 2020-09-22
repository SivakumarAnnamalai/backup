package test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Java8 {
    public static void main(String[] args) throws Exception, UnknownHostException, SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // Q1
        //InetAddress ip = InetAddress.getByName("www.example.com");
        //System.out.println(ip+" "+ip.getHostAddress());

        // Q5
        List<String> list = new ArrayList<String>();
        list.add("Joe");
        list.add("James");
        list.add("Jack");
        Predicate<String> pred1 = name -> "Joe".equals(name);
        Predicate<String> pred2 = name -> "Jack".equals(name);
        list.removeIf(pred1.or(pred2));
        //System.out.println(list);

        //Q10
        //System.out.println(testVal(4)+" "+testVal(5)+" "+testVal(6));

        // Q11
        int[] Array1 = {3,6,2,9,5,8};
        int[] Array2 = Array1;
        int[] Array3 = Array2;
        Array1[2]=2;
        Array2[3]=5;
        Array3[4]=7;
        Array2[4]=Array3[4];
        //System.out.println(Array1[4]);

        // Q13
        /*Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con= DriverManager.getConnection("jdbc:oracle:thin:@John-pc:1521:xe","system","system");
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=stmt.executeQuery("select * from student");*/

        // Q16
        int i = (int)(Math.random()*100);
        //System.out.println(i);
        Random r = new Random();
        //System.out.println(r.nextInt(100));

        //Q20
        int x = Math.multiplyExact(2,32);
       // System.out.println(x);

        // Q21
        C c = new C();
        //c.a();


        //Q26
        String str1 = "My name is Billy";
        String str2 = "My name is NOT Billy";
        if(str1 == str2 ){
            System.out.println("test.A");
        }
        if(str1.equals(str2)){
            System.out.println("test.B");
        }

        //Q28
        LocalDateTime timePoint = LocalDateTime.now();
        LocalDateTime one = timePoint.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(one);
        LocalDateTime two = timePoint.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY));
        System.out.println(timePoint);

        int j =10;
        String s = new Integer(j).toString();
        System.out.println(s);

        int a=5;
        int b=0;
        try{
            int d=a/b;
            if(a>0) throw new Exception("First");
            if(d == 0 ) throw new Exception("Second");
            if(b == 0 ) throw new Exception("Third");
        }catch (IOException | ArithmeticException k){
            System.out.println(k.getMessage());
        }

        int i1=2;
        int i2=5;
        double d;
        d= (double)i1 / i2 ;
        System.out.println(d);

        Float f = new Float(3.1);
        Integer f1 = new Integer(1);
        long m=2;
        System.out.println(m+f+f1);
        System.out.println("Result is "+m+f+f1);
    }

    //Q10
    public static boolean testVal(int a){
        return (a>5);
    }
}
class A {
    public void a(){
        System.out.println("class test.A");
    }
}
class B extends A{
    public void a(){
        System.out.println("class test.B");
    }
}
class C extends B{
    public void a(){
        super.a();
        System.out.println("class test.C");
    }
}