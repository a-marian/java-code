package abcde.enums;

public class Deer {
    enum Food {APPLES, BERRIES, GRASS}
    protected class Diet {
        private Food getFavorite(){
            return Food.APPLES;
        }
    }

    public static void main(String[] seasons){

        System.out.println(switch (new Deer().new Diet().getFavorite()){
            case APPLES -> "apples";
            case GRASS -> "grass";
            case BERRIES -> "berries";
        });
    }
}
