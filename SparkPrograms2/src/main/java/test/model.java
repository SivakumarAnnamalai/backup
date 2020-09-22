package test;

class sample{
    void example(){
        System.out.println("test.sample case");
    }
}
public class model extends sample{
    void example(){
        System.out.println("test.model case");
    }

    public static void main(String args[]){
        model d = new model();
        sample a = new sample();
        a.example();
        d.example();
    }
}