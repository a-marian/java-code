package abcde.enums;

public class Bear {

    enum FOOD {
        BERRIES {
            @Override
            public boolean isHealthy() {
                return true;
            }
        },
        INSECTS {
            public boolean isHealthy(){return true; }},
        FISH {
            @Override
            public boolean isHealthy() {
                return true;
            }
        }, ROOTS{
            @Override
            public boolean isHealthy() {
                return true;
            }
        }, COOKIES{
            @Override
            public boolean isHealthy() {
                return false;
            }
        }, HONEY{
            @Override
            public boolean isHealthy() {
                return true;
            }
        };
        public abstract boolean isHealthy();
    }

    public static void main(String[] args ){
        System.out.println("Insects: "+ FOOD.INSECTS);
        System.out.println("Insects ordinal: "+ FOOD.INSECTS.ordinal());
        System.out.println("Insects isHealthy: "+ FOOD.INSECTS.isHealthy());
        System.out.println("Insects cookies is Healthy: "+ FOOD.COOKIES.isHealthy());
        System.out.println("Insects roots isHealthy: " +FOOD.ROOTS.isHealthy());

    }
}
