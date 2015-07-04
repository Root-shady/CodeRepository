/* This code fragement provides a method for getting
 * the time in java, which mainly use the 
 * java.time class provided by java8. 
 * For pre-Java-8, check the Date or Canlendar
 * also, third-party library Joda time
 */
import java.time.*;
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
    }
}
/* Most of the classes in the Date-Time API create objects 
 * that are immutable, meaning that, after the object is created, 
 * it cannot be modified. To alter the value of an immutable object, 
 * a new object must be constructed as a modified copy of the original. 
 * This also means that the Date-Time API is, by definition, thread-safe. 
 * */
