package abcde.strings;

import java.util.Arrays;

public class StringsHandle {

    private static void indentStrings(){
        var block = """
                a
                 b
                c""";

        var concat = " a\n"
                + "  b\n"
                +" c";

        System.out.println(block.length());
        System.out.println(concat.length());
        System.out.println(block);
        System.out.println(concat);
        System.out.println(concat.indent(1));

        System.out.println(concat.indent(-4));
        System.out.println(concat.stripIndent());
        System.out.println(concat);
    }

    private static void escapes(){
         var str = "1\\t2\\tpara";
        System.out.println(str);
        System.out.println(str.translateEscapes());
        System.out.println(str);
    }

    private static void format(){
        var name  = "Kate";
        var orderId = 5;
        var score = 90.30;
        var total = 100;
        System.out.println(String.format("Hello %s, order %s is ready", name, orderId));
        System.out.println("%s:%n Score: %f out of %d".formatted(name, score, total));
        var pi = 3.14159265359;
        System.out.format("[%f]",pi);
        System.out.format("[%12.2f]",pi);
        System.out.format("[%.3f]",pi);
    }

    private static void builder(){
        var sb = new StringBuilder("animals");
        sb.insert(7, "$");
        sb.insert(0, "-");
        sb.insert(4, "_");
        System.out.println(sb);
        sb.delete(1,3);
        sb.deleteCharAt(5);
        var builder = new StringBuilder("pigeon dirty");
        builder.replace(3,6, "STY");
        System.out.println(builder);
        System.out.println(builder.reverse());

        var builder2 = new StringBuilder("12345");
        System.out.println(builder2.charAt(4));
        System.out.println(builder2.replace(2,4,"6").charAt(3));
    }

    private static void printFish(){
        int numFish = 4;
        String fishType = "tuna";
        String anotherFish = String.valueOf(numFish +1);
        System.out.println(anotherFish+" "+fishType);
        System.out.println(numFish+" "+1);

    }

    public static void main(String[] args) {
       // indentStrings();
        //escapes();
        //format();
        //º builder();
       // purr();
       // printBase();
        //abcdef();
        //comparing();
        //reverseJava();
        printFish();
    }

    private static void reverseJava(){
        var way1 = new StringBuilder("Java");
        System.out.println(way1.reverse());
        var way2 = new StringBuilder("Java");
        System.out.println(way2.append("vaJ$").substring(3,way2.length()-1));
        var way3 = new StringBuilder("Java");
        System.out.println(way3.append("vaJ$").delete(0,3).deleteCharAt(way3.length()-1));
       // System.out.println(java.append("vaJ$").delete(0,3).deleteCharAt(java.length()));
    }
    private static  void  comparing(){
        String[] s1 = {"Camel", "Peaock", "Llama"};
        String[] s2 = {"Camel", "Llama", "Peacock"};
        String[] s3 = {"Camel"};
        String[] s4 = {"Camel", null};
        System.out.println(Arrays.compare(s1, s2));  // 4
        System.out.println(Arrays.mismatch(s1, s2)); // 1
        System.out.println(Arrays.compare(s3, s4));  // -1
        System.out.println(Arrays.mismatch(s3, s4)); // 1
        System.out.println(Arrays.compare(s4, s4));  // 0
        System.out.println(Arrays.mismatch(s4, s4)); // -1
    }
    private static void printBase(){
        var base = "ewe\nsheep\t";
        System.out.println(base);
        int length = base.length();
        int indent = base.indent(2).length();
        int translate = base.translateEscapes().length();
        System.out.println(length+" "+ indent+" "+ translate);
    }

    public static void roar(String roar1, StringBuilder roar2){
        roar1.concat("!!!");
        roar2.append("!!!");
    }

    private static void purr(){
        String s1 = """
                purr""";
        String s2 = "";
        s1.toUpperCase();
        s1.trim();
        s1.substring(1,3);
        s1 += "two";

        s2 += 2;
        s2 += 'c';
        s2 += false;

        if(s2 == "2cfalse") System.out.println("==");
        if(s2.equals("2cfalse")) System.out.println("equals");
        System.out.println(s1.length());


    }

    private static void abcdef(){
        var numbers = "012345678".indent(1);
        numbers = numbers.stripLeading();
        System.out.println(numbers.substring(1,3));
        System.out.println(numbers.substring(7,7));
        System.out.println(numbers.substring(7));

        String roar1 = "roar";
        StringBuilder roar2 = new StringBuilder("roar");
        roar(roar1, roar2);
        System.out.println(roar1+" "+ roar2);
    }


}
