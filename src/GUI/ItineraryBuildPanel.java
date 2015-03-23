package GUI;

import javax.swing.JButton;

public class ItineraryBuildPanel extends javax.swing.JPanel {

	private javax.swing.JButton buildButton;
	private javax.swing.JLabel buildItineraryLbl;
	private javax.swing.JTextField idTF;
	private javax.swing.JLabel itineraryIdLbl;
	private javax.swing.JLabel itineraryName;
	private javax.swing.JLabel itineraryNameLbl;
	private javax.swing.JTextField itineraryNameTF;
	private javax.swing.JLabel itneraryNameLbl;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea flightIDTA;
	private javax.swing.JLabel userIDLbl;
	private javax.swing.JTextField userIDTF;
	private EDNGUI parent;

	public ItineraryBuildPanel(EDNGUI parent) {
		this.parent = parent;
		initComponents();
	}

	public JButton getBuildButton() {
		return buildButton;
	}

	public int getID() {
		try {
			return Integer.parseInt(idTF.getText());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	public String getTitle() {
		return itineraryNameTF.getText();
	}

	public int getUserID() {
		try {
			return Integer.parseInt(userIDTF.getText());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	public String[] getFlightIDs() {
		return flightIDTA.getText().replaceAll("\\s+", "")
				.split(",");
	}

	public void updateCurrentItinerary() {
		itineraryName.setText(itineraryNameTF.getText());
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		flightIDTA = new javax.swing.JTextArea();
		buildItineraryLbl = new javax.swing.JLabel();
		itineraryIdLbl = new javax.swing.JLabel();
		idTF = new javax.swing.JTextField();
		itineraryNameLbl = new javax.swing.JLabel();
		itineraryNameTF = new javax.swing.JTextField();
		userIDLbl = new javax.swing.JLabel();
		userIDTF = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		buildButton = new javax.swing.JButton();
		itneraryNameLbl = new javax.swing.JLabel();
		itineraryName = new javax.swing.JLabel();

		flightIDTA.setColumns(20);
		flightIDTA.setRows(5);
		jScrollPane1.setViewportView(flightIDTA);

		buildItineraryLbl.setText("Build Itinerary");

		itineraryIdLbl.setText("ID:");

		itineraryNameLbl.setText("Name:");

		userIDLbl.setText("User ID:");

		jLabel1.setText("Flight Id's:");

		buildButton.setText("Build");

		buildButton.addActionListener(parent);

		itneraryNameLbl.setText("Current Itinerary: ");

		itineraryName.setText("No Itinerary Created.");

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
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(buildItineraryLbl)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(12, 12, 12)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel1)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jScrollPane1))
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												itineraryIdLbl)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												idTF,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												83,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(
																												28,
																												28,
																												28)
																										.addComponent(
																												itineraryNameLbl)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												itineraryNameTF,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												159,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(
																												26,
																												26,
																												26)
																										.addComponent(
																												userIDLbl)
																										.addGap(
																												18,
																												18,
																												18)
																										.addComponent(
																												userIDTF,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												172,
																												javax.swing.GroupLayout.PREFERRED_SIZE))))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																layout
																		.createSequentialGroup()
																		.addComponent(
																				itneraryNameLbl)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				itineraryName)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				buildButton)))
										.addContainerGap(100, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(buildItineraryLbl)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(itineraryIdLbl)
														.addComponent(
																idTF,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(itineraryNameLbl)
														.addComponent(
																itineraryNameTF,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(userIDLbl)
														.addComponent(
																userIDTF,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel1)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												12, Short.MAX_VALUE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(buildButton)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				itneraryNameLbl)
																		.addComponent(
																				itineraryName)))
										.addContainerGap()));
	}

}
