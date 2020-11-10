package jp.mydns.quantum.JTools;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Label;
import java.awt.geom.Arc2D;

public class JPaintBrush extends Frame {

	public JPaintBrush(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	void init() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbl);
		JCanvas cvs = new JCanvas();
        cvs.setSize(300, 300);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 10, 10, 10);
        gbc.ipadx = 10;
        gbc.ipady = 10;
        gbc.weightx = 10.0;
        gbc.weighty = 10.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER; //end row

        gbl.setConstraints(cvs, gbc);
        add(cvs);

        Label lbl = new Label("THIS IS IT!");
        gbl.setConstraints(lbl, gbc);
        add(lbl);
        
        setSize(300, 320);
    }

	public void paint(Graphics g) {
		super.paint(g);
		System.err.println("JPaintBrush:paint()");
	}
	
	void run() {
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JPaintBrush me = new JPaintBrush("JPaintBrush");
		me.init();
		me.run();
	}

}
