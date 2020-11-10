package jp.mydns.quantum.JTools;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class JArc extends Arc2D.Double implements JImageObject {

	/* Elipse
	 * 
	 *  (x - ox)^2 / a^2 + (y - oy)^2 / b^2 = 1
	 * 
	 *  */
	
	String imageId;
	Point2D.Double center;
	double a, b;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JArc(double x, double y, double w, double h, double start, double extent, int type, String id) {
		super(x, y, w, h, start, extent, type);
		// TODO Auto-generated constructor stub
		imageId = id;
		center = new Point2D.Double(x + w / 2, y + h / 2);
		a = java.lang.Math.abs(x - center.getX());
		b = java.lang.Math.abs(y - center.getY());
	}

	public JArc(Rectangle2D.Double rect, double start, double extent, int type, String id) {
		super(rect, start, extent, type);
		imageId = id;
		center = new Point2D.Double(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);
		a = java.lang.Math.abs(rect.getX() - center.getX());
		b = java.lang.Math.abs(rect.getY() - center.getY());
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D)g;
		g2.draw(this);
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
		double x = mousePoint.getX();
		double y = mousePoint.getY();
		return java.lang.Math.pow((x - center.getX()) / a, 2) + java.lang.Math.pow((y - center.getY()) / b, 2) <= 1;
	}

}
