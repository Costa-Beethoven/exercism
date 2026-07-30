import java.util.*;

public class Prism {

    static final double EPSILON = 1e-2;

    public record LaserInfo(double x, double y, double angle) {
    }

    public record PrismInfo(int id, double x, double y, double angle) {
    }

    private static double normaliseAngle(double angle) {
        return ((angle % 360) + 360) % 360;
    }

    public static List<Integer> findSequence(LaserInfo laser, List<PrismInfo> prisms) {

        List<Integer> result = new ArrayList<>();
        double currentLaserX = laser.x();
        double currentLaserY = laser.y();
        double currentLaserAngle = normaliseAngle(laser.angle());

        while (true) {

            PrismInfo closestPrism = null;
            double closestDistanceSquared = Double.MAX_VALUE;

            for (PrismInfo prism : prisms) {
                if (Math.abs(prism.x() - currentLaserX) < EPSILON
                && Math.abs(prism.y() - currentLaserY) < EPSILON) {
                    continue;
                }

                double thetaTarget = normaliseAngle(Math.toDegrees(Math.atan2(
                        prism.y() - currentLaserY,
                        prism.x() - currentLaserX
                )));

                double delta = Math.abs(thetaTarget - currentLaserAngle);
                delta = Math.min(delta, 360 - delta);

                if (delta < EPSILON) {
                    double dx = prism.x() - currentLaserX;
                    double dy = prism.y() - currentLaserY;
                    double distanceSquared = dx * dx + dy * dy;
                    if (distanceSquared < closestDistanceSquared) {
                        closestDistanceSquared = distanceSquared;
                        closestPrism = prism;
                    }
                }
            }

            if (closestPrism == null) {
                break;
            }

            result.add(closestPrism.id());
            currentLaserX = closestPrism.x();
            currentLaserY = closestPrism.y();
            currentLaserAngle = normaliseAngle(currentLaserAngle + closestPrism.angle());
        }

        return result;
    }
}
