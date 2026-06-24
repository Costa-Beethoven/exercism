import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class DialingCodes {

    private final Map<Integer, String> codes = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setDialingCode(Integer code, String country) {
        codes.put(code, country);
    }

    public String getCountry(Integer code) {
        return codes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
       if (!codes.containsKey(code) && !codes.containsValue(country)) {
           codes.put(code, country);
       }
    }

    public Integer findDialingCode(String country) {
        if (codes.containsValue(country)) {
            return codes.keySet().hashCode();
        } else {
            return null;
        }
    }

    public void updateCountryDialingCode(Integer code, String country) {
        if (codes.containsValue(country)) {
            codes.remove(findDialingCode(country), country);
            codes.put(code, country);
        }
    }
}
