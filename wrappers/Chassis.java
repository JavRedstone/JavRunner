package wrappers;

import classes.DcMotorEx;
import classes.Direction;
import generic.helpers.LogHelper;

public class Chassis {
    public static final boolean TWO_WHEELED = true;

    public static final double MOVE_POWER = 0.5;
    public static final double SLOW_MOVE_POWER = 0.25;

    public static final int ROBOT_WIDTH = 18; // inches
    public static final int HRW = ROBOT_WIDTH / 2; // inches
    public static final int ROBOT_LENGTH = 18; // inches
    public static final int HRL = ROBOT_LENGTH / 2; // inches
    public static final double MOVE_DISTANCE_PER_SECOND = 48 * MOVE_POWER; // inches
    public static final double TURN_DISTANCE_PER_SECOND = 185 * MOVE_POWER; // inches
    public static final double TURN_ANGLE_PER_SECOND = 180 * MOVE_POWER; // degrees

    public DcMotorEx fr, fl, br, bl;
    public LogHelper logHelper = new LogHelper(this);

    public Chassis() {
        initializeMotors();
    }

    public void initializeMotors() {
        fr = new DcMotorEx("fr");
        fl = new DcMotorEx("fl");
        if (!TWO_WHEELED) {
            br = new DcMotorEx("br");
            bl = new DcMotorEx("bl");
        }

        fr.setDirection(Direction.FORWARD);
        fl.setDirection(Direction.REVERSE);
        if (!TWO_WHEELED) {
            br.setDirection(Direction.FORWARD);
            bl.setDirection(Direction.REVERSE);
        }
    }
}
