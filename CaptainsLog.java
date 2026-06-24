import java.util.Random;

class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        int randomClass = random.nextInt(PLANET_CLASSES.length);
        return PLANET_CLASSES[randomClass];
    }

    String randomShipRegistryNumber() {
        int randomRegistry = random.nextInt(9000) + 1000;
        return "NCC-" + randomRegistry;
    }

    double randomStardate() {
        return 41000.0 + (random.nextDouble()*1000.0);
    }
}
