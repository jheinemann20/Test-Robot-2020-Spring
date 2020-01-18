/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.DriveTrainCommands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSub;

/**
 * An example command. You can replace me with your own command.
 */
public class MecanumDriveCom extends CommandBase {

  private final DriveTrainSub driveSub;
  private XboxController controller;

  public MecanumDriveCom(DriveTrainSub driveSub) {
    this.driveSub = driveSub;
    addRequirements(driveSub);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    controller = RobotContainer.getController(1);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    driveSub.mecanumDrive(controller.getX(Hand.kLeft), controller.getY(Hand.kLeft), controller.getX(Hand.kRight));
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
  }
}
