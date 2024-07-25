package daily.july;

import java.time.Year;
import java.util.Scanner;

public class LeapYearChecker {

    public static void main(String... args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int yearInput = scanner.nextInt();
        Year year = Year.of(yearInput);
        boolean isLeap  = year.isLeap();

        if(isLeap){
            System.out.println(yearInput + " is a leap year.");
        } else{
            System.out.println( yearInput +" is not a leap year ");
        }
        scanner.close();
    }
}
