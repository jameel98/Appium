package logic.utils;

import logic.enums.EventType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    private static String eventName;
    private static String eventDescription;
    private static EventType eventType;
    private static int startHour;
    private static int endHour;
    private static int startMinute;
    private static int endMinute;
    private static String date;

    public static String generateRandomString( int targetStringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
    public static String getEventName() {
        eventName = generateRandomString(10);
        return eventName;
    }

    public static String getEventDescription() {
        eventDescription = generateRandomString(100);
        return eventDescription;
    }

    public static EventType getEventRandomType() {
        int rand = ThreadLocalRandom.current().nextInt(1,3);
        switch (rand){
            case 1:
                eventType = EventType.TASK;
                break;
            case 2:
                eventType = EventType.IMPORTANT;
                break;
            case 3:
                eventType = EventType.NOT_FORGET;
                break;
        }
        return eventType;
    }

    public static int  getStartHour() {
        startHour = ThreadLocalRandom.current().nextInt(1,12);
        return startHour;
    }

    public static int getEndHour() {
        endHour = ThreadLocalRandom.current().nextInt(1,24);
        return endHour;
    }

    public static int getStartMinute() {
        startMinute = ThreadLocalRandom.current().nextInt(0,59);
        return startMinute;
    }

    public static int getEndMinute() {
        endMinute = ThreadLocalRandom.current().nextInt(0,59);
        return endMinute;
    }

    public static String getDate() {
        date = getTomorrowDate();
        return date;
    }
    public static String getTomorrowDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate tomorrowDate = currentDate.plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return tomorrowDate.format(formatter);
    }

}
