import java.io.*;
import java.net.*;

public class Server
{
	ServerSocket serverSocket;

	public void run() throws IOException
	{

		serverSocket = new ServerSocket(9295);
		while(true)
		{
			Socket connection = serverSocket.accept();

			System.out.println("Server Started on port 9295");
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));

			writer.write("Testing One Two Three \n");
			writer.write("Write something: \n");
			writer.flush();

			String input = reader.readLine();
			System.out.println("Client wrote: " + input);
			writer.write("You wrote " + input + "\n");
			writer.flush();

			connection.close();
		}
	}

	public static void main(String[] args)
	{
		Server server = new Server();
		try {
			server.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
