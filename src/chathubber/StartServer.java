package chathubber;
import java.net.*;
import java.io.*;

public class StartServer
{
	public static void main(String args[])
	{
		try (Socket s = new Socket("127.0.0.1", 1500))
		{
			//Server already exists. No operation is to be performed.
		}
		catch (IOException e)
		{
			Server server = new Server();
			server.start();
		}
	}
}
