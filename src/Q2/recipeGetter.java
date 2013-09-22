package Q2;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class recipeGetter {
	

	public static void main(String[] args) {
		String url_str;
		url_str = args[0];

		try {
			URL url = new URL(url_str);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			BufferedInputStream bis = new BufferedInputStream(
					http.getInputStream());
			int data;
			while ((data = bis.read()) != -1)
				System.out.write(data);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

}
