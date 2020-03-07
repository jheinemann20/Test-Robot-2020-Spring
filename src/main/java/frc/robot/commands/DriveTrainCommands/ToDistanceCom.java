/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.DriveTrainCommands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSub;

public class ToDistanceCom extends CommandBase {

  private DriveTrainSub driveSub;

  private PIDController drivePID;

  private double distance;
  private double setDistance = 90;

  /**
   * Creates a new ToDistanceCom.
   */
  public ToDistanceCom(DriveTrainSub driveSub) {
    this.driveSub = driveSub;
    addRequirements(driveSub);

    drivePID = new PIDController(0.04, 0, 0.01);
    drivePID.setIntegratorRange(-0.1, 0.1);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    distance = driveSub.getDistance();
    System.out.println(distance);
    double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0) + 5;
    if (tx > 0 ) {
      driveSub.arcadeDrive(-drivePID.calculate(distance, setDistance), 0.4 + tx / 20);
    } else if (tx < 0) {
      driveSub.arcadeDrive(-drivePID.calculate(distance, setDistance), -0.4 + tx / 20);
    }
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
