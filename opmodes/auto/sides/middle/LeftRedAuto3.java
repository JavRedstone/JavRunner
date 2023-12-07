package opmodes.auto.sides.middle;

import generic.classes.Point;
import generic.helpers.MathHelper;
import opmodes.auto.classes.AutoAction;
import opmodes.auto.classes.AutoPath;
import opmodes.auto.classes.AutoPoint;
import opmodes.base.BaseAuto;
import wrappers.Chassis;
import wrappers.Game;

import java.util.ArrayList;

public class LeftRedAuto3 extends BaseAuto {
    @Override
    public void runSetup() {
    }
    @Override
    public void createPoints() {
        ArrayList<AutoAction> initActions = new ArrayList<>();
        points.add(new AutoPoint(new Point(6 * Game.TS - Chassis.HRW, 4.5 * Game.TS), initActions, false));
        ArrayList<AutoAction> purpleActions = new ArrayList<>();
        ArrayList<AutoAction> yellowActions = new ArrayList<>();
//        yellowActions.add(new AprilTagAction(chassis, Game.BLUE_TEAM, route));
//        AutoPathHelper.addArmUpMovement(chassis, yellowActions);
//        AutoPathHelper.addFlapOpenMovement(chassis, yellowActions);
//        yellowActions.add(new WaitAction(chassis, Chassis.FLAP_WAIT_TIME));
//        AutoPathHelper.addArmDownMovement(chassis, yellowActions);

        robotSim.startPoint = new Point(6 * Game.TS - Chassis.HRW, 4.5 * Game.TS);
        robotSim.currPoint = robotSim.startPoint;
        robotSim.currHeading = MathHelper.headingToAngle(-90);

        switch(route) {
            case 2:
                points.add(new AutoPoint(new Point(6 * Game.TS - 1.75 * Game.TS, 4.5 * Game.TS), purpleActions, false));
                points.add(new AutoPoint(new Point(6 * Game.TS - 1.75 * Game.TS, 4 * Game.TS - Chassis.HRW), new ArrayList<>(), true));
                points.add(new AutoPoint(new Point(6 * Game.TS - 1.75 * Game.TS, 4.5 * Game.TS), new ArrayList<>(), true));
                points.add(new AutoPoint(new Point(6 * Game.TS - 2.5 * Game.TS, 4.5 * Game.TS), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(6 * Game.TS - 2.5 * Game.TS, 2 * Game.TS), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(6 * Game.TS - 1.75 * Game.TS, 0.5 * Game.TS + Chassis.HRW + 0.1), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(6 * Game.TS - 1.75 * Game.TS, 0.5 * Game.TS + Chassis.HRW), yellowActions, false));
                break;
            case 0:
                points.add(new AutoPoint(new Point(6 * Game.TS - 1.75 * Game.TS, 4.5 * Game.TS), purpleActions, false));
                points.add(new AutoPoint(new Point(6 * Game.TS - 1.75 * Game.TS, 5 * Game.TS - Chassis.HRW), new ArrayList<>(), true));
                points.add(new AutoPoint(new Point(6 * Game.TS - 1.75 * Game.TS, 4.5 * Game.TS), new ArrayList<>(), true));
                points.add(new AutoPoint(new Point(6 * Game.TS - 2.5 * Game.TS, 4.5 * Game.TS), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(6 * Game.TS - 2.5 * Game.TS, 2 * Game.TS), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(6 * Game.TS - 1.25 * Game.TS, 0.5 * Game.TS + Chassis.HRW + 0.1), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(6 * Game.TS - 1.25 * Game.TS, 0.5 * Game.TS + Chassis.HRW), yellowActions, false));
                break;
            case 1:
            default:
                points.add(new AutoPoint(new Point(6 * Game.TS - (2 * Game.TS - Chassis.HRW), 4.5 * Game.TS), purpleActions, true));
                points.add(new AutoPoint(new Point(6 * Game.TS - 1.5 * Game.TS, 4.5 * Game.TS - Chassis.HRW), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(6 * Game.TS - 1.5 * Game.TS, 5.5 * Game.TS), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(6 * Game.TS - 2.5 * Game.TS, 5.5 * Game.TS), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(6 * Game.TS - 2.5 * Game.TS, 2 * Game.TS), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(6 * Game.TS - 1.25 * Game.TS, 0.5 * Game.TS + Chassis.HRW + 0.1), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(6 * Game.TS - 1.25 * Game.TS, 0.5 * Game.TS + Chassis.HRW), yellowActions, false));
                break;
        }
        points.add(new AutoPoint(new Point(6 * Game.TS - Chassis.HRW, 0.5 * Game.TS), new ArrayList<>(), false));
        path = new AutoPath(chassis, points, 90);
    }

    @Override
    public void runLoop() {
        if (route == -1) {
        }
        else {
            if (points.size() == 0) {
                createPoints();
            }
            chassis.logHelper.addData("Route", route);
            if (path.active) {
                path.tick();
            }
            robotSim.tick();
        }
    }
}