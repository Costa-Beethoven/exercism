class SpaceAge {

    long seconds;
    double earthYears;
    double conversionFactor;

    SpaceAge(double seconds) {
        this.seconds = (long) seconds;
         earthYears = getSeconds()/31557600;
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
        return earthYears;
    }

    double onMercury() {
        conversionFactor = 0.2408467;
        return earthYears / conversionFactor;
    }

    double onVenus() {
        conversionFactor = 0.61519726;
        return earthYears / conversionFactor;
    }

    double onMars() {
        conversionFactor = 1.8808158;
        return earthYears / conversionFactor;
    }

    double onJupiter() {
        conversionFactor = 11.862615;
        return earthYears / conversionFactor;
    }

    double onSaturn() {
        conversionFactor = 29.447498;
        return earthYears / conversionFactor;
    }

    double onUranus() {
        conversionFactor = 84.016846;
        return earthYears / conversionFactor;
    }

    double onNeptune() {
        conversionFactor = 164.79132;
        return earthYears / conversionFactor;
    }

}
