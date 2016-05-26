package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class JapaneseMaple extends Plant{

	// super(name, nativeRegion, invasive, attract_good, attract_bad, shade, 
	// root, maintainTime, engaging, round1, round2, round3, isVisible	
	public JapaneseMaple(){
		super("japanesemaple","Japanese Maple", "East Asia", false, null, null, MED,
			MED, MED, true, false, false, true, true);

		imgWidth=210;
		imgHeight=210;
		
	}

}
