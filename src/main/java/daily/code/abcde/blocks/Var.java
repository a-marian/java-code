package abcde.blocks;
/*
 * The type of var is know at compile time.
 * A var cannot be used as an instance variable.
 * The type of var cannot change at runtime.
 * */
public class Var {
    private String var;
    Var(){
        var = "var";
    }

    public static void main(String[] args) {
        Var var = new Var();
        System.out.println("Printing var var :"+ var.var);
        var localVariable = 123;
        System.out.println("Printing local variable "+ localVariable);

        var phrase = """
                    squirrel \s
                    pigeon   \
                    termite
                    """;
        System.out.print(phrase);

        var evening = 2; evening =0;
        // var morning=1/0; // possible declaration but NOT recommendable because it causes runtime error
        var hello = ""; hello = null; //after define hello as String, the value can change to null

        var number1 = Long.parseLong("120"); // primitive
        var number2 = Long.valueOf("130"); // wrapper value
        System.out.println(Long.max(number1, number2));

    }
}
