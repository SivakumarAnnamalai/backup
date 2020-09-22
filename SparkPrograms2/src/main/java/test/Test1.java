package test;

import java.util.HashSet;

/**
 * Created by sivakumaran on 6/20/2016.
 */


 class HashTest {

    private String str;

    public HashTest(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }

    @Override
    public int hashCode() {
        return this.str.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HashTest) {
            HashTest ht = (HashTest) obj;
            return this.str.equals(ht.str);
        }
        return false;
    }

    public static void main(String args[]) {
        HashTest h1 = new HashTest("1");
        HashTest h2 = new HashTest("1");
        String s1 = new String("2");
        String s2 = new String("2");

        HashSet<Object> hs = new HashSet<Object>();
        hs.add(h1);
        hs.add(h2);
        hs.add(s1);
        hs.add(s2);

        System.out.print(hs.size());
    }
}
