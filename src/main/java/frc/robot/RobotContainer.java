/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.DriveTrainCommands.ArcadeDriveCom;
import frc.robot.commands.DriveTrainCommands.MecanumDriveCom;
import frc.robot.commands.LifterCommands.LiftDownCom;
import frc.robot.commands.LifterCommands.LiftStop;
import frc.robot.commands.LifterCommands.LiftUpCom;
import frc.robot.commands.ShooterCommands.ShootCom;
import frc.robot.subsystems.DriveTrainSub;
import frc.robot.subsystems.LifterSub;
import frc.robot.subsystems.ShooterSub;
import frc.robot.triggers.AxisButton;


/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems and commands are defined here...
  private final DriveTrainSub driveSub = new DriveTrainSub();
  private final LifterSub lifterSub = new LifterSub();
  private final ShooterSub shooterSub = new ShooterSub();

  @JsonIgnore
  private final ArcadeDriveCom arcadeDrive = new ArcadeDriveCom(driveSub);
  @JsonIgnore
  private final MecanumDriveCom mecanumDrive = new MecanumDriveCom(driveSub);

  private final ShootCom shootCom = new ShootCom(shooterSub);

  private final LiftUpCom liftUpCom = new LiftUpCom(lifterSub);
  private final LiftDownCom liftDownCom = new LiftDownCom(lifterSub);
  private final LiftStop liftStopCom = new LiftStop(lifterSub);

  // Joysticks/Controllers
  private static XboxController myJoy = new XboxController(0);
  private static XboxController myJoy2 = new XboxController(1);

  // Buttons
  private JoystickButton shiftButton = new JoystickButton(myJoy, Constants.SHIFT_BUTTON);

  private JoystickButton shootButton = new JoystickButton(myJoy, Constants.SHOOTER_SHOOT_BUTTON);
  private AxisButton liftUpButton  = new AxisButton(myJoy, Constants.LIFT_UP_AXIS, 0.01);
  private AxisButton liftDownButton = new AxisButton(myJoy, Constants.LIFT_DOWN_AXIS, 0.01);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    driveSub.setDefaultCommand(mecanumDrive);
    lifterSub.setDefaultCommand(liftStopCom);
    shootButton.whenPressed(shootCom);
    liftUpButton.whenActive(liftUpCom);
    liftDownButton.whenActive(liftDownCom);
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    shiftButton.toggleWhenPressed(arcadeDrive);
  }

  /**
   * @param controller # (1 or 2)
   * @return the controller
   */
  public static XboxController getController(int controller) {
    switch (controller) {
    case 1:
      return myJoy;

    case 2:
      return myJoy2;

    default:
      return myJoy;
    }
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
