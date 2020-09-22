package java8;


public class Q129 {
     public static void main(String args[]) {
     }
}

class ThreadUnSafe{
     public static int commonCounter =0;
     public static int getCount(){
          return commonCounter;
     }
     public void addCount(int val){
          commonCounter+=val;
     }
     public void subtractCount(int val){
          commonCounter-=val;
     }
}
