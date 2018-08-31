package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Make concurrent API calls
 * 
 * @author H203961
 *
 */
public class ConcurrentRequest {
    private ExecutorService executorService;

    public void start() {
        executorService = Executors.newSingleThreadExecutor();
    }

    public void stop() {
        executorService.shutdown();
    }

    public String createArea(String name) throws IOException {

        URL url = new URL("http://localhost:8080/domainServices/areas/new");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);

        //byte[] out = "{\"name\\\": \\\"+name+\\\",\\\"areaType\\\": {\\\"id\\\": 1},\\\"generateRoute\\\": false,\\\"planCounts\\\": false,\\\"planPicks\\\": false,\\\"planPuts\\\": false,\\\"sectionDependency\\\": false,\\\"useInventory\\\": false}"
        String json = "{\"name\": \""+name+"\",\"areaType\": {\"id\": 1},\"generateRoute\": false,\"planCounts\": false,\"planPicks\": false,\"planPuts\": false,\"sectionDependency\": false,\"useInventory\": false}";
        byte[] out = json.getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }

        InputStream  is = http.getInputStream();
        
        return out.toString();

    }

    public String getAreaFromDomainServices(BigInteger id) {
        try {
            URL url = new URL("http://localhost:8080/domainServices/areas?id=" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            /*
             * System.out.println("Output from Server .... \n");
             * while ((output = br.readLine()) != null) {
             * System.out.println(output);
             * }
             */
            output = br.readLine();
            conn.disconnect();
            return output;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
