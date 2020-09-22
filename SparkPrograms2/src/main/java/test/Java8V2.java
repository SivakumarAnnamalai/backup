package test;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.time.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Java8V2 {
    private AtomicLong sample = new AtomicLong();
    static int deck[]=new int[26];
    static {
        for(int i=0;i<deck.length;i++)
            deck[i]=i;
        System.out.println("Finished Creating the deck");
    }
    public static void main(String[] args) throws Exception{



        //Q55
        String x = "> This is a test.test <";
        fix(x);
        System.out.println(x);

        // Q57
        //Socket socket = (new ServerSocket(8080)).accept();

        //Q59
        String urlString ="http://stackoverflow.com/questions/14860087/should-httpurlconnection-with-cookiemanager-automatically-handle-session-cookies";
        CookieHandler.setDefault(new CookieManager());
        URL url = new URL(urlString);
        URLConnection urlConnection = url.openConnection();
        System.out.println(url.getContent().toString());

        System.out.println(Clock.systemUTC());

        System.out.println(ZoneId.systemDefault());
        ZoneOffset z;


        //Q71
        String currencyValue = "10.000,25 DM";
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println();

        //Q77
        int a=5,b=7;
        int c=a+=2*3+b--;
        System.out.println(c);

        Java8V2 obj = new Java8V2();
        //Q74
        //java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
        //Runtime runtime = Runtime.getRuntime();

        Clock.systemUTC();

        List<String> status = Arrays.asList("Open","Closed","Pending");
        Collections.sort(status,(String s1,String s2)->{return -s1.compareTo(s2);});
        System.out.println(status);
        Collections.sort(status,((s1,s2)->-s1.compareTo(s2)));
        System.out.println(status);

        LocalTime time = LocalTime.now();
        LocalTime calcTime;
        //calcTime = time.plus(new Time(10,HOURS));


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(new StringBuffer("Hello\uD801\uDFFE"));
        byte bArray[]=baos.toByteArray();
        System.out.println(new String(bArray));





    }
    static void fix(String s){
        String t=s;
        t=t.trim();
        t=t.replace(' ','_');
        s=t;
        System.out.println(s);
    }

}
