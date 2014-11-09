package chathubber;
import java.net.*;
import java.util.*;
import java.io.*;

public class ClsServerChat extends Thread {
	int i=0;

	public void run()
	{
		try
		{
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
