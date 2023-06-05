package abcde.classes;

public class CoreAPI {

    public void stringMethod(){
        String s ="1";
        s +="2";
        s += "3";
        System.out.println(s);
        // result : 123
        var name  = "animals";
        System.out.println(name.indexOf("al"));
        System.out.println(name.indexOf("al",5));
        System.out.println(name.indexOf('a', 4));
        System.out.println(name.indexOf("al",2));

        var god= "Closer to God";
        System.out.println(god);
        System.out.println(god.startsWith("o"));
        System.out.println(god.startsWith("C"));
        System.out.println(god.startsWith("t"));
        System.out.println(god.endsWith("d"));
        System.out.println(god.contains("a"));
        System.out.println(god.contains("ser"));

        var text = "abc\t ";
        var text2 = "def\t ";
        System.out.print(text);
        System.out.println(text2);
        System.out.println(text.strip().length());
        System.out.println(text.trim().length());
        // to remove whitespace at the beginning of the string
        System.out.println(text.stripLeading().length());

        System.out.println(text.stripIndent().length());
        //to remove whitespace at the end of string
        System.out.println(text.stripTrailing().length());

        String block = """
                a
                 b
                c
                """;
        String concat = "a\n"
                    +" b\n"
                    +" c";
        System.out.println(block.length());
        System.out.println(block);
        System.out.println("----");
        System.out.println(block.indent(1).length());
        System.out.println(block.indent(1));
        System.out.println(concat.length());
        System.out.println(concat.indent(-1).length());
        System.out.println(concat.indent(-4).length());
        System.out.println(concat.stripIndent().length());
    }
    public void translatingScapes(){
        var str = "1\\t2";
        System.out.println(str);
        System.out.println(str.translateEscapes());
    }

    public void formatting(){
        var name = "Kate";
        var orderId = 5;
        System.out.println("Hello "+name+", order "+ orderId+" is ready");
        System.out.println(String.format("Hello %s, order %d is ready", name, orderId));
    }
    public void alpha(){
        String alpha = "";
        StringBuilder alphab = new StringBuilder();
        for(char current = 'a'; current <= 'z'; current++){
            alphab.append(current);
        }
        System.out.println(alphab);

        var sb = new StringBuilder("animals");
        String a = sb.substring(sb.indexOf("a"), sb.indexOf("al"));
        int len = sb.length();
        char ch = sb.charAt(6);
        System.out.println(a +" "+ len +" "+ ch);

        //append
        var sub = new StringBuilder().append(1).append('c').append("erebro");
        sub.append(" ").append(true).append(' ').append(2.34f);
        System.out.println(sub);

        //insert
        var in = new StringBuilder("diamond");
        in.insert(7, "-");
        in.insert(0, "-");
        in.insert(4, "-");
        System.out.println(in);
        //delete
        var del = new StringBuilder("fantasy");
        del.delete(5,6); //fanta
        del.deleteCharAt(2); //fata
        System.out.println(del);

        //replace portions
        var rep = new StringBuilder("pigeon dirty");
        rep.replace(3, 6, "sty");
        System.out.println(rep);
        rep.replace(5, 100, "");
        System.out.println(rep);
        //reverse
        var rev = new StringBuilder("Marianela Alex");
        rev.reverse();
        System.out.println(rev);

        var x = "Hello World";
        var y = "Hello World";
            //true
        System.out.println(x == y);
            //false
        var z = new String("Hello World");
        System.out.println(x == z);
        //true
        System.out.println(x == z.intern());
        //tricky
        System.out.println("tricky question ---");
        var first ="rat"+1;
        var second =  "r"+ "a"+"t"+"1";
        var third = "r"+"a"+"t"+new String("1");
        //first and second share  the same string pool reference, so it is true
        System.out.println(first == second);
        System.out.println(first == second.intern()); //true
        //we have a String constructor. This means we no longer have a compile-time constant and
        //third does not point to reference in the string pool. Therefore the result will be false.
        System.out.println(first == third); //false
        //the intern() call looks in the string pool, Java points to the same String and prints true.
         System.out.println(first == third.intern()); //false
    }
    public static void main(String[] args){
        CoreAPI coreAPI = new CoreAPI();
        //coreAPI.stringMethod();
        //coreAPI.translatingScapes();
        //coreAPI.formatting();
        coreAPI.alpha();
    }
}
