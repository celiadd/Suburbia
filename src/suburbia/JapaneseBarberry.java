package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class JapaneseBarberry extends Plant{

	// super(name, nativeRegion, invasive, attract_good, attract_bad, shade, 
	// root, maintainTime, engaging, round1, round2, round3, isVisible	
	public JapaneseBarberry(){
		super("japanesebarberry","Japanese Barberry", "East Asia", true, null, null, NONE,
			HIGH, LOW, true, true, false, false, true);

	}

}
