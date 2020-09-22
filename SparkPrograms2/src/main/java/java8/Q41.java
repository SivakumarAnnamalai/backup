package java8;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Created by sivakumaran on 6/28/2016.
 */
public class Q41 {
    public static void main(String args[]) throws UnsupportedEncodingException {
        String asB64 = Base64.getEncoder().encodeToString("hello".getBytes("ascii"));
        System.out.println(asB64);
    }
}
