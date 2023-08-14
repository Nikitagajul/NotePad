package FIle_Handling;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class Notepad1 extends JFrame implements ActionListener
{	
	Container cp;
	JMenuBar mbar;
	JMenu File,Edit;
	JMenuItem New,Open,Save,Exit,Cut,Copy,Paste;
	JTextArea ta;
	
	public Notepad1(String t)
	{
		super(t);
		cp=getContentPane();
		
		mbar=new JMenuBar();
		setJMenuBar(mbar);
		
		File=new JMenu("FIle");
		Edit=new JMenu("Edit");
		mbar.add( File);
		mbar.add( Edit);
		
		New=new JMenuItem("New");
		New.addActionListener( this);
		Open=new JMenuItem("Open");
		Open.addActionListener( this);
		Save=new JMenuItem("Save");
		Save.addActionListener( this);
		Exit=new JMenuItem("Exit");
		Exit.addActionListener( this);
		File.add( New);
		File.add( Open);
		File.add( Save);
		File.add( Exit);
		

		Cut=new JMenuItem("Cut");
		Cut.addActionListener( this);
		Copy=new JMenuItem("Copy");
		Copy.addActionListener( this);
		Paste=new JMenuItem("Paste");
		Paste.addActionListener( this);
		Edit.add( Cut);
		Edit.add( Copy);
		Edit.add( Paste);
		
		ta=new JTextArea();
		cp.add(ta);
		
		setSize(400,400);
		setVisible(true);	
	}

	public static void main(String[] args) 
	{
		new Notepad1("My NotePad");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==Cut)
				ta.cut();
		else if(e.getSource()==Copy)
			ta.copy();
		else if(e.getSource()==Paste)
			ta.paste();
		else if(e.getSource()==Exit)
			this.dispose();
		else if(e.getSource()==Open)
		{
			JFileChooser jc=new JFileChooser();
			if(jc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
			{
				File f=jc.getSelectedFile();
				FileInputStream fis;
				try {
				fis=new FileInputStream(f);
				String s="";
				int i;
				while((i=fis.read())!=-1)
				{
					s=s+(char)i;
				}
				ta.setText(s);
			}
				catch(FileNotFoundException e1)
				{
					e1.printStackTrace();
				}
				catch(IOException e1)
				{
					e1.printStackTrace();
				}
 			}
		}
		else if(e.getSource()==Save)
		{
			JFileChooser jc=new JFileChooser();
			if(jc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
			{
				File f=jc.getSelectedFile();
				
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(f);
					fos.write( ta.getText().getBytes());
					fos.close();
				} 
				
				catch (FileNotFoundException e1) {
 					e1.printStackTrace();
				}
				catch (IOException e1) {
 					e1.printStackTrace();
				}
				
				
 			}
		}		
	}
}


