package daily.agost.nested;

public class Ostrich {

    private static int count;
    static class OstrichWrangler{
        // static nested class can use variables in the class only if they are static
        public int stampade(){
            return count;
        }
    }
}
