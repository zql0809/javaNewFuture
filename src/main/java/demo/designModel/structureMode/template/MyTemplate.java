package demo.designModel.structureMode.template;

public class MyTemplate extends TemplateAbstract {
    public MyTemplate(String name){
        super(name);
    }
    @Override
    public void process() {
        System.out.println("-----------child processor-------------");
    }
}
