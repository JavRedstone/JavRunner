package opmodes.auto.actions;

import opmodes.auto.classes.AutoAction;
import wrappers.Chassis;

public class MoveAction extends AutoAction {
    public double power;
    public boolean isReverse = false;

    public MoveAction (Chassis chassis, double power, boolean reverse) {
        super(chassis);
        if (reverse) {
            this.power = -power;
        }
        else {
            this.power = power;
        }
        this.isReverse = reverse;
    }

    public MoveAction (Chassis chassis, double power) {
        super(chassis);
        this.power = power;
    }

    public void tick() {
        chassis.logHelper.addData("Running", "MoveAction");
        chassis.logHelper.addData("Power FR", power);
        chassis.logHelper.addData("Power FL", power);
        chassis.logHelper.addData("Power BR", power);
        chassis.logHelper.addData("Power BL", power);
        chassis.logHelper.addData("Power BL", power);
        chassis.logHelper.addData("IsReverse", isReverse);
        if (!isInitialized) {
            chassis.fr.setPower(power);
            chassis.fl.setPower(power);
            if (!Chassis.TWO_WHEELED) {
                chassis.br.setPower(power);
                chassis.bl.setPower(power);
            }
            isInitialized = true;
        }
        active = false;
    }
}
