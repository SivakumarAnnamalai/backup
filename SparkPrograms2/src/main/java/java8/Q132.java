package java8;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Q132 {
     public static void main(String args[]){
          List<JButton> list = new ArrayList<JButton>();
          JLabel label = new JLabel("Example");
          // Compilation Error on this line
          // list.add(label);
          System.out.println(list);
     }
}


