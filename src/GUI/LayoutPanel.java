package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

import AirplaneLayout.Layout;

public class LayoutPanel extends javax.swing.JPanel {

	private javax.swing.JButton getLayoutButton;
	private javax.swing.JLabel totalSeats;
	private javax.swing.JLabel planeIDLbl;
	private javax.swing.JTextField planeIdTF;
	private javax.swing.JLabel titleLbl;
	private javax.swing.JLabel totSeatLbl;
	private EDNGUI parent;
	private Character[][] layoutMap;

	public LayoutPanel(EDNGUI parent) {
		this.parent = parent;
		layoutMap = null;
		initComponents();
	}

	public JButton getLayoutButton() {
		return getLayoutButton;
	}

	public int getPlaneID() {
		int id;
		try {
			id = Integer.parseInt(planeIdTF.getText());
		} catch (NumberFormatException e) {
			id = -1;
		}
		return id;
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (layoutMap != null) {
			int columns = layoutMap[0].length;
			int rows = layoutMap.length;
			int size = 10;
			int baseX = 0;
			int baseY = 0;
			BufferedImage offMap = new BufferedImage(size
					* (columns + 20), size * rows,
					BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = (Graphics2D) offMap.getGraphics();
			if (layoutMap != null) {
				g2d.drawRect(baseX, baseY, size * columns, size
						* rows);
				for (int i = 0; i < columns; i++) {
					for (int j = 0; j < rows; j++) {
						char c = layoutMap[j][i];
						if (c == 'a') {
							g2d.setColor(Color.GREEN);
						} else if (c == 's') {
							g2d.setColor(Color.CYAN);
						} else if (c == 'e') {
							g2d.setColor(Color.RED);
						} else if (c == 'b') {
							g2d.setColor(Color.YELLOW);
						} else {
							g2d.setColor(Color.GRAY);
						}
						g2d.fillRect(baseX + size * (i % columns),
								baseY + size * (j % rows), size, size);
						g2d.setColor(Color.BLACK);
						g2d.drawRect(baseX + size * (i % columns),
								baseY + size * (j % rows), size, size);
					}
				}
				g2d.setColor(Color.GREEN);
				g2d.fillRect(size * (columns + 1), size
						* (rows / 2), size, size);
				g2d.setColor(Color.BLACK);
				g2d.drawRect(size * (columns + 1), size
						* (rows / 2), size, size);
				g2d.drawString("Aisle", size * (columns + 3), size
						* (rows / 2 + 1));
				g2d.setColor(Color.CYAN);
				g2d.fillRect(size * (columns + 1), size
						* (rows / 2 + 1), size, size);
				g2d.setColor(Color.BLACK);
				g2d.drawRect(size * (columns + 1), size
						* (rows / 2 + 1), size, size);
				g2d.drawString("Seat", size * (columns + 3), size
						* (rows / 2 + 2));
				g2d.setColor(Color.RED);
				g2d.fillRect(size * (columns + 1), size
						* (rows / 2 + 2), size, size);
				g2d.setColor(Color.BLACK);
				g2d.drawRect(size * (columns + 1), size
						* (rows / 2 + 2), size, size);
				g2d.drawString("Exit", size * (columns + 3), size
						* (rows / 2 + 3));
				g2d.setColor(Color.GRAY);
				g2d.fillRect(size * (columns + 1), size
						* (rows / 2 + 3), size, size);
				g2d.setColor(Color.BLACK);
				g2d.drawRect(size * (columns + 1), size
						* (rows / 2 + 3), size, size);
				g2d.drawString("Attendent Area", size
						* (columns + 3), size * (rows / 2 + 4));
				g2d.setColor(Color.YELLOW);
				g2d.fillRect(size * (columns + 1), size
						* (rows / 2 + 4), size, size);
				g2d.setColor(Color.BLACK);
				g2d.drawRect(size * (columns + 1), size
						* (rows / 2 + 4), size, size);
				g2d.drawString("Bathroom", size
						* (columns + 3), size * (rows / 2 + 5));
			}

			g2d.dispose();
			((Graphics2D) g).drawImage(offMap, null, 25, 200);
		}
	}

	public void updateLayoutInfo(Layout layout) {
		totalSeats.setText(String.valueOf(layout
				.getTotalSeats()));
		layoutMap = layout.getSeating();
		repaint();
	}

	private void initComponents() {

		planeIDLbl = new javax.swing.JLabel();
		planeIdTF = new javax.swing.JTextField();
		getLayoutButton = new javax.swing.JButton();
		titleLbl = new javax.swing.JLabel();
		totSeatLbl = new javax.swing.JLabel();
		totalSeats = new javax.swing.JLabel();

		getLayoutButton.addActionListener(parent);

		planeIDLbl.setText("Plane ID:");

		getLayoutButton.setText("Get Layout");

		titleLbl.setText("Layout Information");

		totSeatLbl.setText("Total Seats:");

		totalSeats.setText("0");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				this);
		this.setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(27, 27, 27)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				planeIDLbl)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				planeIdTF,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				101,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				getLayoutButton)
																		.addGap(73, 73, 73))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												totSeatLbl)
																										.addGap(
																												18,
																												18,
																												18)
																										.addComponent(
																												totalSeats,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE))
																						.addComponent(
																								titleLbl))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				357,
																				Short.MAX_VALUE)))));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(46, 46, 46)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(planeIDLbl)
														.addComponent(
																planeIdTF,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(getLayoutButton))
										.addGap(44, 44, 44)
										.addComponent(titleLbl)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(40, 40, 40))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(28, 28, 28)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								totSeatLbl)
																						.addComponent(
																								totalSeats))))
										.addContainerGap(557, Short.MAX_VALUE)));
	}
}
