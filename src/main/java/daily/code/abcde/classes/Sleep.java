package abcde.classes;

public final class Sleep {

    public final static String lol = "Hola";


    public static void snore() throws Exception {
        try{
            String sheep[] = new String[3];
            System.out.println(sheep[3]);
        }catch (RuntimeException|Error e){
            System.out.println("Awake!");
            throw e;
        } finally {
            throw new Exception();
        }
    }

    public static void main(String[] args) throws Exception {
        new Sleep().snore();
    }
}
