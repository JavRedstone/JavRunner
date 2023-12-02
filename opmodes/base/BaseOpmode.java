package opmodes.base;

import simulation.RobotSim;
import wrappers.Chassis;

public abstract class BaseOpmode {
    public Chassis chassis;
    public RobotSim robotSim;
    public boolean isOpModeActive = true;

    public void runOpMode() {
        chassis = new Chassis();
        robotSim = new RobotSim(chassis);
        runSetup();
        while (opModeIsActive()) {
            runLoop();
        }
    }

    public boolean opModeIsActive() {
        return isOpModeActive;
    }

    public abstract void runSetup();
    public abstract void runLoop();
}
