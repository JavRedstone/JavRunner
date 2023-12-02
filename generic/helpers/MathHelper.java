package generic.helpers;

public class MathHelper {
    public static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    public static double deadzone(double value, double deadzone) {
        return Math.abs(value) < deadzone ? 0 : value;
    }

    public static double radius(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    public static double angle(double x, double y) {
        return Math.atan2(y, x);
    }

    public static double toHeading(double angle) {
        angle = angle % 360;
        if (angle < -180) {
            return 360 + angle;
        }
        else if (angle > 180) {
            return angle - 360;
        }
        else {
            return angle;
        }
    }

    public static double headingToAngle(double heading) {
        return 90 - heading;
    }

    public static double percentChange(double value1, double value2) {
        return (value2 - value1) / value1;
    }

    public static double percentError(double value1, double value2) {
        return Math.abs(percentChange(value1, value2)) * 100;
    }
}
