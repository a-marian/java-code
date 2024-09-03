package daily.september;

/**
 * 1894. Find the Student that Will Replace the Chalk
 * We are given an array chalk where chalk[i] represents the amount of chalk required by the i-th student.
 * Starting from the first student, we distribute chal in order.
 * 1.- Calculate total chalk required per round
 * 2.- Reduce the chalk number with modulo operation
 * 3.- Find the student who runs out of chalk
 *    Iterate through the chalk array and substract each student's chalk requiremetn from the remaining chalk is less
 *    than the current student's chalk requirement, that is hte student who runs out of chalk requirement, that is the
 *    student who runs out of chalk.*/
public class ChalkReplacer {

    public int chalkReplacer(int[] chalk, int k){
        //Step 1: Claculate the total chalk needed for one complete round
        long totalChalk=0;
        for (int ch: chalk) {
            totalChalk += ch;
        }

        //Step 2: Find the remaining chalk after several complete rounds
        k %= totalChalk;

        //Step 3: Find which student will run out of chalk
        for (int i = 0; i < chalk.length; i++) {
            if(chalk[i] > k){
                return i;
            }
            k -= chalk[i];
        }
        //Should never reach here
        return -1;
    }
}

