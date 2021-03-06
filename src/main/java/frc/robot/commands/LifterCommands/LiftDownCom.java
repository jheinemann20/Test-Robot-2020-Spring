/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.LifterCommands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LifterSub;

public class LiftDownCom extends CommandBase {
  LifterSub lifterSub;
  XboxController lifController;

  /**
   * Creates a new LiftDownCom.
   */
  public LiftDownCom(LifterSub lifterSub) {
    lifController = RobotContainer.getController(2);
    this.lifterSub = lifterSub;
    addRequirements(lifterSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    lifterSub.lift(lifController.getRawAxis(Constants.LIFT_DOWN_AXIS));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    lifterSub.stopLift();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}