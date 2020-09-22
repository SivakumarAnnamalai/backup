package test;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class Internationalization {

    static void printDate(Locale locale){
        DateFormat formatter=DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
        Date currentDate=new Date();
        String date=formatter.format(currentDate);
        System.out.println(date+" "+locale);
    }
    static void printTime(Locale locale){
        DateFormat formatter=DateFormat.getTimeInstance(DateFormat.DEFAULT,locale);
        Date currentDate=new Date();
        String time=formatter.format(currentDate);
        System.out.println(time+" in locale "+locale);
    }

    static void printNumber(Locale locale){
        double dbl=105000.3245;
        NumberFormat formatter= NumberFormat.getNumberInstance(locale);
        String number=formatter.format(dbl);
        System.out.println(number+" for the locale "+locale);
    }

    static void printCurrency(Locale locale){
        double dbl=10500.3245;
        NumberFormat formatter=NumberFormat.getCurrencyInstance(locale);
        String currency=formatter.format(dbl);
        System.out.println(currency+" for the locale "+locale);
    }

    public static void main(String[] args) {
        printDate(Locale.UK);
        printDate(Locale.US);
        printDate(Locale.FRANCE);

        printTime(Locale.UK);
        printTime(Locale.US);
        printTime(Locale.FRANCE);

        printNumber(Locale.UK);
        printNumber(Locale.US);
        printNumber(Locale.FRANCE);
        printNumber(Locale.JAPAN);

        printCurrency(Locale.UK);
        printCurrency(Locale.US);
        printCurrency(Locale.FRANCE);


    }
}