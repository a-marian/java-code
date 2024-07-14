package abcde.classes;

public class Counter {
    private static int count;
    public  int bulbSwitch(int n) {
        if (n == 0 ) return 0;
        if (n == 1) return 1;

        return Math.round((int)Math.sqrt(n));
    }

     final static void puppy(){return;}
    private int rain(){return 3;}

    final int song = 6;

    public void flute(String[] values, int... nums){}
    public void flute(String[] values, int puppies){
        int[][][][][][][][] a = new int[2][2][2][3][4][5][6][7];
    }

    public int juggle(boolean b, boolean... b2){ return b2.length; }

    public static void main(String[] args) {
        Counter count1 = new Counter();
        count1.juggle(true, true, false);
        count1.juggle(true, true, false);
        count1.juggle(true, new boolean[8]);

        /**
        Counter counter1 = new Counter();
        System.out.println(counter1.bulbSwitch(4));//2
        System.out.println(counter1.bulbSwitch(9));//3
        System.out.println(counter1.bulbSwitch(10));//3
        System.out.println(counter1.bulbSwitch(25));//5
        System.out.println(counter1.bulbSwitch(30));//5
        System.out.println(Math.sqrt(35));//5

        System.out.println(counter1.bulbSwitch(35));//6
        System.out.println(counter1.bulbSwitch(36));//6
        */
        /**
         * Counter counter2 = new Counter();
         *         Counter counter3 = new Counter();
         *         System.out.println(count);
         *         System.out.println(counter1.count);
         *         System.out.println(counter3.count);
         * */
    }
}
