/*
Responsible for reflecting the incoming data to all the clients attached to the socket at 1500
*/
package chathubber;
import java.net.*;

public class Server extends Thread {
	int i=0;

	public void run()
	{
		try
		{
			//SOCKET DOESNT NEET TO BE CLOSED AS THE PROCESS ITSELF IS TERMINATED
			ServerSocket serverSocket = new ServerSocket(1500);
			System.out.println("Server started.");

			while(true)
			{
				Socket clientSocket = serverSocket.accept();

				ChatHandler clientHandler = new ChatHandler(clientSocket, i);
				clientHandler.start();

				System.out.println("\nClient connected: " + clientSocket.getRemoteSocketAddress().toString());

				i++;
			}
			
		}
		catch(Exception e)
		{
		}
		
	}
}
