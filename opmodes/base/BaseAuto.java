package opmodes.base;

import opmodes.auto.classes.AutoPath;
import opmodes.auto.classes.AutoPoint;

import java.util.ArrayList;

public abstract class BaseAuto extends BaseOpmode {
    public int route = 0;
    public ArrayList<AutoPoint> points = new ArrayList<>();
    public AutoPath path;
    public AutoPath autoPath;

    public abstract void createPoints();
}
