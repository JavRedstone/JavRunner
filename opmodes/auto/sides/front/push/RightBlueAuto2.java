package opmodes.auto.sides.front.push;

import generic.classes.Point;
import opmodes.auto.classes.AutoAction;
import opmodes.auto.classes.AutoPath;
import opmodes.auto.classes.AutoPoint;
import opmodes.base.BaseAuto;
import wrappers.Game;

import java.util.ArrayList;

public class RightBlueAuto2 extends BaseAuto {
    @Override
    public void runSetup() {
    }
    @Override
    public void createPoints() {
        // based off of front of robot
        points.add(new AutoPoint(new Point(0, 4.5 * Game.TS), new ArrayList<>(), false));
        ArrayList<AutoAction> purpleActions = new ArrayList<>();
        ArrayList<AutoAction> yellowActions = new ArrayList<>();

        robotSim.startPoint = new Point(0, 4.5 * Game.TS);
        robotSim.currPoint = robotSim.startPoint;

        switch(route) {
            case 0:
//                purpleActions.add(new TurnAction(chassis, 1, 45));
//                AutoPathHelper.addRollerBackwardMovement(chassis, purpleActions);
                points.add(new AutoPoint(new Point(1.75 * Game.TS, 4 * Game.TS), purpleActions, false));
                points.add(new AutoPoint(new Point(1 * Game.TS, 4.25 * Game.TS), purpleActions, true));
                points.add(new AutoPoint(new Point(2.5 * Game.TS, 4.5 * Game.TS), purpleActions, false));
                points.add(new AutoPoint(new Point(2.5 * Game.TS, 2 * Game.TS), purpleActions, false));
                points.add(new AutoPoint(new Point(1.25 * Game.TS, 1 * Game.TS), purpleActions, false));
                points.add(new AutoPoint(new Point(1.25 * Game.TS, 0.9 * Game.TS), yellowActions, false));
                break;
            case 2:
//                purpleActions.add(new TurnAction(chassis, 1, -45));
//                AutoPathHelper.addRollerBackwardMovement(chassis, purpleActions);
                points.add(new AutoPoint(new Point(1.75 * Game.TS, 5 * Game.TS), purpleActions, false));
                points.add(new AutoPoint(new Point(1.25 * Game.TS, 4.75 * Game.TS), purpleActions, true));
                points.add(new AutoPoint(new Point(2.5 * Game.TS, 4.5 * Game.TS), purpleActions, false));
                points.add(new AutoPoint(new Point(2.5 * Game.TS, 2 * Game.TS), purpleActions, false));
                points.add(new AutoPoint(new Point(1.75 * Game.TS, 1 * Game.TS), purpleActions, false));
                points.add(new AutoPoint(new Point(1.75 * Game.TS, 0.9 * Game.TS), yellowActions, false));
                break;
            case 1:
            default:
//                AutoPathHelper.addRollerBackwardMovement(chassis, purpleActions);
                points.add(new AutoPoint(new Point(2 * Game.TS, 4.5 * Game.TS), purpleActions, false));
                points.add(new AutoPoint(new Point(1.25 * Game.TS, 4.5 * Game.TS), purpleActions, true));
                points.add(new AutoPoint(new Point(2.5 * Game.TS, 5 * Game.TS), purpleActions, false));
                points.add(new AutoPoint(new Point(2.5 * Game.TS, 2 * Game.TS), purpleActions, false));
                points.add(new AutoPoint(new Point(1.5 * Game.TS, 1 * Game.TS), purpleActions, false));
                points.add(new AutoPoint(new Point(1.5 * Game.TS, 0.9 * Game.TS), yellowActions, false));
                break;
        }
        points.add(new AutoPoint(new Point(0, Game.TS), new ArrayList<>(), false));
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
                robotSim.tick();
            }
        }
    }
}