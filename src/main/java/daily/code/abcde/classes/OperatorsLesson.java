package abcde.classes;

public class OperatorsLesson {
    private String name = "Fluffy";
    {System.out.println("setting field");}

    public OperatorsLesson(){
        name = "Tiny";
        System.out.println("setting constructor");
    }
    public static void main(String[] args){
        {  System.out.println("Feathers"); }
        OperatorsLesson ol = new OperatorsLesson();
        System.out.println(ol.name);
    }
    { System.out.println("Snowy");}
}
