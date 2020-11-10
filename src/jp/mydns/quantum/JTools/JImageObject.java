package jp.mydns.quantum.JTools;

import java.awt.Graphics;
import java.awt.Point;

public interface JImageObject {

	public void paint(Graphics g);
	public void setImageId(String id);
	public String getImageId();
	boolean hit(Point mousePoint);

}