package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

class Ideone {
    private static void main(String[] args) throws UnknownHostException {
        // Q1
        InetAddress ip = InetAddress.getByName("www.example.com");
        System.out.println(ip+" "+ip.getHostAddress());


    }
}