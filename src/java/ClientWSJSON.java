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
            }   System.out.println("Respuesta del servidor: " + rest);
        }
        
        JSONObject obj = new JSONObject(rest);
        System.out.println("Object: " + obj);
        JSONObject res = obj.getJSONObject("RestResponse").getJSONObject("result");
        System.out.println("res: " + res);
        
        String name = res.get("name").toString();
        String alpha2 = res.get("alpha2_code").toString();
        String alpha3 = res.get("alpha3_code").toString();
        
        Country country = new Country(name, alpha2, alpha3); 
        System.out.println("Country = " + country.toString());
    }
}