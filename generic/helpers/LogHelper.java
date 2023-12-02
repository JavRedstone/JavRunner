package generic.helpers;

import wrappers.Chassis;

public class LogHelper {
    Chassis chassis;

    public LogHelper(Chassis chassis) {
        this.chassis = chassis;
    }

    public void addData(String key, Object value) {
        // if (key.equals("Running") ) // || key.equals("Active point index")
        // if (key.equals("Angle at point")) {
        // if (key.equals("Line angles") || key.equals("Angles")) {
        //     System.out.println(key + ": " + value);
        // }
    }

    public static void addDataStatic(String key, Object value) {
        System.out.println(key + ": " + value);
    }

    public void update() {
    }
}