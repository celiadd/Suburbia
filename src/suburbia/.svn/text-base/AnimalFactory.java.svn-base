package suburbia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class AnimalFactory implements Runnable{

	
	static HashMap<String,AnimalAnimation> AnimalMap = new HashMap<String,AnimalAnimation>();
	static ArrayList<AnimalLocations> AnimalLocation = new ArrayList<AnimalLocations>();
	static AnimalAnimation butter = new ButterflyAnimation();
	static AnimalAnimation rabbit = new BunnyAnimation();
	private int CurrentBunnyCount;
	private int CurrentButterflyCount;
	private int LastBunnyCount;
	private int LastButterflyCount;
	private ArrayList<PlantLocation> CopyPlantLocations = new ArrayList<PlantLocation>();
	private static int ANIMAL_REGULATOR = 5;
	public AnimalFactory(){
	 
	}

	GameBoard BoardGetter = new GameBoard();
	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		AnimalMap.put("Bunny", rabbit);
		AnimalMap.put("Butterfly", butter);
		
		CurrentBunnyCount = 0;
		CurrentButterflyCount=0;
		LastBunnyCount=0;
		LastButterflyCount=0;
		Iterator<PlantLocation> plants;
		while (BoardGetter.frame.isShowing()&&BoardGetter.Executing()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			CopyPlantLocations.removeAll(CopyPlantLocations);
			CopyPlantLocations.addAll(BoardGetter.gamePlantLocations);
			
			Plant p ;
			PlantLocation currentSprit;
			int tempButter=0;
			int tempRabbit=0;
			int Xrabbit=0;
			int Yrabbit=0;
			int Xbutter=0;
			int Ybutter=0;
			
			while(BoardGetter.IsIsBusy()){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			plants = CopyPlantLocations.iterator();
			while(plants.hasNext()){
				BoardGetter.setBeingUse(true);
				currentSprit = plants.next();
				if (currentSprit.getPlant() instanceof Plant ){
					p = (Plant)currentSprit.getPlant();
					if (p.getAttractGood()=="Butterfly"){
						//System.out.println("Plant that attracts Butterfly Found");
						if(tempButter<5){
							Xbutter = currentSprit.getX();
							Ybutter = currentSprit.getY();
						}
						tempButter++;
					}
					if (p.getAttractGood()=="Rabbit"){
						//System.out.println("Plant that attracts rabbit was found");
						if(tempRabbit<5){
							Xrabbit = currentSprit.getX();
							Yrabbit = currentSprit.getY();
						}
						
						tempRabbit++;
					}
					
					
				}
			}
			BoardGetter.setBeingUse(false);
			/*
			 * this section check whether an animal needs to be added or removed.
			 */
			//System.out.println("tempRabbit = "+tempRabbit);
			//System.out.println("TempButter = "+tempButter);
			CurrentBunnyCount = tempRabbit / ANIMAL_REGULATOR;
			CurrentButterflyCount = tempButter / ANIMAL_REGULATOR;
			//System.out.println("CurrentBunny count = "+ CurrentBunnyCount);
			//System.out.println("Current butterfly count = "+CurrentButterflyCount);
			
		
			
			if (CurrentBunnyCount!=LastBunnyCount){
				if (LastBunnyCount<CurrentBunnyCount){
					LastBunnyCount++;
					
					addAnimal("Bunny",Xrabbit,Yrabbit);
				}else{removeAnimal("Bunny");LastBunnyCount--;}
			}
			if (CurrentButterflyCount!=LastButterflyCount){
				if (LastButterflyCount<CurrentButterflyCount){
					LastButterflyCount++;
					
					addAnimal("Butterfly",Xbutter,Ybutter);
				}else{removeAnimal("Butterfly");LastButterflyCount--;}
			}				
			
			
			/*
			 * this section updates the picture to be selected of the animals
			 */
			Iterator <AnimalLocations> iter = AnimalLocation.iterator();
			while (iter.hasNext()){			
				AnimalLocations dummyAnimal = iter.next();
				//System.out.println("Iterating through Animal locations. And trying to set next Picture");
				AnimalMap.get(dummyAnimal.getKey()).setNextPicture();
				dummyAnimal.setXLocation();
				dummyAnimal.setYLocation();
				
			}
			
		
		}
	}
	
	void addAnimal (String animalName,int X,int Y){
		AnimalLocation.add(new AnimalLocations(animalName,X,Y));
		
	}
	void removeAnimal(String animalName){
		for (int i=0;i<AnimalLocation.size();i++){
			if (AnimalLocation.get(i).getKey()==animalName){
				AnimalLocation.remove(i);
				i=AnimalLocation.size();
			}
		}
	}
	
	//getters---------------------------
	HashMap<String,AnimalAnimation> getAnimalMap(){
		return AnimalMap;
	}
	ArrayList<AnimalLocations> getAnimalLocation(){
		return AnimalLocation;
	}
	

	
	
	
}
