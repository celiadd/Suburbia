package suburbia;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class SplashScreen extends JFrame implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	static int Xmax = gd.getDisplayMode().getWidth();
	static int Ymax = gd.getDisplayMode().getHeight();

	
	JFrame SplashFrame;
	JButton StartButton;
	JButton InstrButton;
	static BufferedImage menuBackground;
	//static BufferedImage InstructionOne = createImage("images/instr/instr1.png");
	//static BufferedImage InstructionTwo = createImage("images/instr/instr2.png");
	//static BufferedImage InstructionThree=createImage("images/instr/instr3.png");
	ImageIcon playButton; 
	ImageIcon instrButton;
	static int imageNum =0;
	static int imgControl = 4;
	SplashView start;
	
	
	public void run(){
		menuBackground = createImage("images/splash.png");
		playButton = new ImageIcon("images/misc/playnow.jpg");
		instrButton = new ImageIcon("images/misc/GameInstructions.png");
		
		StartButton = new JButton(playButton);
		//StartButton.setSize(50, 50);
		StartButton.setBounds((Xmax/100)*45,(Ymax/100)*30,230,70);
		StartButton.addActionListener(new ButtonListener());		
		StartButton.setEnabled(false);
		
		InstrButton = new JButton(instrButton);
		//InstrButton.setSize(50,50);
		InstrButton.addActionListener(new InstructionsListener());
		InstrButton.setBounds((Xmax/100)*48,(Ymax/100)*40,160,40);
		InstrButton.setEnabled(true);
		InstrButton.setVisible(true);
	
		JPanel mypanel = new JPanel(){
			protected void paintComponent(Graphics g){
				
				g.drawImage(SplashScreen.menuBackground, 0, 0, this.getWidth(), this.getHeight(),null);
				

			}
		};
		
		mypanel.setLayout(new GridLayout(20,20,10,10));
		SplashFrame = new JFrame("Loading Suburbia");
		SplashFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		SplashFrame.setSize(Xmax, Ymax);
		SplashFrame.setLocation(0,0);
		SplashFrame.setResizable(false);
		start = new SplashView();
		SplashFrame.add(start);
		
				

	 	//SplashFrame.add(StartButton, BorderLayout.NORTH);
		
		SplashFrame.add(StartButton,BorderLayout.CENTER);
		SplashFrame.add(InstrButton,BorderLayout.CENTER);
		SplashFrame.add(mypanel);
		SplashFrame.setVisible(true);
		SplashFrame.repaint();
		WaitToLoad();
		while (SplashFrame.isShowing()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void WaitToLoad(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StartButton.setEnabled(true);
		
	}
	class InstructionsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Thread instruct = new Thread(new Instructions());
			instruct.start();
		}
		
	}
	class ButtonListener implements ActionListener{
		//boolean ButtonWorks;
		public void actionPerformed(ActionEvent e) {			
			SplashFrame.dispose();				
		}		
	}	
	
	
	class SplashView extends JPanel{	
		protected void paintComponent(Graphics g){			
			g.drawImage(SplashScreen.menuBackground, 0, 0, this.getWidth(), this.getHeight(),null);
			

		}
	}
	
	private static BufferedImage createImage(String imageName){

		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File(imageName));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
