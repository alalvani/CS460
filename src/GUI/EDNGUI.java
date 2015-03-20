package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.net.ssl.SSLContext;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import Marketing.Itinerary;
import Marketing.Marketing;

public class EDNGUI extends JFrame implements
		ActionListener {

	private OperationsPanel operationsPanel;
	private BaggagePanel baggagePanel;
	private FlightSchedulePanel flightSchedulePanel;
	private PaymentSystemPanel paymentSystemPanel;
	private ItineraryBuildPanel itineraryBuilder;
	private MarketingPanel marketingPanel;
	private Itinerary currentItinerary;
	private Marketing marketing;

	private static final long serialVersionUID = 1L;

	public EDNGUI() {
		setTitle("EDN Test Gui");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		JTabbedPane jt = new JTabbedPane();
		jt.setSize(750, 750);
		getContentPane().add(jt);
		setSize(750, 750);
		operationsPanel = new OperationsPanel();
		baggagePanel = new BaggagePanel();
		flightSchedulePanel = new FlightSchedulePanel();
		paymentSystemPanel = new PaymentSystemPanel();
		itineraryBuilder = new ItineraryBuildPanel(this);
		marketingPanel = new MarketingPanel(this,
				itineraryBuilder);
		// ...

		jt.addTab("Marketing", marketingPanel);
		jt.addTab("Operations", operationsPanel);
		jt.addTab("Flight Schedules", flightSchedulePanel);
		jt.addTab("baggagePanel", baggagePanel);
		jt.addTab("Payment Sytem", paymentSystemPanel);

		marketing = new Marketing();

	}

	public static void main(String[] args) {
		EDNGUI gui = new EDNGUI();
		gui.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == itineraryBuilder.getBuildButton()) {
			currentItinerary = new Itinerary();
			currentItinerary.id = itineraryBuilder.getID();
			currentItinerary.title = itineraryBuilder.getName();
			currentItinerary.user_id = itineraryBuilder
					.getUserID();
			currentItinerary.flight_list = itineraryBuilder
					.getFlightIDs();
			itineraryBuilder.updateCurrentItinerary();
//			for (String a : currentItinerary.flight_list) {
//				System.out.println(a);
//			}
		} else if (e.getSource() == marketingPanel
				.getPriceButton()) {
			if (currentItinerary != null) {
				float price = marketing.getPrice(currentItinerary);
				marketingPanel.updatePrice(price);
			}
		}

	}
}