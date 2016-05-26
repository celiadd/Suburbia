package suburbia;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Instructions implements Runnable{
	
	static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	static int Xmax = gd.getDisplayMode().getWidth();
	static int Ymax = gd.getDisplayMode().getHeight();

	JFrame InsFrame;
	JButton Next;
	JButton Back;
	JButton Close;
	JPanel myPanel;
	int pictureNumber;
	static int PIC_CONTROL=3;
	BufferedImage stepOne;
	BufferedImage stepTwo;
	BufferedImage stepThree;
	
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
	@Override
	public void run() {
		pictureNumber = 0;
		stepOne = createImage("images/instr/instr1.png");
		stepTwo = createImage("images/instr/instr2.png");
		stepThree = createImage("images/instr/instr3.png");		
		
		Next = new JButton("NEXT>>");
		Next.addActionListener(new NextListener());
		Next.setBounds((Xmax/100)*80, (Ymax/100)*1,100, 40);
		Next.setEnabled(true);
		
		Close = new JButton("EXIT");
		Close.addActionListener(new CloseListener());
		Close.setBounds((Xmax/100)*45, (Ymax/100)*1, 100, 40);
		Close.setEnabled(true);
		
		Back = new JButton("<<BACK");
		Back.addActionListener(new BackListener());
		Back.setBounds((Xmax/100)*10,(Ymax/100)*1,100,40);
		Back.setEnabled(false);
		
		myPanel = new JPanel(){
			protected void paintComponent(Graphics g){
				if (pictureNumber == 0)
					g.drawImage(stepOne, 0, 0, this.getWidth(), this.getHeight(),null);
				if (pictureNumber == 1)
					g.drawImage(stepTwo, 0, 0, this.getWidth(), this.getHeight(),null);
				if (pictureNumber == 2)
					g.drawImage(stepThree, 0, 0, this.getWidth(), this.getHeight(),null);
				

			}
		};
		myPanel.setLayout(new GridLayout(20,20,10,10));
		
		InsFrame = new JFrame ("INSTRUCTIONS");
		InsFrame.setAlwaysOnTop(true);
		InsFrame.setSize(Xmax, Ymax);
		InsFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		InsFrame.setResizable(false);
		
		InsFrame.add(Back,BorderLayout.CENTER);
		InsFrame.add(Close,BorderLayout.CENTER);
		InsFrame.add(Next,BorderLayout.CENTER);
		InsFrame.add(myPanel);
		InsFrame.setVisible(true);
		InsFrame.repaint();
		
		while (InsFrame.isShowing()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*protected void paintComponent(Graphics g){
		if (pictureNumber == 0)
			g.drawImage(stepOne, 0, 0, mypanel.getWidth(), this.getHeight(),null);
		if (pictureNumber == 1)
			g.drawImage(stepTwo, 0, 0, this.getWidth(), this.getHeight(),null);
		if (pictureNumber == 2)
			g.drawImage(stepThree, 0, 0, this.getWidth(), this.getHeight(),null);
		

	}*/

	class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			pictureNumber = (pictureNumber-1)%PIC_CONTROL;
			if (pictureNumber==0){
				Back.setEnabled(false);
			}
			Next.setEnabled(true);
			InsFrame.repaint();
			System.out.println("Instruction NUmber = "+pictureNumber);
		}
		
	}
	class CloseListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			InsFrame.dispose();
		}
		
	}
	class NextListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			pictureNumber=(pictureNumber+1)%PIC_CONTROL;
			if (pictureNumber==2){
				Next.setEnabled(false);
			}
			Back.setEnabled(true);
			InsFrame.repaint();
			System.out.println("Instruction NUmber = "+pictureNumber);
		}
		
	}
	
}
