package test;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Locale;

public class test{
    public static void main(String args[]){

    }
}
class Person implements Comparable<Person>{
    private static final Collator collator = Collator.getInstance(Locale.ITALY);
    private final String lastname;
    private final CollationKey key;
    Person(String lastname){
        this.lastname=lastname;
        this.key = collator.getCollationKey(lastname);
    }
    @Override
    public int compareTo(Person person) {
        return key.compareTo(person.key);
    }
}