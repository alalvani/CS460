package _jade.edu.unm.cs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * A Simple Socket client that connects to our socket server
 * http://syntx.io/a-client-server-application-using-socket-programming-in-java/
 *
 */
public class UpdateClient {

	private String hostname;
	private int port;
	Socket socketClient;

	private UpdateClient(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}

	private Socket connect() throws UnknownHostException, IOException {
		System.out.println("Attempting to connect to " + hostname + ":" + port);
		socketClient = new Socket(hostname, port);
		System.out.println("Connection Established");
		return socketClient;
	}

	private void sendMessage(Socket socketC) throws IOException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				socketC.getOutputStream()));
		writer.write("173254, Cancelled");
		writer.flush();
		writer.close();
	}

	public static void main(String arg[]) {
		// Creating a SocketClient object
		UpdateClient client = new UpdateClient("localhost", 9990);

		try {
			// trying to establish connection to the server
			Socket socketC = client.connect();
			// if successful, send response to socket
			client.sendMessage(socketC);

		} catch (UnknownHostException e) {
			System.err.println("Host unknown. Cannot establish connection");
		} catch (IOException e) {
			System.err
					.println("Cannot establish connection. Server may not be up."
							+ e.getMessage());
		}
	}
}
