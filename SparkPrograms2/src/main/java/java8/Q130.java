package java8;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Q130 {
     public static void main(String args[]) throws ScriptException {
          ScriptEngineManager manager = new ScriptEngineManager();
          ScriptEngine engine = manager.getEngineByName("nashorn");
          String js = "JavaScript code is here";
          engine.eval(js);
     }
}


