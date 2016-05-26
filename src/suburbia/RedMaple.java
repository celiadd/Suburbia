package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RedMaple extends Plant{

	// super(name, nativeRegion, invasive, attract_good, attract_bad, shade, 
	// root, maintainTime, engaging, round1, round2, round3, isVisible	
	public RedMaple(){
		super("redmaple","Red Maple", "Eastern US", false, null, null, HIGH,
			MED, LOW, true, false, false, true, true);
		
		imgWidth=140;
		imgHeight=210;
		
	}

}
