package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScarletOak extends Plant{

	// super(name, nativeRegion, invasive, attract_good, attract_bad, shade, 
	// root, maintainTime, engaging, round1, round2, round3, isVisible	
	public ScarletOak(){
		super("scarletoak","Scarlet Oak", "Eastern US", false, "Bird", null, HIGH,
			MED, LOW, true, false, false, true, true);

		
		imgWidth=140;
		imgHeight=210;
		
		}

}
