package utils.concepts;

public class ChildClass2 extends  ParentClass1{

    public void print(){
        System.out.println("---ChildClass2---");
        System.out.println(this.getClass().getCanonicalName());
    }
}