package suburbia;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.ToolTipManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.MouseInputListener;

import java.util.GregorianCalendar;



public class GameBoard implements Runnable{
	//Get the resolution of the local screen  ******************************
	static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	static int SCREEN_WIDTH = gd.getDisplayMode().getWidth();
	static int SCREEN_HEIGHT = gd.getDisplayMode().getHeight();
	//***********************************************************************
	MusicTheme TheFox;
	private static boolean executeThread;
	private static int MouseClick_X ;
	private static int MouseClick_Y ;
	boolean WasTheMouseClicked = false;
	boolean MainCreatureMove=false;
	boolean TimeOver=false;
	static boolean isBeingUsed = false;
	// Plant code
	static int NUMPLANTS = 20;
	static int NUMSEEDS = 5;
	private static Plant[] gamePlants = new Plant[NUMPLANTS];
	static ArrayList<PlantLocation> gamePlantLocations = new ArrayList<PlantLocation>();
	static PlantLocation[] gameSeeds = new PlantLocation[NUMSEEDS];
	static ArrayList<SpriteLocation> seedBackgrounds = new ArrayList<SpriteLocation>();
	static Seed seed;
	static SeedBag seedBag;
	static Shovel shovel;
	static boolean buttonCheck = false;
	
	static BufferedImage dirt;
	
	static SpriteLocation seedBagLocation;
	static SpriteLocation shovelLocation;
	
	static String northDisplayString;
	static String southDisplayString;
	static BufferedImage displayImage;
	
	private static String action = null;	
	static int BUTTONIMGSCALE = 60;
	final int REMOVEIMGWIDTH = 80;
	final int REMOVEIMGHEIGHT = 120;
	static int invasivePlantCount = 0;
	static Rectangle boundsArea;
	
	static Cursor cursor;
	// End plant code
	
	// Score:
	public static String totalStringScore= ""+0;
	public static String totalStringTime="";
	
	// Animal code
	static ArrayList<Animal> attracted = new ArrayList<Animal>();
	static AnimalFactory AnimalMaker;

	//Animation code
	static PlantingAnimation PlantAnimation;
	static RemovingAnimation DeleteAnimation;
	static PowerUpAnimation PowerUP;
	static GlowingAnimation Glow;
	//--------------------
	static JFrame Splash;
	static JFrame frame;
	View GameView;
	//image Arrays
	static BufferedImage MainCharacterPics[];
	static BufferedImage MetapodPics[];
	static BufferedImage PlantAnimationPics [];
	static BufferedImage DeleteAnimationPics[];
	static BufferedImage PowerUpPics[];
	static BufferedImage GlowPics[];
	
	//main creatures
	static MainCreature Harvey;
	static MegaCaterpillar Metapod;
	boolean MegaCatterpilarReady=false;
	JLabel Timelabel;
	static BufferedImage grassBackground;
	static BufferedImage finalBackground;

	//object to create the game boundaries
	static GardenBounds Boundaries;

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

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameBoard newGame = new GameBoard();
		newGame.startGame();
	}
	//Threads to be invoked in game:
	Thread MainThread;
	Thread SplashThread;
	Thread Caterpillar;
	Thread Animals;
	Thread view;
	//Thread MusicThing;
	void startGame(){
		MainThread = new Thread(new GameBoard());
		MainThread.start();
		setExecute(true);
	}
	public void run(){
		//Initialize everything that needs to be initialize before the frame is create
		SplashThread = new Thread(new SplashScreen());
		SplashThread.start();
		GameView = new View();
		Boundaries = new GardenBounds(this.SCREEN_WIDTH,this.SCREEN_HEIGHT);
		
		view = new Thread(GameView);
		GameView.addMouseListener(new MouseListenerClass());
		Harvey = new MainCreature();
		Harvey.setXlocation(Boundaries.getGardenWidth()/2);
		Harvey.setYlocation(Boundaries.getGardenHeight()/2);
		MainCharacterPics = Harvey.getMainCreatureImages();
		Metapod = new MegaCaterpillar();
		Metapod.setXlocation(Harvey.getXlocation());
		Metapod.setYlocation(Harvey.getYlocation());
		MetapodPics = Metapod.getCreatureImages();
		Metapod.setSpeed(Harvey.getSpeed()/3);
		Caterpillar = new Thread(Metapod);
		grassBackground =  createImage("images/grass1.png");
		finalBackground = createImage("images/FinalScreen.jpg");
		//plant animation section & other effects
		PlantAnimation = new PlantingAnimation();
		DeleteAnimation = new RemovingAnimation();
		PowerUP = new PowerUpAnimation();
		Glow = new GlowingAnimation();
		AnimalMaker = new AnimalFactory();
		PlantAnimationPics = PlantAnimation.getImages();
		DeleteAnimationPics = DeleteAnimation.getImages();
		PowerUpPics = PowerUP.getImages();
		GlowPics = Glow.getImages();
		Animals = new Thread(AnimalMaker);
		//Music section
	//	TheFox = new MusicTheme();
	//	Thread Music = new Thread (TheFox);
		// Plant set-up
		seed = new Seed();
		shovel = new Shovel();
		seedBag = new SeedBag();
		initializeGamePlants();
		boundsArea = new Rectangle(Boundaries.getLeftBound(), Boundaries.getTopBound(), Boundaries.getGardenWidth(), Boundaries.getGardenHeight());
		dirt = createImage("images/misc/grass3.png");
		northDisplayString = "Create a Garden!";
		southDisplayString = "Click on a Seed";
		//time label
		//String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	//	JLabel Datelabel = new JLabel(date);
	//	JLabel GameOverlabel = new JLabel("Game Over",JLabel.CENTER);
	//	Timelabel = new JLabel("Time Left" +String.valueOf(timeRemaining)+ "                            Score Label: ", JLabel.LEFT);
	//	Timelabel.setFont(Timelabel.getFont().deriveFont(64.0f));
	//	Timelabel.setForeground(Color.RED);
		
		frame = new JFrame("Suburbia: The Forest of Your Backyard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setLayout(new BorderLayout());
		frame.setIconImage(createImage("images/plants/RedMaple.png"));
		frame.add(BorderLayout.CENTER, GameView);
//		frame.add(BorderLayout.PAGE_END, new SouthMenuPanel());
	//	frame.add(BorderLayout.NORTH,Timelabel);
		while (SplashThread.isAlive()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // This is just a delay until splash screen is gone
		//-------------------------------------TIMER CODE STARTS----------------------------------
		countdownTimer = new Timer(1000, new CountdownTimerListener());
		countdownTimer.start();				
		//--------------------------------------TIMER CODE OVER---------------
		
		frame.setVisible(true);
		frame.setResizable(false);
		//System.out.println("here");		
		Caterpillar.start();
		view.start();

		System.out.println("Just right before animals get initialized");
		Animals.start();
		//Music.start();

		int LocalMouseX=0;
		int LocalMouseY=0;
		while (frame.isShowing()&&this.Executing()){
			frame.isActive();
			checkButtons(MouseClick_X,MouseClick_Y);
			if (WasTheMouseClicked){
				LocalMouseX=MouseClick_X;
				LocalMouseY=MouseClick_Y;
				System.out.println(	"MouseClicked: "+WasTheMouseClicked);							
				MainCreatureMove=true;	
				MoveTheCharacter(LocalMouseX-Harvey.getimgWidth()/2,LocalMouseY-Harvey.getimgHeight()/2);
				if (action != null&& action!="Shovel"){
					DoPlantingAction(LocalMouseX,LocalMouseY);
				}else if (action == "Shovel"){
					DoDeletingAction(LocalMouseX,LocalMouseY);
				}
				performAction(LocalMouseX,LocalMouseY);
				WasTheMouseClicked=false;
			}
			checkButtons(MouseClick_X,MouseClick_Y);
			updateInvasivePlants();
		}

	}

	//*******************************************************************
	void DoPlantingAction(int X, int Y){
		PlantAnimation.setVisible();
		PlantAnimation.setXlocation(X-PlantAnimation.getimgWidth()/2);
		PlantAnimation.setYlocation(Y-PlantAnimation.getimgHeight()/2);
		
		for (int i = 0; i < PlantAnimationPics.length;i++){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PlantAnimation.setNextPicture();
			if (!Metapod.IsVisible()){
				
				}
		}
		
		PlantAnimation.setInvisible();
	}
	void DoDeletingAction(int X, int Y){
		DeleteAnimation.setVisible();
		DeleteAnimation.setXlocation(X-DeleteAnimation.getimgWidth()/2);
		DeleteAnimation.setYlocation(Y-DeleteAnimation.getimgHeight()/2);
		
		for (int i = 0; i < DeleteAnimationPics.length;i++){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DeleteAnimation.setNextPicture();
			if (!Metapod.IsVisible()){
				
				}
		}
		
		DeleteAnimation.setInvisible();
	}
	boolean IsInsideGrid(int X,int Y){
		/*if (Y<GameView.getSize().getHeight()||Y>GameView.getSize().||X<GameGrid.getGridX_Origin()||X>GameGrid.getGridX_limit()){
			System.out.printf("Returning False Because: X= %d and Y= %d\n",X,Y);
			return false;
		}else return true;*/
		//****************************
		if (Y<Boundaries.getTopBound()||Y>Boundaries.getBottomBound()||X<Boundaries.getLeftBound()||X>Boundaries.getRightBound()){
			System.out.printf("Returning False Because: X= %d and Y= %d\n",X,Y);
			return false;
		}else return true;
	}
	
	
	void MoveTheCharacter(int X,int Y){
		//System.out.println("MoveTheCharacter Called");
		
		int XTarget=X;
		int YTarget=Y;
		
		if(Math.abs(Harvey.getXlocation()-X)<Harvey.getstopmovingoffset() && Harvey.getYlocation()<Y+Harvey.getstopmovingoffset()){
			XTarget=X;
			YTarget=Y-75;
		}
		
		else if(Math.abs(Harvey.getXlocation()-X)<Harvey.getstopmovingoffset() && Harvey.getYlocation()>Y+Harvey.getstopmovingoffset()){
			XTarget=X;
			YTarget=Y+75;
		}
		
		else if(Harvey.getXlocation()<X+Harvey.getstopmovingoffset()){
			XTarget=X-75;
			YTarget=Y;
		}
		
		else if(Harvey.getXlocation()>X+Harvey.getstopmovingoffset()){
			XTarget=X+75;
			YTarget=Y;
		}	
		
		else{
			XTarget=X;
			YTarget=Y;
		}
		
		while(MainCreatureMove){
			if (!Metapod.IsVisible()){
	
				}	
			Harvey.setNextPicture();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			//System.out.println("Harvey X_Location: "+Harvey.getXlocation()+"  XTarget: "+XTarget+" Harvey Y_Location: "+Harvey.getYlocation()+"  YTarget: "+YTarget);
			
			if ((Math.abs(Harvey.getXlocation()-XTarget))<Harvey.getstopmovingoffset() &&  (Math.abs(Harvey.getYlocation()-YTarget))<Harvey.getstopmovingoffset()){
				MainCreatureMove=false;
			}
			
			else if((Math.abs(Harvey.getXlocation()-XTarget))<Harvey.getstopmovingoffset() && YTarget<Harvey.getYlocation())	{
				Harvey.setYlocation(Harvey.getYlocation()-Harvey.getSpeed());
				Harvey.setDirection("north");
			}			
			else if((Math.abs(Harvey.getXlocation()-XTarget))<Harvey.getstopmovingoffset() && YTarget>Harvey.getYlocation())	{
				Harvey.setYlocation(Harvey.getYlocation()+Harvey.getSpeed());
				Harvey.setDirection("south");
			}			
			else if((Math.abs(Harvey.getYlocation()-YTarget))<Harvey.getstopmovingoffset() && XTarget<Harvey.getXlocation())	{
				Harvey.setXlocation(Harvey.getXlocation()-Harvey.getSpeed());
				Harvey.setDirection("west");
			}			
			else if((Math.abs(Harvey.getYlocation()-YTarget))<Harvey.getstopmovingoffset() && XTarget>Harvey.getXlocation())	{
				Harvey.setXlocation(Harvey.getXlocation()+Harvey.getSpeed());
				Harvey.setDirection("east");
			}
			
			else if(YTarget<Harvey.getYlocation())	{
				Harvey.setYlocation(Harvey.getYlocation()-Harvey.getSpeed());
				Harvey.setDirection("north");
			}			
			else if(YTarget>Harvey.getYlocation())	{
				Harvey.setYlocation(Harvey.getYlocation()+Harvey.getSpeed());
				Harvey.setDirection("south");
			}
		}			
	}
	
	//this function isn't doing anything! for now..
	public boolean IsThereCollision(int xpos, int ypos){
		if (xpos<0||ypos<0||(xpos)>MouseClick_X||(ypos)>MouseClick_Y){return true;}
		else return false;
	}
	//**************************************************************************	
		
	public Plant[] getPlantArray(){return gamePlants;}
	
	public ArrayList<PlantLocation> getPlantLocation(){return gamePlantLocations;}
	
	
	public String getNorthDisplayString(){return northDisplayString;}
	public void setNorthDisplayString(String nds){northDisplayString = nds; }
	public String getSouthDisplayString(){return southDisplayString;}
	public void setSouthDisplayString(String sds){southDisplayString = sds;}
	public BufferedImage getDisplayImage(){return displayImage;}
	public void setDisplayImage(BufferedImage di){displayImage = di;}
	
	
//*****************************************************************************
	/*
	 * Scoring Plants
	 */
	//int TotalScore;
	Score score = new Score();
	boolean oneShot = false;
	public int DisplayScore(){
		ArrayList<PlantLocation> plantLocationsCopy = new ArrayList<PlantLocation>();
		int TotalScore=0;
		plantLocationsCopy.addAll(gamePlantLocations);
		Iterator<PlantLocation> plantedIterator = plantLocationsCopy.iterator();
		while(plantedIterator.hasNext()){
			PlantLocation currentSprit = plantedIterator.next();
		//	temp+=currentSprit.getPlant().getName();
			for(int i = 0; i<20; i++){//there is 20 plants 
//					System.out.println("I am in for loop and name of the plant is : "+currentSprit.getPlant().getName());
				if (currentSprit.getPlant().getName()==score.plantScoring[i].name){
//						System.out.println("Name Matches I am in if loop");
//						System.out.println("RoundOneScore of "+score.plantScoring[i].name+" = "+score.plantScoring[i].RoundOneScore());
					TotalScore= TotalScore+score.plantScoring[i].FreeplayScore();
					totalStringScore="  "+TotalScore;
//						System.out.println(score.plantScoring[i].RoundOneScore());
//						System.out.println(TotalScore);
					if (!oneShot){
						if (TotalScore>200){
							PowerUP.setVisible();
							Glow.setVisible();
							oneShot=true;
							JOptionPane.showMessageDialog(frame, "You earned Mega Caterpillar!\nShe is a friend who will remove harmful plants from your garden.\nClick on the Glowing Icon to summon her.", "POWER-UP!", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(PowerUpPics[0]));
							}
					}
				}
			}
		}
//			System.out.println("*******I AM DISPLAYING SCORE");
//			System.out.println(TotalScore);
	//	System.out.println("I am from Scoring"+temp);
		return TotalScore;

	}
	//*****************************************************************************

	
	private void initializeGamePlants(){
		System.out.println(java.lang.Runtime.getRuntime().maxMemory()); 
		gamePlants[0] = new Aster();
		gamePlants[1] = new Azalea();
		gamePlants[2] = new BurningBush();
		gamePlants[3] = new ButterflyBush();
		gamePlants[4] = new ChristmasFern();
		gamePlants[5] = new CommonMilkweed();
		gamePlants[6] = new EasternRedCedar();
		gamePlants[7] = new JapaneseBarberry();
		gamePlants[8] = new JapaneseMaple();
		gamePlants[9] = new JoepyeWeed();
		gamePlants[10] = new NorwayMaple();
		gamePlants[11] = new OakleafHydrangea();		
		gamePlants[12] = new RedMaple();
		gamePlants[13] = new Sassafras();
		gamePlants[14] = new ScarletOak();
		gamePlants[15] = new Serviceberry();
		gamePlants[16] = new Spicebush();
		gamePlants[17] = new SweetPepperbush();
		gamePlants[18] = new WhiteOak();
		gamePlants[19] = new WinterberryHolly();
		
		Random random = new Random();
		
		/*gameSeeds[0] = new PlantLocation(240, Boundaries.getBottomBound(), gamePlants[random.nextInt(NUMPLANTS)]);
		gameSeeds[1] = new PlantLocation(310, Boundaries.getBottomBound()+20, gamePlants[random.nextInt(NUMPLANTS)]);
		gameSeeds[2] = new PlantLocation(380, Boundaries.getBottomBound(), gamePlants[random.nextInt(NUMPLANTS)]);
		gameSeeds[3] = new PlantLocation(450, Boundaries.getBottomBound()+20, gamePlants[random.nextInt(NUMPLANTS)]);
		gameSeeds[4] = new PlantLocation(520, Boundaries.getBottomBound(), gamePlants[random.nextInt(NUMPLANTS)]);

		seedBagLocation = new SpriteLocation(20, Boundaries.getBottomBound()-40, seedBag);
		shovelLocation = new SpriteLocation(570, Boundaries.getBottomBound()-30, shovel);

		seedBackgrounds.add(new SpriteLocation(190, Boundaries.getBottomBound()-45, seed)); 
		seedBackgrounds.add(new SpriteLocation(260, Boundaries.getBottomBound()-25, seed)); 
		seedBackgrounds.add(new SpriteLocation(330, Boundaries.getBottomBound()-45, seed)); 
		seedBackgrounds.add(new SpriteLocation(400, Boundaries.getBottomBound()-25, seed)); 
		seedBackgrounds.add(new SpriteLocation(470, Boundaries.getBottomBound()-45, seed)); */		
		
		gameSeeds[0] = new PlantLocation(300, SCREEN_HEIGHT-120, gamePlants[random.nextInt(NUMPLANTS)]);
		gameSeeds[1] = new PlantLocation(370, SCREEN_HEIGHT-110, gamePlants[random.nextInt(NUMPLANTS)]);
		gameSeeds[2] = new PlantLocation(440, SCREEN_HEIGHT-120, gamePlants[random.nextInt(NUMPLANTS)]);
		gameSeeds[3] = new PlantLocation(510, SCREEN_HEIGHT-110, gamePlants[random.nextInt(NUMPLANTS)]);
		gameSeeds[4] = new PlantLocation(580, SCREEN_HEIGHT-120, gamePlants[random.nextInt(NUMPLANTS)]);
		
		seedBagLocation = new SpriteLocation(-20, SCREEN_HEIGHT - 150, seedBag);
		shovelLocation = new SpriteLocation(630, SCREEN_HEIGHT - 160, shovel);

		seedBackgrounds.add(new SpriteLocation(250, SCREEN_HEIGHT - 160, seed));
		seedBackgrounds.add(new SpriteLocation(320, SCREEN_HEIGHT - 150, seed)); 
		seedBackgrounds.add(new SpriteLocation(390, SCREEN_HEIGHT - 160, seed)); 
		seedBackgrounds.add(new SpriteLocation(460, SCREEN_HEIGHT - 150, seed)); 
		seedBackgrounds.add(new SpriteLocation(530, SCREEN_HEIGHT - 160, seed));
	}
	
	
	public ArrayList<SpriteLocation> getSeedBackgrounds(){return seedBackgrounds;}
	public SpriteLocation getShovelLocation(){return shovelLocation;}
	public SpriteLocation getSeedBagLocation(){return seedBagLocation;}
	
	public PlantLocation[] getGameSeeds(){return gameSeeds;}
	public int getButtonImageSize(){return BUTTONIMGSCALE;}
	
	private void checkButtons(int x, int y){
		for(int i = 0; i < gameSeeds.length; i++){
			if(buttonCheck){
				//check Seeds
				Rectangle checkArea = new Rectangle(gameSeeds[i].getX(),gameSeeds[i].getY(),BUTTONIMGSCALE,BUTTONIMGSCALE);
				if(checkArea.contains(new Point(x,y))){
					action = gameSeeds[i].getPlant().getName();
					setCustomCursor(gameSeeds[i].getPlant().getImage()[gameSeeds[i].getNextPic()], new Point(15,15),gameSeeds[i].getPlant().getName());
					
					northDisplayString = "Now Planting: "+gameSeeds[i].getPlant().getName();
					southDisplayString = "From: "+ gameSeeds[i].getPlant().getNativeRegion();
					
					Random random = new Random();
					gameSeeds[i].setPlant(gamePlants[random.nextInt(NUMPLANTS)]);
					buttonCheck=false;
					if(WasTheMouseClicked){
						WasTheMouseClicked = false;
					}
				}
				//check Shovel
				checkArea = new Rectangle(shovelLocation.getX(),shovelLocation.getY(), shovelLocation.getSprite().getImgWidth(), shovelLocation.getSprite().getImgHeight());
				if(checkArea.contains(new Point(x,y))){
					action = shovelLocation.getSprite().getName();
					setCustomCursor(shovelLocation.getSprite().getImage()[shovelLocation.getNextPic()],new Point(15,15), shovelLocation.getSprite().getName());
					
					northDisplayString = "Now using the Shovel";
					southDisplayString = "Click to remove plants";
					
				}
			}
		}
	}
	
	
	
	private void performAction(int constantX,int constantY){
			if(action!=null){
				
				if(action.equalsIgnoreCase("Shovel")){
					// removes Sprite if click is anywhere within image bounds
					Rectangle removeArea = new Rectangle();
					//Iterator<PlantLocation> spriteIterator = gamePlantLocations.iterator();
					
					while(this.IsIsBusy()){
						try {
							Thread.sleep(83);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					Iterator<PlantLocation> spriteIterator = gamePlantLocations.iterator();
					while(spriteIterator.hasNext()){
						PlantLocation currentSprite = spriteIterator.next();
						removeArea.setBounds(currentSprite.getX(), currentSprite.getY(), currentSprite.getPlant().getImgWidth(), currentSprite.getPlant().getImgHeight());
						if(removeArea.contains(new Point(constantX, constantY))){
							System.out.println("Removed " + currentSprite.getPlant().getName() + " at " + currentSprite.getLocation());
							spriteIterator.remove();
			
							
							}
							//System.out.println(gamePlantLocations);
							Collections.sort(gamePlantLocations);
							DisplayScore();
						}
					this.setBeingUse(false);
				}
				else{
					for(int i = 0; i < gamePlants.length; i++){
						if(gamePlants[i].getName().equals(action)){
							// Add plant
//							System.out.println("Adding a " +gamePlants[i].getName()+" at "+ (constantX-(gamePlants[i].getImgWidth()/2))+ (constantY-(gamePlants[i].getImgHeight()-30)));
//							gamePlantLocations.add(new PlantLocation(constantX-(gamePlants[i].getImgWidth()/2), constantY-(gamePlants[i].getImgHeight()-30),gamePlants[i]));
							addPlantLocation(constantX-(gamePlants[i].getImgWidth()/2), constantY-(gamePlants[i].getImgHeight()-30),gamePlants[i]);

							//System.out.println(gameSprites);
							Collections.sort(gamePlantLocations);
							//System.out.println(gameSprites);
							
							
						}
					}
				}
			}

	}
	
	public boolean addPlantLocation(int x, int y, Plant plant){
		
		int CHECKPIXELRANGE = 10;
		int CHECKPIXELRANGEMULTIPLIER = 2;
		int SOUTHBOUNDSOFFSET = 180;
		int NORTHBOUNDSOFFSET = 20;
		PlantLocation checkLocation;
		int upperCheckX;
		int upperCheckY;
		boolean addPlant = false;
		
		upperCheckX = x - CHECKPIXELRANGE;
		upperCheckY = y - CHECKPIXELRANGE;
		
		
		Rectangle checkArea = new Rectangle(upperCheckX, upperCheckY, CHECKPIXELRANGE * CHECKPIXELRANGEMULTIPLIER, CHECKPIXELRANGE * CHECKPIXELRANGEMULTIPLIER);
		System.out.println("X is "+x+" Y is "+y+ " Check area is " +checkArea + " max x is " + (x+plant.getImgWidth())+ " max y is "+(y+plant.getImgHeight()));
		
		// check within gameboard bounds

		
		
		System.out.println(boundsArea.contains(new Point(x,y)));
		if(x < boundsArea.getMinX() || (x + plant.getImgWidth()) > boundsArea.getMaxX() || y + plant.getImgHeight() < boundsArea.getMinY() + NORTHBOUNDSOFFSET || y + plant.getImgHeight() > boundsArea.getMaxY() + SOUTHBOUNDSOFFSET){
		addPlant = false;
			System.out.println("Bounds area is " + boundsArea +"Plant location is out of bounds");
			return addPlant;
		}
		while(this.IsIsBusy()){
			try {
				Thread.sleep(83);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		// check if existing plant in area
		Iterator<PlantLocation> plantLocIterator = gamePlantLocations.iterator();
		

		
		if(!plantLocIterator.hasNext()){
			addPlant = true;
			System.out.println("Plant Iterator has no plants");
		}
		
		
		while(plantLocIterator.hasNext()){
			checkLocation = plantLocIterator.next();
			if(checkArea.contains(checkLocation.getLocation())){
				addPlant = false;
				System.out.println("Check area contains" + checkLocation.getLocation());
				return addPlant;
			}else{
				addPlant = true;
			}
		}
		this.setBeingUse(false);
		if(addPlant){
			gamePlantLocations.add(new PlantLocation(x, y,plant));
			System.out.println("Adding a "+plant.getName()+ " at "+x+", "+y);
		}
		return addPlant;
	}

	private void updateInvasivePlants(){

		int INVASIVELOCATIONOFFSET = 3;
		int INVASIVETICKSTOSPREAD = 4000000;
		int INVASIVEPLANTLIMIT = 20;
		int INVASIVEDIRECTIONS = 4;

		invasivePlantCount = 0;
		
		Iterator<PlantLocation> plantLocationIterator;

		ArrayList<PlantLocation> tempInvasives = new ArrayList<PlantLocation>();
		
		if(!Metapod.IsVisible()){
			
			while(this.IsIsBusy()){
				try {
					Thread.sleep(73);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			plantLocationIterator = gamePlantLocations.iterator();
			while(plantLocationIterator.hasNext() && invasivePlantCount<INVASIVEPLANTLIMIT){
				PlantLocation pl = plantLocationIterator.next();
				if(pl.getPlant().getInvasive()){
					invasivePlantCount = invasivePlantCount++;
					if(invasivePlantCount < INVASIVEPLANTLIMIT){
						pl.incrementTicksSincePlanted();
						if(pl.getTicksSincePlanted() > INVASIVETICKSTOSPREAD){
							if(pl.getSpawn()){
								invasivePlantCount++;
								Random random = new Random();
								int invasiveDirection = random.nextInt(INVASIVEDIRECTIONS);
								
								//add west
								if((invasiveDirection == 0)){
										tempInvasives.add(new PlantLocation(pl.getX()-pl.getPlant().getImgWidth()/INVASIVELOCATIONOFFSET, pl.getY(), pl.getPlant()));
								}
								//add east
								if((invasiveDirection == 1)){
										tempInvasives.add(new PlantLocation(pl.getX()+pl.getPlant().getImgWidth()/INVASIVELOCATIONOFFSET, pl.getY(),pl.getPlant()));
								}
								//add north
								if((invasiveDirection == 2)){
										tempInvasives.add(new PlantLocation(pl.getX(), pl.getY()-pl.getPlant().getImgHeight()/INVASIVELOCATIONOFFSET,pl.getPlant()));
								}
								//add south
								if((invasiveDirection == 3)){
										tempInvasives.add(new PlantLocation(pl.getX(), pl.getY()+pl.getPlant().getImgHeight()/INVASIVELOCATIONOFFSET,pl.getPlant()));
								}
								
								pl.resetTicksSincePlanted();
								pl.setSpawn();
							}
							else{
								if(pl.getTicksSincePlanted() > INVASIVETICKSTOSPREAD * 4){
									pl.resetTicksSincePlanted();
									pl.setSpawn();
								}
								
							}
						}
					}
				}
			}
			for(PlantLocation pl: tempInvasives){
				addPlantLocation(pl.getX(),pl.getY(),pl.getPlant());
			}
		}
	}

	
	//*****************************************************************************
	/*
	 * Inner class of time counter with Action Listener.
	 */
	
	   Timer countdownTimer;

	   int timeRemaining = 180;

	   int i =0;
	class CountdownTimerListener implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	         if (--timeRemaining > 0) {
	        	 totalStringTime=String.valueOf(timeRemaining);
	        	 DisplayScore();
	        	 //Timelabel.setText("Time Left : "+String.valueOf(timeRemaining)+ "                  Current Score :" + DisplayScore() );
	         } else {
	        	 totalStringTime="TIME IS UP";
	        	
	           // Timelabel.setText("Time is up and your score is "+DisplayScore());
	            countdownTimer.stop();
	            //frame.setVisible(false); DONT DO THIS IT WILL STOP THE GAME, TOO MANY LOOPS DEPEND ON THE FRAME SHOWING
	            Thread EndThread = new Thread(new EndScreen());
	    		EndThread.start();
	            TimeOver=true;
	            //Metapod.setVisible();
	         }
	      }
	   }
	//******************************************************************************88

	class MouseListenerClass implements MouseInputListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

			setXcoor(e.getX());
			setYcoor(e.getY());
			//MouseClick_X = e.getX();
			//MouseClick_Y = e.getY();
			//System.out.println("Moused Clicked at location ("+MouseClick_X+","+MouseClick_Y+")");
			WasTheMouseClicked = IsInsideGrid(MouseClick_X,MouseClick_Y);		
			buttonCheck = true;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			//we need to wait a few milliseconds otherwise the event will change to false so 
			//quick that the move method wont get call
			try{
				Thread.sleep(10);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			WasTheMouseClicked = false;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public void setCustomCursor(){
    	frame.setCursor(Cursor.getDefaultCursor());
    }
    
    public void setCustomCursor(BufferedImage image, Point point, String name){
    	cursor = Toolkit.getDefaultToolkit().createCustomCursor(image, point, name);
    	frame.setCursor(cursor);
    }
   
  
	// end plant handler inner classes
    
    //getters------------------------------
    int getMouseClickX(){
    	return MouseClick_X;
    }
    int getMouseClickY(){
    	return MouseClick_Y;
    }
    boolean Executing(){
    	return this.executeThread;
    }
    boolean IsIsBusy(){
    	return this.isBeingUsed;
    }
    //setters-------------------------------
	void setXcoor(int x){
		MouseClick_X =x;
	}
	void setYcoor(int y){
		MouseClick_Y=y;
	}
	
	//-----Setters----------------------
	void setTime(int time){
		this.timeRemaining = time;
	}
	void setExecute(boolean ex){
		this.executeThread=ex;
	}
	void setBeingUse(boolean www){
		this.isBeingUsed=www;
	}
	
	void ClearBoard(){
		/*Iterator <PlantLocation> iter = gamePlantLocations.iterator();
		PlantLocation p;
		while(iter.hasNext()){
			p = iter.next();
			gamePlantLocations.remove(p);
		}*/
		setExecute(false);
		for (int i=gamePlantLocations.size();i>0;i--){
			gamePlantLocations.remove(i-1);
		}
		AnimalFactory AF = new AnimalFactory();
		for (int i = AF.getAnimalLocation().size();i>0;i--){
			AF.getAnimalLocation().remove(i-1);
		}
		Metapod.setInvisible();
		this.timeRemaining = 180;
		this.action=null;
		this.oneShot = false;
		this.totalStringScore = "0";
		
		frame.dispose();
		this.startGame();
	}
	
}
