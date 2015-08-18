/* This code fragment takes in a domain name
 * and output the host name and the ip address
 * using the java.net.InetAddress class
 *	   author: shady 
 *	   Date: 2015-07-09 Jul:07
 */ 
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;
public class InetAddressDemo{
    public static void main(String[] args){
        String domain = args.length == 0 ? "localhost" : args[0];
        try{
            InetAddress address = InetAddress.getByName(domain);
            System.out.print("The Host name: " + address.getHostName() );

            //Returns the IP address string in textual presentation.
            System.out.println("\tThe Address: " + new String(address.getHostAddress()));
        }
        catch(UnknownHostException e){
            System.err.println("ERROR: " + e);
        }
    }
}
