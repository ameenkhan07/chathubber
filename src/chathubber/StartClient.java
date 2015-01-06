package chathubber;
/*  Starts a new client
    This implementation incorporates all of the functionalities
    when 2 client are running it is in UNICAST MODE
    When more then 2 clients are working , it is conjointly working as a MULTICAST as well as  BROADCAST application
*/
    
public class StartClient
{
    public static void main(String args[])
    {
        Client client = new Client();
        client.start();
    }
}
