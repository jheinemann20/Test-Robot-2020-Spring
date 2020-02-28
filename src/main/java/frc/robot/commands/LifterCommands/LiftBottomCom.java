/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.LifterCommands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LifterSub;

public class LiftBottomCom extends CommandBase {

  LifterSub liftersub;
  PIDController liftPid;

  /**
   * Creates a new LiftBottomCom.
   */
  public LiftBottomCom(LifterSub lifterSub) {
    this.liftersub = lifterSub;
    addRequirements(lifterSub);

    liftPid = new PIDController(0.001, 0, 0);
    liftPid.setIntegratorRange(-0.5, 0.5);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    liftersub.lift(liftPid.calculate(liftersub.getEncoder(1), 0));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return liftPid.atSetpoint();
  }
}
