package demo.designModel.structureMode.template;

/**
 * 设计模式 :模板模式抽象类将外部公共的方法定义好  子类继承该类就行了
 */
abstract class TemplateAbstract {
    protected String name;
    public TemplateAbstract(String name){
        this.name = name;
    }

    abstract public void process();

    public void parentProcess(){
        //可以定制不相同的公共处理父类逻辑
        System.out.println("------begin---------"+this.name+"------------------");
        process();
        System.out.println("------end------------"+this.name+"--------");
    }
}
