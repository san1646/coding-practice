package utils.concepts;

public class ChildClass1 extends  ParentClass1{

    public void print(){
        System.out.println("---ChildClass1---");
        System.out.println(this.getClass().getCanonicalName());
    }
}
