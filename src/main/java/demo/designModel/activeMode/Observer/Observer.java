package demo.designModel.activeMode.Observer;

public interface Observer {
    public void sayWord();
    default void hehe(){
        System.out.print("fuck you !");
    }
}
