package test;

public class TestEx {
    static class Ex1 extends Exception{}
    static class Ex2 extends Ex1{ }
    static class Ex3 extends Exception{}

    static void method1()throws Ex1,Ex2,Ex3{
        throw new Ex2();
    }
    public static void main(String args[]){
        try{
            method1();
        }catch (Ex3 e){
            System.out.println("test.C");
        }catch (Ex2 e){
            System.out.println("test.B");
        }catch (Ex1 e){
            System.out.println("test.A");
        }catch (Exception e){
            System.out.println("D");
        }finally {
            System.out.println("F");
        }

    }
}