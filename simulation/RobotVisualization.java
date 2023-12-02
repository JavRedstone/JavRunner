package simulation;

import javax.swing.*;

import wrappers.Chassis;
import wrappers.Game;

import java.awt.*;

public class RobotVisualization extends JPanel {
    public double scaleFactor = 5; // Adjust this value to scale the drawing
    public double robotX;
    public double robotY;
    public double robotHeading; // Angle in degrees

    public void updateRobotPosition(double x, double y, double heading) {
        robotX = x;
        robotY = y;
        robotHeading = heading;
        repaint(); // Request the panel to repaint itself with updated values
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    
        int robotSize = (int) (Chassis.ROBOT_LENGTH * scaleFactor); // Size of the robot representation
    
        Graphics2D g2d = (Graphics2D) g;
    
        // Draw grid lines representing tiles on the FTC board
        g2d.setColor(Color.LIGHT_GRAY);
    
        // Calculate the center position
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
    
        // Draw vertical grid lines
        for (int i = 0; i <= Game.FIELD_WIDTH; i++) {
            int x = (int) (centerX + (i - Game.FIELD_WIDTH / 2) * Game.TILE_SIZE * scaleFactor);
            g2d.drawLine(x, (int) (centerY - Game.FIELD_HEIGHT / 2 * Game.TILE_SIZE * scaleFactor),
                         x, (int) (centerY + Game.FIELD_HEIGHT / 2 * Game.TILE_SIZE * scaleFactor));
        }
    
        // Draw horizontal grid lines
        for (int i = 0; i <= Game.FIELD_HEIGHT; i++) {
            int y = (int) (centerY + (i - Game.FIELD_HEIGHT / 2) * Game.TILE_SIZE * scaleFactor);
            g2d.drawLine((int)(centerX - Game.FIELD_WIDTH / 2 * Game.TILE_SIZE * scaleFactor), y,
                         (int)(centerX + Game.FIELD_WIDTH / 2 * Game.TILE_SIZE * scaleFactor), y);
        }
    
        // Draw robot components at its actual position
        int robotXPos = (int) (robotX * scaleFactor);
        int robotYPos = (int) (robotY * scaleFactor);
    
        // Draw robot as a square indicating its orientation
        int halfSize = robotSize / 2;
        g2d.translate(robotXPos, robotYPos);
        g2d.rotate(Math.toRadians(robotHeading)); // Rotate based on robot heading
        g2d.setColor(Color.BLUE);
        g2d.fillRect(-halfSize, -halfSize, robotSize, robotSize);
    
        // Draw a line indicating the robot's heading
        int lineLength = robotSize / 2;
        g2d.setColor(Color.RED);
        g2d.drawLine(0, 0, lineLength, 0);
    
        // Draw a point to represent the robot's position
        int ovalSize = 6; // Size of the oval representing the robot's position
        g2d.setColor(Color.GREEN);
        g2d.fillOval(-ovalSize / 2, -ovalSize / 2, ovalSize, ovalSize);
    }
    

    public static void main(String[] args) {
        JFrame frame = new JFrame("Robot Visualization");
        RobotVisualization visualization = new RobotVisualization();

        frame.add(visualization);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Example usage: Update robot position and heading in a loop
        for (int i = 0; i < 360; i += 10) {
            double x = Math.cos(Math.toRadians(i)) * Chassis.ROBOT_LENGTH; // Replace with your robot's x position
            double y = Math.sin(Math.toRadians(i)) * Chassis.ROBOT_LENGTH; // Replace with your robot's y position
            visualization.updateRobotPosition(x, y, i); // Replace with your robot's heading
            try {
                Thread.sleep(100); // Adjust for your desired update frequency
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

