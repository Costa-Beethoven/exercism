import java.util.HashMap;
import java.util.Map;

class RnaTranscription {

    Map<String, String> transcriptionMap = new HashMap<>(Map.of(
            "G", "C",
            "C", "G",
            "T", "A",
            "A", "U",
            "", ""
    ));

    String transcribe(String dnaStrand) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < dnaStrand.length(); i++) {
            result.append(transcriptionMap.get(String.valueOf(dnaStrand.charAt(i))));
        }
        return result.toString();
    }
}
