package daily.agost;

// https://leetcode.com/problems/number-of-senior-citizens/description/
public class SeniorsCounter {

    public int countSeniors(String[] details) {
        int seniorsCount = 0;
        for(String str: details){
            int age = Integer.parseInt(str.charAt(11)+""+str.charAt(12));
            if(age > 60){
                seniorsCount++;
            }
        }
        return seniorsCount;
    }

}
