package daily.july;

public class MaximumWinner {

        public int maximumGain(String s, int x, int y) {
            StringBuilder sb = new StringBuilder(s);
            String ba ="ba", ab="ab";
            int result=0;
            int stopDelete=0;
            while(stopDelete == 0 && sb.length() > 0){

                stopDelete=delete(sb, ba);
                result +=y;


                if (sb.length()>0){
                    stopDelete=delete(sb, ba);
                    result +=x;
                }
            }
            return result;
        }

        public int delete(StringBuilder sb, String subs){
            int start = sb.indexOf(subs);
            if(start < 0)
                return -1;
            sb.delete(start, start+subs.length());
            return 0;
        }
}
