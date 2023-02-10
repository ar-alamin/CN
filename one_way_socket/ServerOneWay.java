package one_way_socket;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerOneWay {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(5000);
		System.out.println("Server is waiting for client reaquset.");
		System.out.println("Server is connected at port no: " + ss.getLocalPort());
		Socket s = ss.accept();
		System.out.println("Client request is accepted.");
		
		//write 
		DataInputStream input = new DataInputStream(s.getInputStream());
		
		
		String str = "";
		while(!str.equals("Bye")) {
			str=input.readUTF();
			System.out.println("Client says: " + str);
			
		}ss.close();
		s.close();
	}
}
