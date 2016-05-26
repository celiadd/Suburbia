package suburbia;



import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import java.util.GregorianCalendar;
public class View extends JPanel implements Runnable{	
	GameBoard BoardGetter = new GameBoard();
	ArrayList<PlantLocation> viewPlants = new ArrayList<PlantLocation>();

	//final int BoardGetter.Harvey.getFrameCount = 10;	
	//static BufferedImage MainCharacterPics[];

	public void paintComponent(Graphics g){
		//System.out.println("just entered paint");
		g.drawImage(BoardGetter.grassBackground, 0, 0, this.getWidth(), this.getHeight(),null);
		
		g.setColor(Color.BLACK);
		//int offset = BoardGetter.GameGrid.getSingleCellSize();
		//int stretchFac = BoardGetter.GameGrid.getStretchFactor();
		//int gridSizeY = BoardGetter.GameGrid.getGrid_Ysize();
		//int gridSizeX = BoardGetter.GameGrid.getGrid_Xsize();

		//horizontal
		//g.drawLine(BoardGetter.Boundaries.getLeftBound(),BoardGetter.Boundaries.getBottomBound(),BoardGetter.Boundaries.getRightBound(),BoardGetter.Boundaries.getBottomBound());
		//g.drawLine(BoardGetter.Boundaries.getLeftBound(),BoardGetter.Boundaries.getTopBound(),BoardGetter.Boundaries.getRightBound(),BoardGetter.Boundaries.getTopBound());
		//g.setFont(getFont().deriveFont(16));
		g.setColor(Color.black);
		g.fillRect(0, 0, 300, 90);
		g.setFont(new Font("default", Font.BOLD, 16));
		g.setColor(Color.green);
		g.drawString("CURRENT SCORE: " +BoardGetter.totalStringScore,10,20);
		g.drawString("TIME LEFT : "+BoardGetter.totalStringTime,10,40);
		g.drawString(BoardGetter.northDisplayString, 10, 60);
		g.drawString(BoardGetter.southDisplayString, 10, 80);
				
		
		//Planting Animation Section
		if (BoardGetter.PlantAnimation.IsVisible()){
			g.drawImage(BoardGetter.PlantAnimationPics[BoardGetter.PlantAnimation.getNextImage()], BoardGetter.PlantAnimation.getXlocation(), BoardGetter.PlantAnimation.getYlocation(), BoardGetter.PlantAnimation.getimgWidth(), BoardGetter.PlantAnimation.getimgHeight(),null);
		}
		//Planting Animation Section
		if (BoardGetter.DeleteAnimation.IsVisible()){
			g.drawImage(BoardGetter.DeleteAnimationPics[BoardGetter.DeleteAnimation.getNextImage()], BoardGetter.DeleteAnimation.getXlocation(), BoardGetter.DeleteAnimation.getYlocation(), BoardGetter.DeleteAnimation.getimgWidth(), BoardGetter.DeleteAnimation.getimgHeight(),null);
		}
		
		

		viewPlants.removeAll(viewPlants);
		viewPlants.addAll(BoardGetter.getPlantLocation());
		Iterator<PlantLocation> i = viewPlants.iterator();
		Plant[] plantArray = BoardGetter.getPlantArray();
		while(i.hasNext()){
			PlantLocation p = i.next();
			g.drawImage(p.getPlant().getImage()[p.getNextPic()], p.getX(), p.getY(),p.getPlant().getImgWidth(), p.getPlant().getImgHeight(),null);
		}
		//System.out.println(BoardGetter.getPlantLocation());

		//--------------------Animals ----------------------
		if (BoardGetter.AnimalMaker.getAnimalLocation().size()!=0){
			Iterator<AnimalLocations> iter = BoardGetter.AnimalMaker.AnimalLocation.iterator();
			while (iter.hasNext()){
				AnimalLocations AL = iter.next();
					g.drawImage(BoardGetter.AnimalMaker.getAnimalMap().get(AL.getKey()).getImages()[BoardGetter.AnimalMaker.getAnimalMap().get(AL.getKey()).getNextImage()],AL.getXLocation(),AL.getYLocation(), 100, 100, null);
				
				//g.drawImage(BoardGetter.AnimalMaker.getAnimal().getImages()[BoardGetter.AnimalMaker.getAnimal().getNextImage()], 500, 500, 100, 100, null);
			
			}
			
		}
		
		//Megacatterpillar section
		if (BoardGetter.Metapod.IsVisible()){
			if (BoardGetter.Metapod.getDirection()=="west"||BoardGetter.Metapod.getDirection()=="north"){
				g.drawImage(BoardGetter.MetapodPics[BoardGetter.Metapod.getNextPic()+0*BoardGetter.Metapod.getFrameCount()], BoardGetter.Metapod.getXlocation(), BoardGetter.Metapod.getYlocation(), BoardGetter.Metapod.getCaterpillarWidth(), BoardGetter.Metapod.getCaterpillarHeight(), null);
			}
			else if (BoardGetter.Metapod.getDirection()=="east"||BoardGetter.Metapod.getDirection()=="south"){
				g.drawImage(BoardGetter.MetapodPics[BoardGetter.Metapod.getNextPic()+1*BoardGetter.Metapod.getFrameCount()], BoardGetter.Metapod.getXlocation(), BoardGetter.Metapod.getYlocation(), BoardGetter.Metapod.getCaterpillarWidth(), BoardGetter.Metapod.getCaterpillarHeight(), null);
			}
		}
			
		//=================>//
		
		if (BoardGetter.Harvey.getDirection()=="east"){			
			g.drawImage(BoardGetter.MainCharacterPics[BoardGetter.Harvey.getNextPic()], BoardGetter.Harvey.getXlocation(), BoardGetter.Harvey.getYlocation(),BoardGetter.Harvey.getimgWidth(),BoardGetter.Harvey.getimgHeight(),null);

			
		}

		if (BoardGetter.Harvey.getDirection()=="west"){			
			g.drawImage(BoardGetter.MainCharacterPics[BoardGetter.Harvey.getNextPic()+1*BoardGetter.Harvey.getFrameCount()], BoardGetter.Harvey.getXlocation(), BoardGetter.Harvey.getYlocation(),BoardGetter.Harvey.getimgWidth(),BoardGetter.Harvey.getimgHeight(),null);

			
		}
		if (BoardGetter.Harvey.getDirection()=="north"){
			g.drawImage(BoardGetter.MainCharacterPics[BoardGetter.Harvey.getNextPic()+2*BoardGetter.Harvey.getFrameCount()], BoardGetter.Harvey.getXlocation(), BoardGetter.Harvey.getYlocation(),BoardGetter.Harvey.getimgWidth(),BoardGetter.Harvey.getimgHeight(),null);
			
		}
		if (BoardGetter.Harvey.getDirection()=="south"){			
			g.drawImage(BoardGetter.MainCharacterPics[BoardGetter.Harvey.getNextPic()+3*BoardGetter.Harvey.getFrameCount()], BoardGetter.Harvey.getXlocation(), BoardGetter.Harvey.getYlocation(),BoardGetter.Harvey.getimgWidth(),BoardGetter.Harvey.getimgHeight(),null);
			
		}

//	
		g.drawImage(BoardGetter.dirt, BoardGetter.Boundaries.getLeftBound(), BoardGetter.Boundaries.getBottomBound(),BoardGetter.SCREEN_WIDTH, BoardGetter.SCREEN_HEIGHT-BoardGetter.Boundaries.getBottomBound(), null);
		g.drawImage(BoardGetter.getSeedBagLocation().getSprite().getImage()[BoardGetter.getSeedBagLocation().getNextPic()], BoardGetter.getSeedBagLocation().getX(), BoardGetter.getSeedBagLocation().getY(), BoardGetter.getSeedBagLocation().getSprite().getImgWidth(), BoardGetter.getSeedBagLocation().getSprite().getImgHeight(), null);
		g.drawImage(BoardGetter.getShovelLocation().getSprite().getImage()[BoardGetter.getShovelLocation().getNextPic()], BoardGetter.getShovelLocation().getX(), BoardGetter.getShovelLocation().getY(), BoardGetter.getShovelLocation().getSprite().getImgWidth(), BoardGetter.getShovelLocation().getSprite().getImgHeight(), null);
		

		
		Iterator<SpriteLocation> k = BoardGetter.getSeedBackgrounds().iterator();
		while(k.hasNext()){
			SpriteLocation r = k.next();
			g.drawImage(r.getSprite().getImage()[r.getNextPic()], r.getX(), r.getY(),r.getSprite().getImgWidth(), r.getSprite().getImgHeight(),null);
		}
		for(int j = 0; j < BoardGetter.getGameSeeds().length; j++) {
			g.drawImage(BoardGetter.getGameSeeds()[j].getPlant().getImage()[BoardGetter.getGameSeeds()[j].getNextPic()], BoardGetter.getGameSeeds()[j].getX(), BoardGetter.getGameSeeds()[j].getY(), BoardGetter.getButtonImageSize(), BoardGetter.getButtonImageSize(), null);
		}

		//Power Up botton To be drawn on top of everything.
		
		if (BoardGetter.PowerUP.IsVisible()){
			g.drawImage(BoardGetter.PowerUpPics[0], BoardGetter.PowerUP.getXlocation(), BoardGetter.PowerUP.getYlocation(), BoardGetter.PowerUP.getimgWidth(), BoardGetter.PowerUP.getimgHeight(), null);
		}
		if (BoardGetter.Glow.IsVisible()){
			g.drawImage(BoardGetter.GlowPics[BoardGetter.Glow.getNextImage()], BoardGetter.Glow.getXlocation(), BoardGetter.Glow.getYlocation(), BoardGetter.Glow.getimgWidth(), BoardGetter.Glow.getimgHeight(), null);
			
		}
		

	}

	@Override
	public void run() {
		
		while (BoardGetter.frame.isShowing()&&BoardGetter.Executing()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();
		}
		
	}
}