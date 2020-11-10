package jp.mydns.quantum.JTools;

import java.awt.geom.Rectangle2D;

class JCircleProperty {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static public Rectangle2D.Double getRectangle(int center_x, int center_y, int radius) {
		double x, y;
		double w, h;
		x = center_x - radius;
		y = center_y - radius;
		w = h = 2 * radius;
		return new Rectangle2D.Double(x, y, w, h);
	}
}
