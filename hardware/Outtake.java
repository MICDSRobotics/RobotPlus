package org.firstinspires.ftc.teamcode.robotplus.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by amigala on 3/1/2018.
 */

public class Outtake {
    private Servo servo;

    public Outtake() {
        this.servo = null;
    }

    public Outtake(HardwareMap hardwareMap) {
        this.servo = hardwareMap.get(Servo.class, "outtake");
        this.servo.scaleRange(0.235, 0.755);
    }

    public void spitOutGlyph() {
        // TODO: find the position that the outtake will spit the glyph out
        this.servo.setPosition(0.05);
    }

    public void retractOuttake() {
        // TODO: find the position that the outtake will take the glyph back in (neutral position)
        this.servo.setPosition(0.95);
    }

    public Servo getServo() {
        return this.servo;
    }
}
