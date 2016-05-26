package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WinterberryHolly extends Plant{

	// super(name, nativeRegion, invasive, attract_good, attract_bad, shade, 
	// root, maintainTime, engaging, round1, round2, round3, isVisible	
	public WinterberryHolly(){
		super("winterberryholly", "Winterberry Holly", "Eastern US", false, "Bird", null, NONE,
			MED, LOW, true, false, false, true, true);

	}

}
