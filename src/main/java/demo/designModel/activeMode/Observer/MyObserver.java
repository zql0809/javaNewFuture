package demo.designModel.activeMode.Observer;

public class MyObserver implements Observer {
    private String name;
    public MyObserver(String name){
        this.name = name;
    }
    @Override
    public void sayWord() {
        System.out.println(String.format("observer is %s working for you every time",this.name));

    }
}
