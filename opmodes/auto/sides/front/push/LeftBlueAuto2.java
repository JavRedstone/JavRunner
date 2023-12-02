package opmodes.auto.sides.front.push;

import generic.classes.Point;
import opmodes.auto.classes.AutoAction;
import opmodes.auto.classes.AutoPath;
import opmodes.auto.classes.AutoPoint;
import opmodes.base.BaseAuto;
import wrappers.Game;

import java.util.ArrayList;

public class LeftBlueAuto2 extends BaseAuto {

    @Override
    public void runSetup() {
    }

    @Override
    public void createPoints() {
        // based off of front of robot
        points.add(new AutoPoint(new Point(0, 2.5 * Game.TILE_SIZE), new ArrayList<>(), false));
        ArrayList<AutoAction> purpleActions = new ArrayList<>();
        ArrayList<AutoAction> yellowActions = new ArrayList<>();

        robotSim.startPoint = new Point(0, 2.5 * Game.TILE_SIZE);
        robotSim.currPoint = robotSim.startPoint;

        switch(route) {
            case 0:
//                AutoPathHelper.addRollerBackwardMovement(chassis, purpleActions);
                points.add(new AutoPoint(new Point(1.75 * Game.TILE_SIZE, 2 * Game.TILE_SIZE), purpleActions, false));
                points.add(new AutoPoint(new Point(1.25 * Game.TILE_SIZE, 2.25 * Game.TILE_SIZE), purpleActions, true));
                points.add(new AutoPoint(new Point(1.25 * Game.TILE_SIZE, 1 * Game.TILE_SIZE), purpleActions, false));
                points.add(new AutoPoint(new Point(1.25 * Game.TILE_SIZE, 0.9 * Game.TILE_SIZE), yellowActions, false));
//                points.add(new AutoPoint(new Point(0.5 * Game.TILE_SIZE, 1 * Game.TILE_SIZE), yellowActions, false));
                break;
            case 2:
//                purpleActions.add(new TurnAction(chassis, 1, -45)); // try removing this
//                AutoPathHelper.addRollerBackwardMovement(chassis, purpleActions);
                points.add(new AutoPoint(new Point(1.75 * Game.TILE_SIZE, 3 * Game.TILE_SIZE), purpleActions, false));
                points.add(new AutoPoint(new Point(1.25 * Game.TILE_SIZE, 2.75 * Game.TILE_SIZE), purpleActions, true));
                points.add(new AutoPoint(new Point(1.75 * Game.TILE_SIZE, 1 * Game.TILE_SIZE), purpleActions, false));
                points.add(new AutoPoint(new Point(1.75 * Game.TILE_SIZE, 0.9 * Game.TILE_SIZE), yellowActions, false));
//                points.add(new AutoPoint(new Point(0.5 * Game.TILE_SIZE, 1 * Game.TILE_SIZE), yellowActions, false));
                break;
            case 1:
            default:
//                AutoPathHelper.addRollerBackwardMovement(chassis, purpleActions);
                points.add(new AutoPoint(new Point(2 * Game.TILE_SIZE, 2.5 * Game.TILE_SIZE), purpleActions, false));
                points.add(new AutoPoint(new Point(1.5 * Game.TILE_SIZE, 2.5 * Game.TILE_SIZE), purpleActions, true));
                points.add(new AutoPoint(new Point(1.5 * Game.TILE_SIZE, 1 * Game.TILE_SIZE), purpleActions, false));
                points.add(new AutoPoint(new Point(1.5 * Game.TILE_SIZE, 0.9 * Game.TILE_SIZE), yellowActions, false));
//                points.add(new AutoPoint(new Point(0.5 * Game.TILE_SIZE, 1 * Game.TILE_SIZE), yellowActions, false));
                break;
        }
        points.add(new AutoPoint(new Point(0, Game.TILE_SIZE), new ArrayList<>(), false));
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