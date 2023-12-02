package opmodes.auto.actions;

import opmodes.auto.classes.AutoAction;
import wrappers.Chassis;

public class WaitAction extends AutoAction {
    public long startTime;
    public long waitTime;
    public boolean isInitialized = false;

    public WaitAction (Chassis chassis, long waitTime) {
        super(chassis);
        this.waitTime = waitTime;
    }

    public void tick() {
        chassis.logHelper.addData("Running", "WaitAction");
        if (!this.isInitialized) {
            this.startTime = System.currentTimeMillis();
            this.isInitialized = true;
        }
        chassis.logHelper.addData("StartTime", startTime);
        chassis.logHelper.addData("WaitTime", waitTime);
        chassis.logHelper.addData("CurrentTime", System.currentTimeMillis());
        chassis.logHelper.addData("Difference", System.currentTimeMillis() - startTime);
        if (System.currentTimeMillis() - startTime >= waitTime) {
            active = false;
        }
    }
}
