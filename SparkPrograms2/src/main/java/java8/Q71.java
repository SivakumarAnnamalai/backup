package java8;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Locale;

/**
 * Created by sivakumaran on 6/28/2016.
 */
public class Q71 {
    public static void main(String args[]) throws ParseException, IOException {
        String currencyValue = "10.000,25 DM";
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        //System.out.println(nf.parse(currencyValue).doubleValue());
        //System.out.format(currencyValue,"%00.000,00d");
        //System.out.println(Double.parseDouble(currencyValue));

        URL url = new URL("https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html");
        QName serviceName = new QName("urn:example","ExampleService");
        Service.create(url,serviceName);

        LocalTime time = LocalTime.now();
        LocalTime calcTime ;
        calcTime = time.plus(Duration.ofHours(10));
    }
}
