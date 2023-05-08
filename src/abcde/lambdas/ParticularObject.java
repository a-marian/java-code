package abcde.lambdas;


@FunctionalInterface
interface MathSolver{
    byte apply();
}

@FunctionalInterface
interface PasswordGenerator{
    String generatePassword(String a, String b);
}

record User(String name, String lastName){
    public String createPassword(String a, String b){
        StringBuilder password = new StringBuilder();

        int len = Math.max(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if(i % 2 == 0 ){
                password.append(a.charAt(i));
            }else {
                password.append(b.charAt(i));
            }
        }
        return password.toString();
    }
}
public class ParticularObject {
    public static void main(String[] args) {
        Integer number = 14051987;
        MathSolver d =  number::byteValue;
        System.out.println(d.apply());

        User user = new User("Amy", "Winehouse");
        PasswordGenerator generator = user::createPassword;

        System.out.println(generator.generatePassword("feels", "good"));
    }

}
