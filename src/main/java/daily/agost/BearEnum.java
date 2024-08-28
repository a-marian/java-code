package daily.agost;

public class BearEnum {
    // as we have an abstract method, all enum instance should implement the method like it.
    enum FOOD{
        BERRIES {
            @Override
            public boolean isHealthy() {
                return false;
            }
        }, INSECTS{
            public boolean isHealthy(){
                return true;
            }
        },
        FISH {
            @Override
            public boolean isHealthy() {
                return false;
            }
        }, ROOTS {
            @Override
            public boolean isHealthy() {
                return false;
            }
        }, COOKIES {
            @Override
            public boolean isHealthy() {
                return false;
            }
        }, HONEY {
            @Override
            public boolean isHealthy() {
                return false;
            }
        };
        public abstract boolean isHealthy();
    }

    public static void main(String[] args) {
        System.out.println(FOOD.INSECTS); // INSECTS
        System.out.println(FOOD.INSECTS.isHealthy()); // true
        System.out.println(FOOD.INSECTS.ordinal()); // 1
        System.out.println(FOOD.COOKIES.isHealthy()); // false
    }
}
