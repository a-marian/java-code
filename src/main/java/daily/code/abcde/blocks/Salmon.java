package abcde.blocks;

public class Salmon {
    int count;
    {System.out.print(count+"-");}
    {count++;}
    public Salmon(){
        count = 4;
        System.out.print(2+"-");
    }

    public static void assignmentExercise(){
        int Amount = 0b11;
        var amount2 = 0x10101; //  12
        int amount3 = 0xE; // 14
        int amount4 = 1_2; // 12
        double amount5 = 1_0.05;
        int amount6 = 0b101; // 5
        double amount7 = 9_2.1_2;
        double amount8 = 1_2_1.0_0;
        // prints int values
        System.out.println("amount2 = "+ amount2);
        System.out.println("amount4 = "+ amount4);
        System.out.println("Amount = "+ Amount);
        System.out.println("amount3 = "+ amount3);
        System.out.println("amount6 = "+ amount6);
    }
    public static void main(String[] args) {
        System.out.print(7+"-");
        var s = new Salmon();
        System.out.print(s.count+"-");
        assignmentExercise();
    }
}
