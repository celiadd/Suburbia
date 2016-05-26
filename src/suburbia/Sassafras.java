package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sassafras extends Plant{

	// super(name, nativeRegion, invasive, attract_good, attract_bad, shade, 
	// root, maintainTime, engaging, round1, round2, round3, isVisible	
	public Sassafras(){
		super("sassafras","Sassafras", "Eastern US", false, "Butterfly", null, HIGH,
			MED, MED, true, false, false, true, true);

		imgWidth=140;
		imgHeight=210;
		
	}

}
