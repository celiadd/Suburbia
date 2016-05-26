package suburbia;

/*
 * Provides storage of plant data for scoring and calculates respective scores.
*/
public class PlantData {
	String name;
	String location;
	int nativePlant;
	int invasivePlant;
	int hasPests;
	int attractsButterflies;
	int attractsCaterpillars;
	int maintenance;
	int rootDepth;
	int slowsErosion;
	int providesShade;
	int needsPesticide;
	int costly;
	int helpsWildlife;
	int isEngaging;
	
	//Constructor that sets all of the plant data
	public PlantData(String name,	String location,	int nativePlant,	int invasivePlant,
			int hasPests,	int attractsButterflies,	int attractsCaterpillars,	int maintenance,
			int rootDepth,	int slowsErosion,	int providesShade,	int needsPesticide,
			int costly,	int helpsWildlife,	int isEngaging){
		this.name = name;
		this.location = location;
		this.nativePlant = nativePlant;
		this.invasivePlant = invasivePlant;
		this.hasPests = hasPests;
		this.attractsButterflies = attractsButterflies;
		this.attractsCaterpillars = attractsCaterpillars;
		this.maintenance = maintenance;
		this.rootDepth = rootDepth;
		this.slowsErosion = slowsErosion;
		this.providesShade = providesShade;
		this.needsPesticide = needsPesticide;
		this.costly = costly;
		this.helpsWildlife = helpsWildlife;
		this.isEngaging = isEngaging;
	}
	
	//get a plant score for first round
	int RoundOneScore(){
		return (2*nativePlant - 6*invasivePlant - hasPests + attractsButterflies + attractsCaterpillars
				- maintenance - needsPesticide - costly + helpsWildlife);
	}
	
	//get a plant score for second round
	int RoundTwoScore(){
		return (2*nativePlant - 7*invasivePlant - hasPests - maintenance
				- needsPesticide - costly + providesShade + isEngaging);
	}
	
	//get a plant score for freeplay
	int FreeplayScore(){
		return 10*(RoundOneScore() + rootDepth + slowsErosion + providesShade + isEngaging);
	}

}
