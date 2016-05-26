package suburbia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Azalea extends Plant{
	
	// super(name, nativeRegion, invasive, attract_good, attract_bad, shade, 
	// root, maintainTime, engaging, round1, round2, round3, isVisible
	public Azalea(){
		super("azalea","Azalea", "Southern US",false, null, null, NONE,
				HIGH, MED, true, true, false, false, true);


	}
}
