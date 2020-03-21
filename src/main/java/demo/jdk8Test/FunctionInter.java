package demo.jdk8Test;

/**
 * 这里的泛型一般 extends 保证可以用一些方法
 * @param <T>
 */
@FunctionalInterface
public interface FunctionInter<T>{
    T apply(T t);
}
