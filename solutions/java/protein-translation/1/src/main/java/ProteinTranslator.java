import java.util.*;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {

        Map<String, String> proteins = new HashMap<>();
        proteins.put("AUG", "Methionine");
        proteins.put("UUU", "Phenylalanine");
        proteins.put("UUC", "Phenylalanine");
        proteins.put("UUA", "Leucine");
        proteins.put("UUG", "Leucine");
        proteins.put("UCU", "Serine");
        proteins.put("UCC", "Serine");
        proteins.put("UCA", "Serine");
        proteins.put("UCG", "Serine");
        proteins.put("UAU", "Tyrosine");
        proteins.put("UAC", "Tyrosine");
        proteins.put("UGU", "Cysteine");
        proteins.put("UGC", "Cysteine");
        proteins.put("UGG", "Tryptophan");
        proteins.put("UAA", "STOP");
        proteins.put("UAG", "STOP");
        proteins.put("UGA", "STOP");

        List<String> result = new ArrayList<>();

        for (int i = 0; i < rnaSequence.length(); i += 3) {

            if (i + 3 > rnaSequence.length()) {
                throw new IllegalArgumentException("Invalid codon");
            }

            String codon = rnaSequence.substring(i, i + 3);
            if (!proteins.containsKey(codon)) {
                throw new IllegalArgumentException("Invalid codon");
            }

            String protein = proteins.get(codon);

            if ("STOP".equals(protein)) {
                break;
            }

            result.add(protein);
        }

        return result;
    }
}
