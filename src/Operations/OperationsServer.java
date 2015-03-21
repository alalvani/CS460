package _jade.edu.unm.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A simple socket server
 * http://syntx.io/a-client-server-application-using-socket-programming-in-java/
 *
 */
public class OperationsServer {

	private ServerSocket serverSocket;
	private int port;
	Socket socket;

	private OperationsServer(int port) {
		this.port = port;
	}

	private void start() throws IOException {
		System.out.println("Starting the socket server at port:" + port);
		serverSocket = new ServerSocket(port);
		Operations operation = new Operations();

		// Listen for clients. Block till one connects

		System.out.println("Waiting for clients...");
		while (true) {
			socket = serverSocket.accept();
			// A client has connected to this server. Gets message
			String message = readResponse();
			operation.parseMessage(message);
		}
	}

	private String readResponse() throws IOException {
		String userInput;
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));

		String toReturn = "";
		System.out.println("Response from client:");
		while ((userInput = stdIn.readLine()) != null) {
			System.out.println(userInput);
			toReturn = toReturn + userInput;
		}
		return toReturn;
	}

	/**
	 * Creates a SocketServer object and starts the server.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// Setting a default port number.
		int portNumber = 9990;

		try {
			// initializing the Socket Server
			OperationsServer socketServer = new OperationsServer(portNumber);
			socketServer.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
