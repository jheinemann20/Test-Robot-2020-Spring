package frc.robot.triggers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * A custom `Trigger` class that triggers when the (absolute) value of the raw axis exceeds the provided or inferred deadband (defaults to 0)
 */
public class AxisButton extends Trigger {

    private GenericHID controller;
    private int axis;
    private double deadband;

    public AxisButton(GenericHID controller, int axis, double deadband) {
        this.controller = controller;
        this.axis = axis;
        this.deadband = deadband;
    }

    public AxisButton(GenericHID controller, int axis) {
        this.controller = controller;
        this.axis = axis;
        this.deadband = 0;
    }

    @Override
    public boolean get() {
        if (Math.abs(controller.getRawAxis(axis)) > deadband)
            return true;
        else
            return false;
        // This returns whether the trigger is active
    }
}