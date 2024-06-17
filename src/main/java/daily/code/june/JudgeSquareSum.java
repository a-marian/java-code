package daily.code.june;

public class JudgeSquareSum {

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(20));
    }
    public static boolean judgeSquareSum(int c){
        boolean result = false;
        if(c ==0 || c==1){
            return true;
        }
        int [] primes = new int[c];
        int index =0;
        for (int i = c; i > 0  ; i--) {
            if(c /i == 0){
                return result;
            }else{
                primes[index++] = c/i;
            }
        }
        int cmid = c/2;
        int aleft=cmid, aright=c-1;
        while(aleft <= aright){
            int la = primes[aleft]*primes[aleft];
            int rb = primes[aright]*primes[aright];
            if ((la + rb) == c ||
                    (0 + la) == c || (0 + rb) == c ||
                    (la + la) == c ||
                    ((primes[aright-1]*primes[aright-1])+(primes[aright]*primes[aright]))==c){
                return true;
            }else{
                aleft++;
                aright--;
            }
        }

        int bleft=0, bright=cmid-1;
       while(bleft <= bright){
           int la = primes[bleft]*primes[bleft];
           int rb = primes[bright]*primes[bright];
           if ((la + rb) == c ||
                   (0 + la) == c || (0 + rb) == c ||
                   (la + la) == c ||
                   ((primes[bright-1]*primes[bright-1])+(primes[bright]*primes[bright]))==c){
               return true;
           }else{
               bleft++;
               bright--;
           }
       }
       return result;
    }

    public boolean judgeSquareSumV2(int c){
        int root = (int) Math.sqrt(c);
        for (int a = 0; a <= root ; a++) {
            double b = Math.sqrt(c-(a*a));
            if(b==(int) b){
                return true;
            }
        }
        return false;
    }


}
