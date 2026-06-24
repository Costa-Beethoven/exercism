import java.util.*;

class DnDCharacter {

    static String[] abilities = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
    HashMap<String, Integer> characterAbilities = new HashMap<>();

    DnDCharacter() {
        for (int i = 0; i < 6; i++) {
            List<Integer> listDices = rollDice();
            characterAbilities.put(abilities[i], ability(listDices));
        }
        characterAbilities.put("HP", 10 + modifier(getConstitution()));
    }

    int ability(List<Integer> scores) {
        Integer[] abilityListDices = scores.toArray(new Integer[0]);
        Arrays.sort(abilityListDices);

        int abilityValue = 0;
        for (int j = 1; j < 4; j++) {
            abilityValue += abilityListDices[j];
        }
        return abilityValue;
    }

    List<Integer> rollDice() {
        List<Integer> listDices = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 4; i++) {
            listDices.add(rand.nextInt(6) + 1);
        }

        return listDices;
    }

    int modifier(int input) {
        return (int) Math.floor((double) (input - 10) /2);
    }

    int getStrength() {
        return characterAbilities.get("Strength");
    }

    int getDexterity() {
        return characterAbilities.get("Dexterity");
    }

    int getConstitution() {
        return characterAbilities.get("Constitution");
    }

    int getIntelligence() {
        return characterAbilities.get("Intelligence");
    }

    int getWisdom() {
        return characterAbilities.get("Wisdom");
    }

    int getCharisma() {
        return characterAbilities.get("Charisma");
    }

    int getHitpoints() {
        return characterAbilities.get("HP");
    }
}
