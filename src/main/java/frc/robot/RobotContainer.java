/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.DriveTrainCommands.ArcadeDriveCom;
import frc.robot.commands.DriveTrainCommands.LimelightAimCom;
import frc.robot.commands.DriveTrainCommands.MecanumDriveCom;
import frc.robot.commands.DriveTrainCommands.ToDistanceCom;
import frc.robot.commands.HerderCommands.HerdCom;
import frc.robot.commands.HerderCommands.LowerArmCom;
import frc.robot.commands.HerderCommands.RaiseArmCom;
import frc.robot.commands.HerderCommands.StopArmCom;
import frc.robot.commands.HerderCommands.StopHerdCom;
import frc.robot.commands.LifterCommands.LiftBottomCom;
import frc.robot.commands.LifterCommands.LiftDownCom;
import frc.robot.commands.LifterCommands.LiftEncoderResetCom;
import frc.robot.commands.LifterCommands.LiftStop;
import frc.robot.commands.LifterCommands.LiftTopCom;
import frc.robot.commands.LifterCommands.LiftUpCom;
import frc.robot.commands.ShooterCommands.ShootCom;
import frc.robot.commands.ShooterCommands.ShooterLoadCom;
import frc.robot.subsystems.DriveTrainSub;
import frc.robot.subsystems.HerderArmSub;
import frc.robot.subsystems.HerderSub;
import frc.robot.subsystems.LifterSub;
import frc.robot.subsystems.LoaderSub;
import frc.robot.subsystems.ShooterSub;
import frc.robot.triggers.AxisButton;
import frc.robot.triggers.POVButton;


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
  private final HerderSub herderSub = new HerderSub();
  private final HerderArmSub herderArmSub = new HerderArmSub();
  private final LoaderSub loaderSub = new LoaderSub();

  @JsonIgnore
  private final ArcadeDriveCom arcadeDrive = new ArcadeDriveCom(driveSub);
  @JsonIgnore
  private final MecanumDriveCom mecanumDrive = new MecanumDriveCom(driveSub);

  private final ToDistanceCom distanceCom = new ToDistanceCom(driveSub);
  private final LimelightAimCom aimCom = new LimelightAimCom(driveSub);
  
  private final ShootCom shootCom = new ShootCom(shooterSub);
  private final ShooterLoadCom loadCom = new ShooterLoadCom(loaderSub);

  private final LiftUpCom liftUpCom = new LiftUpCom(lifterSub);
  private final LiftDownCom liftDownCom = new LiftDownCom(lifterSub);
  private final LiftStop liftStopCom = new LiftStop(lifterSub);
  private final LiftEncoderResetCom liftResetCom = new LiftEncoderResetCom(lifterSub);
  private final LiftTopCom liftTopCom = new LiftTopCom(lifterSub);
  private final LiftBottomCom liftBottomCom = new LiftBottomCom(lifterSub);

  private final HerdCom herdCom = new HerdCom(herderSub);
  private final LowerArmCom lowerArmCom = new LowerArmCom(herderArmSub);
  private final RaiseArmCom raiseArmCom = new RaiseArmCom(herderArmSub);
  private final StopArmCom stopArmCom = new StopArmCom(herderArmSub);
  private final StopHerdCom stopHerdCom = new StopHerdCom(herderSub);

  // Joysticks/Controllers
  private static XboxController myJoy = new XboxController(0);
  private static XboxController myJoy2 = new XboxController(1);

  // Buttons
  private JoystickButton shiftButton = new JoystickButton(myJoy, Constants.SHIFT_BUTTON);
  private JoystickButton aimButton = new JoystickButton(myJoy, Constants.VISION_AIM_BUTTON);
  private JoystickButton distanceButton = new JoystickButton(myJoy, Constants.TO_DISTANCE_BUTTON);

  private JoystickButton shootButton = new JoystickButton(myJoy2, Constants.SHOOTER_SHOOT_BUTTON);
  private JoystickButton loadButton = new JoystickButton(myJoy2, Constants.SHOOTER_LOAD_BUTTON);
  private AxisButton liftUpButton  = new AxisButton(myJoy2, Constants.LIFT_UP_AXIS, 0.01);
  private AxisButton liftDownButton = new AxisButton(myJoy2, Constants.LIFT_DOWN_AXIS, 0.01);
  private JoystickButton herdButton = new JoystickButton(myJoy2, Constants.HERD_BUTTON);
  private JoystickButton herdArmUpButton = new JoystickButton(myJoy2, Constants.RAISE_ARM_BUTTON);
  private JoystickButton herdArmDownButton = new JoystickButton(myJoy2, Constants.LOWER_ARM_BUTTON);
  private JoystickButton resetEncoderButton = new JoystickButton(myJoy2, Constants.RESET_LIFTER_ENCODER_BUTTON);
  private POVButton liftTopButton = new POVButton(myJoy2, Constants.LIFT_TOP_POV);
  private POVButton liftBottomButton = new POVButton(myJoy2, Constants.LIFT_BOTTOM_POV);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driveSub.setDefaultCommand(arcadeDrive);
    lifterSub.setDefaultCommand(liftStopCom);
    herderSub.setDefaultCommand(stopHerdCom);
    herderArmSub.setDefaultCommand(stopArmCom);
    herdButton.whileHeld(herdCom);
    herdArmUpButton.whileHeld(raiseArmCom);
    herdArmDownButton.whileHeld(lowerArmCom);
    aimButton.whileHeld(aimCom);
    liftTopButton.whileActiveContinuous(liftTopCom);
    liftBottomButton.whileActiveContinuous(liftBottomCom);
    liftUpButton.whileActiveContinuous(liftUpCom);
    liftDownButton.whileActiveContinuous(liftDownCom);
    resetEncoderButton.whileHeld(liftResetCom);
    shootButton.toggleWhenPressed(shootCom);
    distanceButton.whileHeld(distanceCom);
    loadButton.whileHeld(loadCom);
    shiftButton.toggleWhenPressed(mecanumDrive);
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
