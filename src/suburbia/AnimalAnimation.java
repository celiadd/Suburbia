package suburbia;

public abstract class AnimalAnimation extends SpecialEffects {

	private String key;
	public AnimalAnimation(int width, int height, int x, int y, String name,
			int numSets, int Fcount, int sizeX, int sizeY,String animalName) {
		super(width, height, x, y, name, numSets, Fcount, sizeX, sizeY);
		this.key = animalName;
	}

	//Getters--------------------------------------------------------------
	String getAnimalKey(){
		return key;
	}

}

