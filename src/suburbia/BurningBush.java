package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BurningBush extends Plant{
	
	// super(name, nativeRegion, invasive, attract_good, attract_bad, shade, 
	// root, maintainTime, engaging, round1, round2, round3, isVisible
	public BurningBush(){
		super("burningbush","Burning Bush", "East Asia",true, null, null, NONE,
				MED, MED, true, true, false, false, true);

	}

}
