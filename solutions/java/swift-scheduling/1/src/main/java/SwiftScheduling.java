import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class SwiftScheduling {
    public static LocalDateTime convertToDeliveryDate(LocalDateTime meetingStart, String description) {
        if (description.equals("NOW")) {
            return meetingStart.plusHours(2);

        } else if (description.equals("ASAP")) {
            if (meetingStart.getHour() < 13) {
                return meetingStart.withHour(17).withMinute(0).withSecond(0);
            } else {
                return meetingStart.plusDays(1).withHour(13).withMinute(0).withSecond(0);
            }

        } else if (description.equals("EOW")) {
            int dayOfWeek = meetingStart.getDayOfWeek().getValue();
            if (dayOfWeek <= 3) {
                int daysUntilFriday = 5 - dayOfWeek;
                return meetingStart.plusDays(daysUntilFriday).withHour(17).withMinute(0).withSecond(0);
            } else {
                int daysUntilSunday = 7 - dayOfWeek;
                return meetingStart.plusDays(daysUntilSunday).withHour(20).withMinute(0).withSecond(0);
            }

        } else if (description.endsWith("M")) {
            int targetMonth = Integer.parseInt(description.substring(0, description.length() - 1));
            int targetYear = meetingStart.getYear();

            if (meetingStart.getMonthValue() >= targetMonth) {
                targetYear++;
            }

            LocalDateTime deliveryDate = LocalDateTime.of(targetYear, targetMonth, 1, 8, 0, 0);

            if (deliveryDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
                deliveryDate = deliveryDate.plusDays(2);
            } else if (deliveryDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                deliveryDate = deliveryDate.plusDays(1);
            }

            return deliveryDate;

        } else if (description.startsWith("Q")) {
            int targetQuarter = Integer.parseInt(description.substring(1));
            int currentQuarter = (meetingStart.getMonthValue() - 1) / 3 + 1;

            int targetYear = meetingStart.getYear();

            if (currentQuarter > targetQuarter) {
                targetYear++;
            }

            int lastMonthOfQuarter = targetQuarter * 3;

            LocalDateTime deliveryDate = LocalDateTime.of(
                    targetYear,
                    lastMonthOfQuarter,
                    1,
                    8,
                    0,
                    0
            ).plusMonths(1).minusDays(1);

            if (deliveryDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
                deliveryDate = deliveryDate.minusDays(1);
            } else if (deliveryDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                deliveryDate = deliveryDate.minusDays(2);
            }

            return deliveryDate;
        }

        return null;
    }
}
