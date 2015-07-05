/* This code fragement provides a method for getting
 * the time in java, which mainly use the 
 * java.time class provided by java8. 
 * For pre-Java-8, check the Date or Canlendar
 * also, third-party library Joda time
 */
import java.time.*;
import java.time.format.*;
public class TimeDemo{
    public static void main(String[] args){
        
        //Get the local time in the system
        LocalTime currentTime = LocalTime.now();

        /* getHour()
         * getMinute()
         * getSecond()
         * getNano()
        */

        //Simply print it out
        System.out.println("Time: " + currentTime);
        //Get parts of it
        System.out.println(currentTime.getHour() + ":" + currentTime.getMinute());

        /*Method for perform local time calculation
         * plusHours()
         * plusMinutes()
         * plusSeconds()
         * plusNanos()
         * minusHours()
         * minusMinutes()
         * minusSeconds()
         * minusNanos()
        */
        System.out.println("One hour before: " + currentTime.minusHours(1));

        //Obtains an instance of LocalTime from an hour minute Second
        LocalTime clock = LocalTime.of(23, 12, 34);
        System.out.println("Time: " + clock);

        // compareTo(LocalTime other))
        int result = currentTime.compareTo(clock);
        if(result == 0){
            System.out.println("What a conincidence.");
        }else if(result > 0){
            System.out.println("It is too late to apologize.");
        }else{
            System.out.println("The early the better.");
        }

        //Time Format Notice the difference between HH and hh
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String form = currentTime.format(formatter);
        System.out.println("Other format: " + form);
    }
}
/* Most of the classes in the Date-Time API create objects 
 * that are immutable, meaning that, after the object is created, 
 * it cannot be modified. To alter the value of an immutable object, 
 * a new object must be constructed as a modified copy of the original. 
 * This also means that the Date-Time API is, by definition, thread-safe. 
 * */
