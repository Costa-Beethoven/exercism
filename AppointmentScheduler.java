
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        return LocalDateTime.parse(appointmentDateDescription, formatter);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        LocalTime intervalStart = LocalTime.parse("11:59:59");
        LocalTime intervalEnd = LocalTime.parse("18:00:00");
        LocalTime appointmentTime = appointmentDate.toLocalTime();

        return appointmentTime.isBefore(intervalEnd) && appointmentTime.isAfter(intervalStart);
    }

    public String getDescription(LocalDateTime appointmentDate) {
        String dayOfTheWeekAux = String.valueOf(appointmentDate.getDayOfWeek());
        String dayOfTheWeek = dayOfTheWeekAux.charAt(0) + dayOfTheWeekAux.substring(1).toLowerCase();

        String monthAux = String.valueOf(appointmentDate.getMonth());
        String month = monthAux.charAt(0) + monthAux.substring(1).toLowerCase();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a").withLocale(Locale.US);
        String hour = appointmentDate.format(formatter);

        return "You have an appointment on " + dayOfTheWeek + ", " + month
                + " " + appointmentDate.getDayOfMonth() + ", " + appointmentDate.getYear() + ", at "
                + hour + ".";
    }

    public LocalDate getAnniversaryDate() {
        String anniversary = "2026-09-15";
        return LocalDate.parse(anniversary);
    }
}
