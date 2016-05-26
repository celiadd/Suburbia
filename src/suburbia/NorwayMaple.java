package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class NorwayMaple extends Plant{

	// super(name, nativeRegion, invasive, attract_good, attract_bad, shade, 
	// root, maintainTime, engaging, round1, round2, round3, isVisible	
	public NorwayMaple(){
		super("norwaymaple","Norway Maple", "Europe", true, null, null, HIGH,
			MED, MED, false, false, false, true, true);

		imgWidth=140;
		imgHeight=210;

	}

}
