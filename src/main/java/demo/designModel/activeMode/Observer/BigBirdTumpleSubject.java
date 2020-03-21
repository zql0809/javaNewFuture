package demo.designModel.activeMode.Observer;

import com.google.common.collect.FluentIterable;

public class BigBirdTumpleSubject extends AbstractSubject {

    @Override
    public void notified() {
        System.out.print("Subject Begin notified all Observer");
        System.out.println("all observer is be notify");
        FluentIterable.from(this.observerList).forEach((x)->{

            x.sayWord();
        });
    }

    public static  void main(String[] args){
        AbstractSubject bigBirdTumpleSubject = new BigBirdTumpleSubject();
        bigBirdTumpleSubject.addObserver(new MyObserver("qqq"));
        bigBirdTumpleSubject.addObserver(new MyObserver("www"));
        bigBirdTumpleSubject.addObserver(new MyObserver("eee"));
        bigBirdTumpleSubject.notified();
    }
}
