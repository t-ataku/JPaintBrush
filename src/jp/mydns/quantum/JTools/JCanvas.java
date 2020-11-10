package jp.mydns.quantum.JTools;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.image.ImageObserver;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class JCanvas extends Canvas implements FocusListener, MouseListener, MouseMotionListener, ImageObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LinkedList<JImageObject> objlist;
	
	JCanvas() {
		super();
		addFocusListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		objlist = new LinkedList<JImageObject>();

		objlist.add(new JLine(0, 0, 300, 0, "Line1"));
		objlist.add(new JLine(300, 0, 300, 300, "Line2"));
		objlist.add(new JLine(300, 300, 0, 300, "Line3"));
		objlist.add(new JLine(0, 300, 0, 0, "Line4"));

		objlist.add(new JLine(0, 150, 300, 150, "Line5"));
		objlist.add(new JLine(150, 0, 150, 300, "Line6"));
		
		objlist.add(new JArc(0, 0, 150, 150, 0, 360, Arc2D.OPEN, "Arc1"));
		objlist.add(new JArc(150, 0, 80, 80, 0, 360, Arc2D.OPEN, "Arc2"));
		objlist.add(new JArc(0, 150, 120, 80, 0, 360, Arc2D.OPEN, "Arc3"));
		objlist.add(new JArc(JCircleProperty.getRectangle(150 + 75, 150 + 75, 70), 90, 120, Arc2D.PIE, "Arc4"));
		
		objlist.add(new JIcon("icon/circle.png", "Circle", "Icon1"));
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		System.err.println("JCanvas.paint() called");
		Iterator<JImageObject>e = objlist.descendingIterator();
		while (e.hasNext()) {
			JImageObject io = e.next();
			io.paint(g2);
			System.out.println(io.getImageId());
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		System.err.println("JCanvas: Gained Focus");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = e.getLocationOnScreen();
		System.err.printf("Moved at (%f,%f)\n", p.getX(), p.getY());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = e.getLocationOnScreen();
		System.err.printf("Dragged at (%f,%f)\n", p.getX(), p.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = e.getLocationOnScreen();
		System.err.printf("Clicked at (%f,%f)\n", p.getX(), p.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = e.getLocationOnScreen();
		System.err.printf("Pressed at (%f,%f)\n", p.getX(), p.getY());
		Iterator<JImageObject>elem = objlist.descendingIterator();
		while (elem.hasNext()) {
			JImageObject io = elem.next();
			if (io.hit(e.getPoint()))
				System.out.println("ID:" + io.getImageId() + " HIT");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = e.getLocationOnScreen();
		System.err.printf("Released at (%f,%f)\n", p.getX(), p.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = e.getLocationOnScreen();
		System.err.printf("Entered at (%f,%f)\n", p.getX(), p.getY());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = e.getLocationOnScreen();
		System.err.printf("Exited at (%f,%f)\n", p.getX(), p.getY());
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		System.err.println("JCanvas: Lost Focus");
	}

}
