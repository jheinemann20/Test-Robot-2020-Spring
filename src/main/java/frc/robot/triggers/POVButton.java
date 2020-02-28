package frc.robot.triggers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * A custom `Trigger` class that splits the POV up into 8 buttons. Buttons 1, 3, 5, and 7 are up, down, left, and right, and the ones inbetween are the 45 degree angles.
 */
public class POVButton extends Trigger {

    private GenericHID controller;
    private int number;

    public POVButton(GenericHID controller, int number) {
        this.controller = controller;
        this.number = number;
    }

    @Override
    public boolean get() {
        return controller.getPOV() == (45 * number - 45);
    }
}