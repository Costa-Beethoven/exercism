public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        int CarsAssemble = 221;

        if (speed >= 1 && speed <= 4) {
            return CarsAssemble * speed;
        } else if (speed > 4 && speed <= 8) {
            return CarsAssemble * speed * 0.9;
        } else if (speed == 9) {
            return CarsAssemble * speed * 0.8;
        } else if (speed == 10) {
            return CarsAssemble * speed * 0.77;
        }
        return 0;
    }

    public int workingItemsPerMinute(int speed) {
        int CarsAssemble = 221;

        if (speed >= 1 && speed <= 4) {
            return CarsAssemble * speed / 60;
        } else if (speed > 4 && speed <= 8) {
            return (int) (CarsAssemble * speed * 0.9 / 60);
        } else if (speed == 9) {
            return (int) (CarsAssemble * speed * 0.8 / 60);
        } else if (speed == 10) {
            return (int) (CarsAssemble * speed * 0.77 / 60);
        }
        return 0;
    }
}
