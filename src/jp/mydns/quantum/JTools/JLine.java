package jp.mydns.quantum.JTools;

import java.awt.geom.Line2D.Double;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.math.BigDecimal;

public class JLine extends Double implements JImageObject {

	String imageId;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Point2D.Double start, end;
	
	public JLine() {
		// TODO Auto-generated constructor stub
	}

	public JLine(Point2D p1, Point2D p2, String id) {
		super(p1, p2);
		// TODO Auto-generated constructor stub
		imageId = id;
		if (p1 instanceof Point2D.Float)
			start = new Point2D.Double(p1.getX(), p1.getY());
		else
			start = (Point2D.Double)p1;
		if (p2 instanceof Point2D.Float)
			end = new Point2D.Double(p2.getX(), p2.getY());
		else
			end = (Point2D.Double)p2;
	}

	public JLine(double x1, double y1, double x2, double y2, String id) {
		super(x1, y1, x2, y2);
		// TODO Auto-generated constructor stub
		imageId = id;
		start = new Point2D.Double(x1, y1);
		end = new Point2D.Double(x2, y2);
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
		double a, b;
		a = (end.y - start.y) / (end.x - start.x);
		b = start.y - a * start.x;

		return java.lang.Math.abs(mousePoint.getY() - a * mousePoint.getX() + b) < 10;
	}

}
