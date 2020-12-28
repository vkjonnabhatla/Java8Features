package org.java.net.examples;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class HTTPConnectionExample {
    public static void main(String[] args) throws Exception{
		/*URL url = new URL("http://d.us.criteo.com/delivery/v2/api/page?key=193&page-id=viewItem_App&viewed-sku=10484181&category=255");
		URLConnection urlConnection = url.openConnection();
		InputStream inputStream = null;
		urlConnection.setConnectTimeout(5000);
		urlConnection.setReadTimeout(250);
		urlConnection.setAllowUserInteraction(false);
		urlConnection.setDoOutput(true);*/
        for(int i = 0; i < 1000; i++){
            //URL url1 = new URL("http://d.us.criteo.com/delivery/v2/api/page?key=193&page-id=viewItem_App&viewed-sku=10484181&category=255");
            URL url2 = new URL("http://d.us.criteo.com/delivery/v2/api/page?key=193&page-id=viewHome_App");

            URLConnection urlConnection = url2.openConnection();
            InputStream inputStream = null;
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(250);
            urlConnection.setAllowUserInteraction(false);
            urlConnection.setDoOutput(true);
            inputStream = urlConnection.getInputStream();
            java.lang.String result = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
            System.out.println(result);



            //Java 11 classes
			/*HttpClient httpClient = HttpClient.newBuilder()
					.version(HttpClient.Version.HTTP_1_1)
					.connectTimeout(Duration.ofSeconds(5))
					.build();

			HttpRequest request = HttpRequest.newBuilder()
					.GET()
					.uri(URI.create("http://d.us.criteo.com/delivery/v2/api/page?key=193&page-id=viewHome_App"))
					.timeout(Duration.ofMillis(250))
					//.setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
					.build();

			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());*/

        }
    }
}
