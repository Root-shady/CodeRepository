/*  Code Fragment provides ways to get 
 *  date in Java, providing with different 
 *  format, mainly use the java.time package
 *  which is implemented in Java 8
 *
 * Pre Java 8, check in the java.date package and 
 * Calendar package, also Joda time package
 *
 *	   author: shady 
 *	   Date: 2015-07-05 Jul:07
 */ 
import java.time.*;
import java.time.format.*;
public class DateDemo{
    public static void main(String[] args){
        LocalDate date = LocalDate.now();
        System.out.println("Current Date:" + date);    

        /* getYear();
         * getMonthValue();  # Return type int
         * getMonth(); # Return type Month
         * getDayOfMonth();
         * getDayOfYear();
         *
         * isLeapYear(); #boolean type
         */
        //Print part of the date
        System.out.println("Month Day:"+date.getMonthValue()+" "+date.getDayOfMonth());

        //Create a Date with specific value
        /* of(int year, int month, int dayOfMonth)
         * of(int year, Month month, int dayOfMonth)
         */
        LocalDate appointment = LocalDate.of(2014, 05, 02);
        System.out.println("Appointment Date: " + appointment);
        
        String strDate = "2015-08-04";
        LocalDate aDate = LocalDate.parse(strDate);
        System.out.println("Date: " + aDate);
        
        //Use the DateTimeFormatter to format the date
        // Remenber to import the java.time.format package
        // Format method --> check my Gist for reference

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String one = date.format(formatter);
        System.out.println("Format Date: "+one);
    }
}
