package suburbia;

import java.awt.image.BufferedImage;
//import Plant.java;


public class Cell {

	private final int X_POSITION;
	private final int Y_POSITION;
	private boolean Plant_in_Cell;
	private BufferedImage plant_sprite;
	private int XTopL,XTopR,XBottomL,XBottomR,YTopL,YTopR,YBottomL,YBottomR;
	//every cell has x and y coordinates, and space to hold a plant image
	public Cell(int x, int y){
		X_POSITION = x;
		Y_POSITION = y;
		Plant_in_Cell = false;
		plant_sprite = null;
		
	}
	
	//clear the cell space 
	void DeletePlant(){
		plant_sprite =null;
		Plant_in_Cell = false;
	}
	//create new plant
	void MakePlant(String PlantID){
		
		if (PlantID == "Christmasfern"){
//		Plant p = new ChristmasFern(this.X_POSITION,this.Y_POSITION);
			
		}
		//Plant p = new Tree();//This is just an exmple
		//plant_sprite = p.getImage () //gets the image implement later
		Plant_in_Cell = true;
		
	}
	
	int getXcoor(){
		return X_POSITION;
	}
	
	int getYcoor(){
		return Y_POSITION;
	}
	
	BufferedImage getPlantImage(){
		return plant_sprite;
	}
	
	public String  toString(){
		//this is used for test purposes only
		return "the current cell position is ("+X_POSITION+","+Y_POSITION+"). and plant_in_cell = "+Plant_in_Cell;
	}
	
	
	
}
