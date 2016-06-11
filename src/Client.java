import java.net.*;
import java.io.*;

public class Client
{
	public static void main(String[] args)
	{
		try {
			Socket socket = new Socket("172.77.94.206", 9295);
			System.out.println("Client started on port 9295");

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
			String serverMessage = reader.readLine();
			System.out.println(serverMessage);
			serverMessage = reader.readLine();
			System.out.println(serverMessage);
			String input = inputStream.readLine();
			writer.write(input + "\n");
			writer.flush();
			serverMessage = reader.readLine();
			System.out.println(serverMessage);

			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
