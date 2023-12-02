// package opmodes.teleop;

// import generic.helpers.MathHelper;
// import opmodes.base.BaseTeleop;

// public class TankDriveTeleOp extends BaseTeleop {
//     public static final double JOYSTICK_DEADZONE = 0.1;
    
//     @Override
//     public void runSetup() {
//     }

//     @Override
//     public void runLoop() {
//         double lx = gamepad1.left_stick_x, ly = gamepad1.left_stick_y, rx = gamepad1.right_stick_x, ry = gamepad1.right_stick_y;
//         boolean a = gamepad1.a, b = gamepad1.b, x = gamepad1.x, y = gamepad1.y;
//         // Tank drive
//         chassis.fl.setPower(MathHelper.deadzone(ly, JOYSTICK_DEADZONE));
//         chassis.fr.setPower(MathHelper.deadzone(ry, JOYSTICK_DEADZONE));
//         // two wheeled
//         if (!Chassis.TWO_WHEELED) {
//             chassis.bl.setPower(MathHelper.deadzone(ly, JOYSTICK_DEADZONE));
//             chassis.br.setPower(MathHelper.deadzone(ry, JOYSTICK_DEADZONE));
//         }
//     }
// }
