package chathubber;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import java.text.SimpleDateFormat;

public class GUI {
	JEditorPane editor;
	JFrame Frame;
	JScrollPane scrollPane;
	JTextField TextField;

	SimpleDateFormat sdf;

	String input = "";
	String them = "";
	String text = "";

	public GUI(final String username)
	{
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e) {
		}

		sdf = new SimpleDateFormat("HH:mm:ss");

		Frame = new JFrame(username);
		Frame.setLayout(null);
		Frame.setResizable(false);
		Frame.setSize(300,400);

		editor = new JEditorPane("text/html", text);
		editor.setEditable(false);
		Frame.add(editor);

		scrollPane = new JScrollPane(editor);
		scrollPane.setBounds(0,0,300,335);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Frame.add(scrollPane);

		TextField = new JTextField();
		TextField.setBounds(0,340,300,30);
		Frame.add(TextField);

		// Frame.setAlwaysOnTop(true);
		// Frame.setLocationRelativeTo(null);
		Frame.setVisible(true);
        TextField.requestFocusInWindow();

		TextField.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					input = TextField.getText();
					if(!input.equals(""))
					{
						String time = sdf.format(new Date());
						
						//DISPLAY THE MESSAGE TO THE GUI
						try
						{
							//Send message recieved by GUI to server
							Client.out.writeUTF(("<i>" + time + "</i> <b>" + username + ": </b>" + input));
						}
						catch (Exception ex)
						{

						}
//						Client.printmsg("<i>" + time + "</i> <b>" + username + ": </b>" + input);
						
						input = "<i>" + time + "</i> <b>You: </b>" + input;
						text = text + "<br>" + input;
						editor.setText(text);
						TextField.setText("");
					}
				}
            }
        });

		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void printanswer(String recieved)
	{
		them = recieved;
		text = text + "<br>" + them ;
		editor.setText(text);
	}
}
