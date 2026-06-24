import java.util.*;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {

        boolean myUniqueCard = !theirCollection.containsAll(myCollection);
        boolean theirUniqueCard = !myCollection.containsAll(theirCollection);

        return myUniqueCard && theirUniqueCard;
    }

    static Set<String> commonCards(List<Set<String>> collections) {

        if (collections == null || collections.isEmpty()) {
            return new HashSet<>();
        }

        Set<String> common = new HashSet<>(collections.getFirst());
        for (int i = 1; i < collections.size(); i++) {
            common.retainAll(collections.get(i));
        }
        return common;
    }

    static Set<String> allCards(List<Set<String>> collections) {

        Set<String> all = new HashSet<>(collections.getFirst());
        for (int i = 1; i < collections.size(); i++) {
            all.addAll(collections.get(i));
        }
        return all;
    }
}
