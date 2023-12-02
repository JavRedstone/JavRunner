package opmodes.auto.sides.middle;

import generic.classes.Point;
import generic.helpers.MathHelper;
import opmodes.auto.classes.AutoAction;
import opmodes.auto.classes.AutoPath;
import opmodes.auto.classes.AutoPoint;
import opmodes.base.BaseAuto;
import wrappers.Game;

import java.util.ArrayList;

public class LeftRedAuto3 extends BaseAuto {
    @Override
    public void runSetup() {
    }
    @Override
    public void createPoints() {
        // based off of front of robot
        points.add(new AutoPoint(new Point(5.5 * Game.TILE_SIZE, 4.5 * Game.TILE_SIZE), new ArrayList<>(), false));
        ArrayList<AutoAction> purpleActions = new ArrayList<>();
        ArrayList<AutoAction> yellowActions = new ArrayList<>();

        robotSim.startPoint = new Point(5.5 * Game.TILE_SIZE, 4.5 * Game.TILE_SIZE);
        robotSim.currPoint = robotSim.startPoint;
        robotSim.currHeading = MathHelper.headingToAngle(-90);

        switch(route) {
            case 0:
                points.add(new AutoPoint(new Point(4.75 * Game.TILE_SIZE, 4.75 * Game.TILE_SIZE), purpleActions, true));
                points.add(new AutoPoint(new Point(5.25 * Game.TILE_SIZE, 4.5 * Game.TILE_SIZE), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(3.5 * Game.TILE_SIZE, 4.5 * Game.TILE_SIZE), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(3.5 * Game.TILE_SIZE, 2 * Game.TILE_SIZE), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(4.25 * Game.TILE_SIZE, 1.25 * Game.TILE_SIZE), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(4.25 * Game.TILE_SIZE, 1.2 * Game.TILE_SIZE), yellowActions, false));
                break;
            case 2:
                points.add(new AutoPoint(new Point(4.75 * Game.TILE_SIZE, 4.25 * Game.TILE_SIZE), purpleActions, true));
                points.add(new AutoPoint(new Point(5.25 * Game.TILE_SIZE, 4.5 * Game.TILE_SIZE), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(3.5 * Game.TILE_SIZE, 4.5 * Game.TILE_SIZE), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(3.5 * Game.TILE_SIZE, 2 * Game.TILE_SIZE), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(4.25 * Game.TILE_SIZE, 1.25 * Game.TILE_SIZE), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(4.25 * Game.TILE_SIZE, 1.2 * Game.TILE_SIZE), yellowActions, false));
                break;
            case 1:
            default:
                points.add(new AutoPoint(new Point(4.5 * Game.TILE_SIZE, 4.5 * Game.TILE_SIZE), purpleActions, true));
                points.add(new AutoPoint(new Point(4.75 * Game.TILE_SIZE, 4.5 * Game.TILE_SIZE), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(3.5 * Game.TILE_SIZE, 5 * Game.TILE_SIZE), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(3.5 * Game.TILE_SIZE, 2 * Game.TILE_SIZE), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(4.5 * Game.TILE_SIZE, 1.25 * Game.TILE_SIZE), new ArrayList<>(), false));
                points.add(new AutoPoint(new Point(4.5 * Game.TILE_SIZE, 1.2 * Game.TILE_SIZE), yellowActions, false));
                break;
        }
        points.add(new AutoPoint(new Point(5.5 * Game.TILE_SIZE, Game.TILE_SIZE), new ArrayList<>(), false));
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
            }
            robotSim.tick();
        }
    }
}