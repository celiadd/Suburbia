package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class JoepyeWeed extends Plant{

	// super(name, nativeRegion, invasive, attract_good, attract_bad, shade, 
	// root, maintainTime, engaging, round1, round2, round3, isVisible	
	public JoepyeWeed(){
		super("joepyeweed","Joe-pye Weed", "Eastern US", false, "Butterfly", null, NONE,
			HIGH, MED, true, true, false, false, true);

	}

}