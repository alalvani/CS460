package GUI;

import javax.swing.JButton;

class MarketingPanel extends javax.swing.JPanel {
	
  private javax.swing.JTextArea dataTA;
  private ItineraryBuildPanel itineraryBuildPanel1;
  private javax.swing.JButton priceButton;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel price;
  private javax.swing.JLabel priceLbl;
  private EDNGUI parent;


  public MarketingPanel(EDNGUI parent, ItineraryBuildPanel ibp) {
  	this.parent = parent;	
  	itineraryBuildPanel1 = ibp;
      initComponents();
  }
  
  public void updatePrice(float updatePrice)
  {
  	this.price.setText(String.valueOf(updatePrice));
  }
                    
  private void initComponents() {

      priceButton = new javax.swing.JButton();
      priceLbl = new javax.swing.JLabel();
      price = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      dataTA = new javax.swing.JTextArea();
      //itineraryBuildPanel1 = new javaapplication1.ItineraryBuildPanel();

      priceButton.setText("Get Price For Curren Itinerary");
      
      priceButton.addActionListener(parent);

      priceLbl.setText("Price:");

      price.setText("0.00");

      dataTA.setColumns(20);
      dataTA.setRows(5);
      jScrollPane1.setViewportView(dataTA);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1)
          .addGroup(layout.createSequentialGroup()
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                      .addComponent(priceButton)
                      .addGap(76, 76, 76)
                      .addComponent(priceLbl)
                      .addGap(18, 18, 18)
                      .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addComponent(itineraryBuildPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGap(0, 0, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addComponent(itineraryBuildPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(priceButton)
                  .addComponent(priceLbl)
                  .addComponent(price))
              .addGap(41, 41, 41)
              .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGap(0, 158, Short.MAX_VALUE))
      );
  }

	public JButton getPriceButton() {
		return priceButton;
	}
	
	
}