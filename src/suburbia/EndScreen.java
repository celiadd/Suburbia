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


public class EndScreen extends JFrame implements Runnable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	static int Xmiddle = gd.getDisplayMode().getWidth();
	static int Ymiddle = gd.getDisplayMode().getHeight();
	//BufferedImage bufferedImage = ImageIO.read(new File("images/FinalScreen.jpg"));




	JFrame EndFrame;
	JButton CloseButton;
	JButton RestartButton;
	JLabel myLabel;
	BufferedImage bufferedImage;
	ImageIcon ReplayIcon =new ImageIcon("images/misc/replaybutton.png");
	ImageIcon QuitIcon =new ImageIcon("images/misc/endgame.png");


	public void run(){
		EndFrame = new JFrame("Loading Suburbia");
		EndFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		EndFrame.setSize(Xmiddle, Ymiddle);
		EndFrame.setResizable(false);
		System.out.println(Xmiddle);
		JPanel myPanel = new JPanel(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g){

				// super.paintComponents(g);

				g.drawImage(GameBoard.finalBackground, 0, 0, this.getWidth(), this.getHeight(),null);
				//	g.drawImage(GameBoard.gameOver, 300, 300, 500, 400,null);
				System.out.println("I am in paint Component");
				g.setFont(new Font("Ariel", Font.BOLD, 50));
				g.setColor(Color.BLUE);
				g.drawString("YOUR FINAL SCORE",(Xmiddle/9)*3,(Ymiddle/8)*2);
				g.setFont(new Font("default", Font.BOLD, 75));
				g.setColor(Color.red);
				g.drawString("   "+GameBoard.totalStringScore,(Xmiddle/9)*4,(Ymiddle/8)*3);
				//g.drawString("TIME LEFT : "+GameBoard.totalStringTime,100,140);

			}


		};
		myPanel.setLayout(new GridLayout(20, 20,10,10));
		CloseButton = new JButton(QuitIcon);
		CloseButton.addActionListener(new ButtonListener());
		CloseButton.setEnabled(false);
		CloseButton.setBounds((Xmiddle/9)*2, (Ymiddle/8)*4, 190, 50);

		//RESTART GAME BUTTON
		RestartButton = new JButton(ReplayIcon);
		RestartButton.addActionListener(new RestartButton());
		RestartButton.setEnabled(true);
		RestartButton.setBounds((Xmiddle/9)*6, (Ymiddle/8)*4, 180, 55);
		EndFrame.add(RestartButton,BorderLayout.CENTER);
		EndFrame.add(CloseButton,BorderLayout.CENTER);
		EndFrame.add(myPanel);
		EndFrame.setVisible(true);
		EndFrame.repaint();
		EndFrame.setSize(Xmiddle,Ymiddle);
		FinalScreen();
		while (EndFrame.isShowing()){
			//System.out.println("Game Over Screen");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println("Thank you: Game Over");
	}

	void FinalScreen(){

		//myLabel.setText("Ready!!!");
		CloseButton.setEnabled(true);
	}
	class RestartButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			GameBoard BoardGetter = new GameBoard();
			BoardGetter.setTime(300);
			//BoardGetter.setScore(0);
			BoardGetter.ClearBoard();
			//BoardGetter.frame.setVisible(true);
			EndFrame.dispose();

		}

	}
	class ButtonListener implements ActionListener{
		//boolean ButtonWorks;
		public void actionPerformed(ActionEvent e) {
			System.exit(DISPOSE_ON_CLOSE);
			EndFrame.dispose();
			System.out.println("button is gone");

		}

	}

}

