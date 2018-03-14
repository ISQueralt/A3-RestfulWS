import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author Queralt
 */

public class ClientWSJSON {

    public static void main(String[] args) throws IOException, JSONException {
        URL client = new URL("http://services.groupkt.com/country/get/iso2code/IN");
        
        URLConnection tc = client.openConnection();
        String rest;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(tc.getInputStream()))) {
            rest = new String();
            String line;
            while ((line = in.readLine()) != null){
                rest+=line;
            }   
        }
        
        JSONObject obj = new JSONObject(rest);
        JSONObject res = obj.getJSONObject("RestResponse").getJSONObject("result");
        
        Gson gson = new Gson();
        Country country = (Country) gson.fromJson(res.toString(), Country.class); 
       
        System.out.println("Name = " + country.getName());
        System.out.println("Aplha2_code = " + country.getAlpha2_code());
        System.out.println("Alpha3_code = " + country.getAlpha3_code());
    }
}