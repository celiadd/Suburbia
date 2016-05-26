package suburbia;

import java.util.Random;

public class AnimalLocations {
	private int Xlocation;
	private int Ylocation;
	private String AKey;
	
	public AnimalLocations(String key){
		Random r = new Random();
		Xlocation = r.nextInt(1000);
		Ylocation = r.nextInt(1000);
		AKey = key;
	}
	public AnimalLocations(String key,int X, int Y){
		Random r = new Random();
		Xlocation = X;
		Ylocation = Y;
		AKey = key;
	}
	
	//----------------getters------------------------
	int getXLocation(){
		return this.Xlocation;
	}
	int getYLocation(){
		return this.Ylocation;
	}
	String getKey(){
		return this.AKey;
	}
	//------------------setters---------------------
	void setXLocation(){
		Random r = new Random();
		int sign = r.nextInt(10);
		if (sign<5){sign = -1;}
		else{sign = 1;}
		Xlocation = Xlocation+(sign*r.nextInt(4));
		//Ylocation = Ylocation+(sign*r.nextInt(4));
	}
	void setYLocation(){
		Random r = new Random();
		int sign = r.nextInt(10);
		if (sign<5){sign = -1;}
		else{sign = 1;}
		//Xlocation = Xlocation+(sign*r.nextInt(4));
		Ylocation = Ylocation+(sign*r.nextInt(4));
	}
}
