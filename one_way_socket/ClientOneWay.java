package one_way_socket;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientOneWay {

	public static void main(String[] args) throws IOException {
		
		Socket s = new Socket("localhost",5000);
		System.out.println("Connected");
		System.out.println("Client Connected at server Handshaking port " + s.getPort());
		System.out.println("Clien's communication port " + s.getLocalPort());

		//write 
		DataOutputStream output = new DataOutputStream(s.getOutputStream());
		
		BufferedReader scn = new BufferedReader(new InputStreamReader(System.in));
		//Scanner scn = new Scanner(System.in);
		
		String str = "";
		while(!str.equals("Bye")) {
			str = scn.readLine();
			output.writeUTF(str);	
		}s.close();
				
	}
}
