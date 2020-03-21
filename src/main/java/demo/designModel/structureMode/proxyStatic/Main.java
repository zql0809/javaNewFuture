package demo.designModel.structureMode.proxyStatic;

import com.google.common.base.Strings;
import com.google.common.collect.Sets;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String [] args){

        Function<String,String> param = (x)->{
            String result = "";
            if (Strings.isNullOrEmpty(x)){
                result = "success";
            }else{
                if(x.length() >= 5){
                    result = Strings.padEnd(x, 8, '1');
                }else{
                    result = Strings.padStart(x, 8, '2');
                }
            }
            return result;
        };

        Consumer consumer = (x) ->{
            System.out.print(x);
        };

        MyOwnSubject myOwnSubject = new MyOwnSubject();
        Proxy proxy = new Proxy(myOwnSubject);
        proxy.proxyForMethod1(param, "zqlll", consumer);

    }
}
