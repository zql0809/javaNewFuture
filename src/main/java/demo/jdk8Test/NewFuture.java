package demo.jdk8Test;

import com.google.common.base.Strings;
import com.google.common.io.CharStreams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * jdk8 newFuture 新特性类似Fulentable的操作
 * jdk8是基于stream流的操作   java9新增了 takeWhile dropWhile
 * lambda表达式
 * 函数式接口
 * 20200311
 */
public class NewFuture {
    /**
     * 流的常用api
     */
    public void testStreamApi(){

    }

    /**
     * 收集器
     */
    public void testCollectApi(){
        Comparator<String> comparator = (x,y)->{
            return  1;
        };

        //toMap收集器
        Map<String,String> stringMap = Arrays.asList("qwe","asd","zxc").stream().map(String::toUpperCase).
                collect(Collectors.toMap(o -> o.toUpperCase(), s ->s.toLowerCase() ));
        stringMap.forEach((x,y)->{System.out.println("key:"+x+",value:"+y);});



    }

    /**
     * 函数式接口
     */
    public void functionApi(){
    }

}
