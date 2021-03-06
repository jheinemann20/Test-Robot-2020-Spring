/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.LifterCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LifterSub;

public class LiftEncoderResetCom extends CommandBase {

  private LifterSub lifterSub;

  /**
   * Creates a new LiftEncoderResetCom.
   */
  public LiftEncoderResetCom(LifterSub lifterSub) {
    addRequirements(lifterSub);
    this.lifterSub = lifterSub;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    lifterSub.resetLimit();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
