package opmodes.auto.sides.front.pull;

import opmodes.auto.classes.AutoAction;
import opmodes.auto.classes.AutoPath;
import opmodes.auto.classes.AutoPoint;
import opmodes.base.BaseAuto;
import generic.classes.Point;
import wrappers.Game;

import java.util.ArrayList;

public class LeftBlueAuto extends BaseAuto {
    @Override
    public void runSetup() {
    }

    @Override
    public void createPoints() {
        // based off of front of robot
        points.add(new AutoPoint(new Point(0, 2.5 * Game.TS), new ArrayList<>(), true));
        
        robotSim.startPoint = new Point(0, 2.5 * Game.TS);
        robotSim.currPoint = robotSim.startPoint;
        
        ArrayList<AutoAction> purpleActions = new ArrayList<>();
        ArrayList<AutoAction> yellowActions = new ArrayList<>();

        switch(route) {
            case 0:
//                AutoPathHelper.addRollerBackwardMovement(chassis, purpleActions);
                points.add(new AutoPoint(new Point(1.5 * Game.TS, 1.75 * Game.TS), purpleActions, true));
                points.add(new AutoPoint(new Point(1.25 * Game.TS, 1 * Game.TS), yellowActions, true));
                break;
            case 2:
//                purpleActions.add(new TurnAction(chassis, 1, -45)); <- remove for now
//                AutoPathHelper.addRollerBackwardMovement(chassis, purpleActions);
                points.add(new AutoPoint(new Point(2 * Game.TS, 3 * Game.TS), purpleActions, true));
                points.add(new AutoPoint(new Point(1.75 * Game.TS, 1 * Game.TS), yellowActions, true));
                break;
            case 1:
            default:
//                AutoPathHelper.addRollerBackwardMovement(chassis, purpleActions);
                points.add(new AutoPoint(new Point(2 * Game.TS, 2.5 * Game.TS), purpleActions, true));
                points.add(new AutoPoint(new Point(1.5 * Game.TS, 1 * Game.TS), yellowActions, true));
                break;
        }
        points.add(new AutoPoint(new Point(0.5 * Game.TS, Game.TS), new ArrayList<>(), true));
        path = new AutoPath(chassis, points, -90);
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