package companies.microsoft;

public class AngleBetweenHandsOfAClock {
    public static void main(String[] args) {
        System.out.println(angleClock(12, 30));
        System.out.println(angleClock(3, 30));
        System.out.println(angleClock(3, 15));
    }

    private static double angleClock(int hour, int minutes) {
        double minuteAngle = minutes * 6D;
        double hourAngle = 0.5D * (60D * hour + minutes);

        double angle = Math.abs(minuteAngle - hourAngle);

        return Math.min(angle, 360 - angle);
    }
}
