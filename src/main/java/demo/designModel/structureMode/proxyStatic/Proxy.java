package demo.designModel.structureMode.proxyStatic;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 静态代理模式
 *
 */
public class Proxy {
    /**使用has类型代理这个主题*/
    private  Subject subject;
    /**可以添加更多的主题*/

    public Proxy(Subject subject){
        this.subject = subject;
    }

    public <T> void proxyForMethod1(Function<T,String> t,T ts, Consumer consumer){
        String q = t.apply(ts);//这里可以传入一个任意的逻辑进程处理
        System.out.println(q);
        String result = subject.proxyForSomeOne(q);
        consumer.accept(result);//也可以处理上面得到的结果
    }

}
