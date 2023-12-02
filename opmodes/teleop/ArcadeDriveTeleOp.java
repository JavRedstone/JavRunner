// package opmodes.teleop;

// import generic.helpers.MathHelper;
// import opmodes.base.BaseTeleop;
// import wrappers.Chassis;

// public class ArcadeDriveTeleOp extends BaseTeleop {
//     public static final double JOYSTICK_DEADZONE = 0.1;
    
//     @Override
//     public void runSetup() {
//     }

//     @Override
//     public void runLoop() {
//         double lx = gamepad1.left_stick_x, ly = gamepad1.left_stick_y, rx = gamepad1.right_stick_x, ry = gamepad1.right_stick_y;
//         boolean a = gamepad1.a, b = gamepad1.b, x = gamepad1.x, y = gamepad1.y;
//         // Arcade drive
//         chassis.fl.setPower(MathHelper.deadzone(ly + rx, JOYSTICK_DEADZONE));
//         chassis.fr.setPower(MathHelper.deadzone(ly - rx, JOYSTICK_DEADZONE));
//         if (!Chassis.TWO_WHEELED) {
//             chassis.bl.setPower(MathHelper.deadzone(ly + rx, JOYSTICK_DEADZONE));
//             chassis.br.setPower(MathHelper.deadzone(ly - rx, JOYSTICK_DEADZONE));
//         }
//     }
// }
