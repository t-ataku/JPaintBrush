package jp.mydns.quantum.JTools;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

public class JIcon implements JImageObject {

	String imageId;
	Image icon;
	
	public JIcon(String filepath, String description, String id) {
		// TODO Auto-generated constructor stub
		super();
		ImageIcon iconimg = new ImageIcon(filepath, description);
		icon = iconimg.getImage();
		imageId = id;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D)g;
		double ratio = 0.6;
		g2.drawImage(icon, new AffineTransform(ratio, 0, 0, ratio, 100, 200), null);
	}

	@Override
	public void setImageId(String id) {
		// TODO Auto-generated method stub
		imageId = id;
	}

	@Override
	public String getImageId() {
		// TODO Auto-generated method stub
		return imageId;
	}

	@Override
	public boolean hit(Point mousePoint) {
		// TODO Auto-generated method stub
		return false;
	}

}
