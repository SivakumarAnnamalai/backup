package test;

public class Sample {
    String name;
    private Sample(String name){
        this.name = name;
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    //@deprecated -- error line
    public static String getCompanyName(){
        return "Example";
    }
    public String getName(){
        return name;
    }
}