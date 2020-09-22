package test;

public class Q6 {
    public static void main(String args[]){
        One one = new Five();
        System.out.println(one.getX());
    }
}
class One{
    public String getX(){
        return "test.One";
    }
}
class Two extends One{
    public String getX(){
        return "test.Two";
    }
}
class Three extends One{
    public String getX(){
        return "test.Three";
    }
}
class Four extends One{
    public String getX(){
        return "test.Four";
    }
}
class Five extends One{
    public String getX(){
        return "test.Five";
    }
}