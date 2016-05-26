package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EasternRedCedar extends Plant{

	// super(name, nativeRegion, invasive, attract_good, attract_bad, shade, 
	// root, maintainTime, engaging, round1, round2, round3, isVisible	
	public EasternRedCedar(){
		super("easternredcedar","Eastern Red Cedar", "Eastern US", false, "Rabbit", null, MED,
			MED, LOW, false, false, false, true, true);

		imgWidth=140;
		imgHeight=210;

	}

}
