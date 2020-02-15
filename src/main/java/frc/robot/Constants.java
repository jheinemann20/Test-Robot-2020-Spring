/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    // DriveTrain Motor IDs
    public static final int FRONT_LEFT_MOTOR = 5;
    public static final int FRONT_RIGHT_MOTOR = 4;
    public static final int REAR_LEFT_MOTOR = 3;
    public static final int REAR_RIGHT_MOTOR = 2;

    // Shooter Motor IDs
    public static final int SHOOTER_MOTOR = 0;

    // Lifter Motor IDs
    public static final int FRONT_LIFTER_MOTOR = 11;
    public static final int REAR_LIFTER_MOTOR = 9;

    public static final int[] FRONT_LIFTER_ENCODER = {0, 1};
    public static final int[] REAR_LIFTER_ENCODER = {2, 3};

    // Solenoid IDs
    public static final int SHIFT_FORWARD_SOL = 0;
    public static final int SHIFT_REVERSE_SOL = 1;

    // DriveStick Controls
    public static final double DRIVESTICK_DEADBAND = 0.05;

    public static final int SHIFT_BUTTON = 1;

    // SecondaryStick Controls
    public static final int LIFT_UP_AXIS = 2;
    public static final int LIFT_DOWN_AXIS = 3;
    public static final int SHOOTER_SHOOT_BUTTON = 6;
    public static final int SHOOTER_LOAD_BUTTON = 5;
}
