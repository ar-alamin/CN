package get;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Get {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent", "Chrome");
		
		int response = conn.getResponseCode();
		System.out.println("Response: " +response);
		System.out.println("Response Message " +conn.getResponseMessage());
		
		if(response == HttpURLConnection.HTTP_OK) {
			BufferedReader read = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
			StringBuffer str = new StringBuffer();
			
			String store = null;
			while((store=read.readLine()) !=null) {
				
				str.append(store);
			}read.close();
			System.out.println("GET Response: " +str.toString());
		}
		
	}
}
