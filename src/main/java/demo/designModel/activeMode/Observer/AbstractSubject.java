package demo.designModel.activeMode.Observer;

import com.google.common.collect.Lists;

import java.util.List;

abstract class  AbstractSubject {
    public List<Observer> observerList = Lists.newLinkedList();
    /**温习一下interface和abstract 接口和抽象类的区别
     * 1.抽象类可以写构造函数  但是不能新建对象；接口没有构造函数
     * 2.抽象类可以有实现的方法；接口在1.8后也可以有default方法  Stream
     * 3.抽象类可以没有抽象方法  接口中默认的属性是public static final  方法则是public;1.9添加接口私有方法
     * */
    public AbstractSubject(){}

    /***
     * 温习一下
     * this  (本类的构造函数的调用，2.this指向本对象)
     * super(构造函数使用调用父类构造函数 必须放在子类构造函数方法里面的最前面
     *       2.对于子类覆盖了父类的方法,想在子类调用父类的方法)
     * @param observer
     */
    public void addObserver(Observer observer){
        this.observerList.add(observer);
    }

    public void deleteObserver(Observer observer){
        this.observerList.remove(observer);
    }

    public abstract void notified();
}
