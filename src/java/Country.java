/**
 *
 * @author Queralt
 */
public class Country {
    private String name;
    private String alpha2_code;
    private String alpha3_code;
    
    public Country(String name, String alpha2_code, String alpha3_code){
        this.name = name;
        this.alpha2_code = alpha2_code;
        this.alpha3_code = alpha3_code;
    }
    
    public String toString() {
        return "Name: " + name + "\nAlpha2: " + alpha2_code + "\nAlpha3: " 
                + alpha3_code;
    }
}