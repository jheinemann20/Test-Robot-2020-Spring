/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.DriveTrainCommands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSub;

public class LimelightAimCom extends CommandBase {

  private DriveTrainSub driveSub;

  private double tv;
  private double tx;

  private double targetHeight = 208.5;
  private double cameraHeight = 27;
  private double targetAngle = 0;

  /**
   * Creates a new LimelightAimCom.
   */
  public LimelightAimCom(DriveTrainSub driveSub) {
    addRequirements(driveSub);
    this.driveSub = driveSub;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    targetAngle = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
    tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
    if (tv == 0)
      return;
    tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    if (tx > 0 ) {
      driveSub.arcadeDrive(0, 0.3 + tx / 20);
    } else if (tx < 0) {
      driveSub.arcadeDrive(0, -0.3 + tx / 20);
    }
    System.out.println("Distance: " + ((targetHeight - cameraHeight) / Math.tan(targetAngle)));
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
