package demo;

import demo.guavaTest.GuavaUtils;
import demo.jdk8Test.NewFuture;

import java.util.Objects;

public class AppTest {
    public  static  void main(String[] atgs){
//        GuavaUtils myTest = new GuavaUtils();
//        myTest.testArrayListMultiMap();

        NewFuture myTestS = new NewFuture();
        myTestS.testCollectApi();
    }


}
