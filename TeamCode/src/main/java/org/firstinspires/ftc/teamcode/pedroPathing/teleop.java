package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "teleop good")
public class teleop extends OpMode {

    DcMotor lf, rf;
    DcMotor lr, rr;
    DcMotor shooter;
    Gamepad currentGamepad2 = new Gamepad();
    Gamepad previousGamepad2 = new Gamepad();
    int intake = 0;

    @Override
    public void init() {
        lf = hardwareMap.get(DcMotor.class, "lf");
        lr = hardwareMap.get(DcMotor.class, "lr");
        rf = hardwareMap.get(DcMotor.class, "rf");
        rr = hardwareMap.get(DcMotor.class, "rr");
        shooter = hardwareMap.get(DcMotor.class, "shooter");



    }

    @Override
    public void loop() {
        lf.setPower(-gamepad1.right_stick_y + -gamepad1.left_stick_x * 1.1 + gamepad1.right_stick_x);
        lr.setPower(gamepad1.right_stick_y + -gamepad1.left_stick_x * 1.1 -gamepad1.right_stick_x);
        rf.setPower(-gamepad1.right_stick_y + gamepad1.left_stick_x * 1.1 -gamepad1.right_stick_x);
        rr.setPower(gamepad1.right_stick_y + gamepad1.left_stick_x * 1.1 + gamepad1.right_stick_x);


        if (currentGamepad2.b && !previousGamepad2.b) {
            if (intake == 1) { //position 0 -> 1



                shooter.setPower(1);


                intake = 0;

            } else if (intake == 0) { //position 1 -> 0

                shooter.setPower(0);
                intake = 1;

            }
        }




    }
}