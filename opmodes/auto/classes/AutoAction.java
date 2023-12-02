package opmodes.auto.classes;

import wrappers.Chassis;

public abstract class AutoAction {
    public Chassis chassis;

    public boolean active = true;
    public boolean isInitialized = false;

    public AutoAction (Chassis chassis) {
        this.chassis = chassis;
        this.chassis.logHelper.addData("AutoAction Initialized", this.getClass().getSimpleName());
        this.active = true;
        this.isInitialized = false;
    }

    public abstract void tick();
}
