package chathubber;
import javax.swing.JOptionPane;
import java.net.*;
import java.io.*;

public class Client extends Thread {
	static DataInputStream in;
	static DataOutputStream out;

	public void run()
	{
		try
		{
			// Conenect with server
			Socket objSocket = new Socket("127.0.0.1",1500);

			System.out.println("Connection established!!");

			in = new DataInputStream(objSocket.getInputStream());  //Input
			out = new DataOutputStream(objSocket.getOutputStream()); //Ouput

			String name = JOptionPane.showInputDialog("Chat Handle:");

			try
			{
				//Send message received by GUI to server
				out.writeUTF("Username=" + name);
			}
			catch (Exception e)
			{}

			GUI gui = new GUI(name);

			while(true)
			{
				//Send message received from server to GUI
				String msgFromServer = in.readUTF();
				gui.printanswer(msgFromServer);
			}
		}
		catch(Exception e)
		{
			System.out.println("Server not found.");
			System.exit(-1);
		}
	}

	// static void printmsg(String msgFromClient)
	// {
	// 	try
	// 	{
	// 		//Send message recieved by GUI to server
	// 		out.writeUTF(msgFromClient);
	// 	}
	// 	catch (Exception e)
	// 	{}
	// }
}
