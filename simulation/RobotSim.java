package simulation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import generic.classes.Point;
import generic.helpers.LogHelper;
import generic.helpers.MathHelper;
import wrappers.Chassis;
import wrappers.Game;

public class RobotSim {
    public static final double SLOW_DT = 0.000003;
    public static final double FAST_DT = 0.00025;

    public Chassis chassis;
    public RobotVisualization visualization;

    public Point startPoint = new Point(0, 0);
    public Point currPoint = new Point(0, 0);
    public double currHeading = 0.0;
    public long prevTime = 0;

    public RobotSim(Chassis chassis) {

        this.chassis = chassis;
        JFrame frame = new JFrame("Robot Visualization");
        this.visualization = new RobotVisualization();

        frame.add(visualization);
        frame.setSize((int)(Game.TS * Game.FIELD_WIDTH * this.visualization.scaleFactor), (int)(Game.TS * Game.FIELD_HEIGHT * this.visualization.scaleFactor));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
    
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
                // y: 89
                // i: 73
                // h: 72
                // k: 75
                if (e.getKeyCode() == 89) {
                    // y
                    System.out.println("y pressed");
                    if (chassis.fl.power != 1) {
                        chassis.fl.setPower(1);
                    }
                    else {
                        chassis.fl.setPower(0);
                    }
                }
                else if (e.getKeyCode() == 73) {
                    // i
                    System.out.println("i pressed");
                    if (chassis.fr.power != 1) {
                        chassis.fr.setPower(1);
                    }
                    else {
                        chassis.fr.setPower(0);
                    }
                }
                else if (e.getKeyCode() == 72) {
                    // h
                    System.out.println("h pressed");
                    if (chassis.fl.power != -1) {
                        chassis.fl.setPower(-1);
                    }
                    else {
                        chassis.fl.setPower(0);
                    }
                }
                else if (e.getKeyCode() == 75) {
                    // k
                    System.out.println("k pressed");
                    if (chassis.fr.power != -1) {
                        chassis.fr.setPower(-1);
                    }
                    else {
                        chassis.fr.setPower(0);
                    }
                }
            }
    
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public void tick() {
        if (chassis.fl != null && chassis.fr != null) {
            // Calculate distance traveled by each wheel in this time interval
            double leftDistance = chassis.fl.power * Chassis.MOVE_DISTANCE_PER_SECOND * SLOW_DT;
            double rightDistance = chassis.fr.power * Chassis.MOVE_DISTANCE_PER_SECOND * SLOW_DT;

            // Update the robot's position and heading based on wheel movement
            double distanceTraveled = (leftDistance + rightDistance) / 2.0;
            double deltaHeading = (leftDistance - rightDistance) / Chassis.ROBOT_WIDTH;

            // Update current heading and position
            currHeading += Math.toDegrees(deltaHeading);
            currHeading = MathHelper.toHeading(currHeading); // Keep heading between 0 and 360 (exclusive)

            currPoint.x += distanceTraveled * Math.cos(Math.toRadians(currHeading));
            currPoint.y += distanceTraveled * Math.sin(Math.toRadians(currHeading));

            // Update the log helper
            // LogHelper.addDataStatic("LeftDistance", leftDistance);
            // LogHelper.addDataStatic("RightDistance", rightDistance);
            // LogHelper.addDataStatic("DistanceTraveled", distanceTraveled);
            // LogHelper.addDataStatic("DeltaHeading", deltaHeading);
            // LogHelper.addDataStatic("CurrPoint", currPoint);
            // LogHelper.addDataStatic("CurrHeading", currHeading);

            // Update the visualization
            visualization.updateRobotPosition(currPoint.x, currPoint.y, currHeading);
        }
    }
}
