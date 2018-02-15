package org.usfirst.frc.team4939.robot.commands;

import org.usfirst.frc.team4939.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command {
	
	private double leftPower;
	private double rightPower;
	private double time;

    public DriveCommand(double leftPower, double rightPower, double time) {
        this.time = time;
        this.leftPower = leftPower;
        this.rightPower = rightPower;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    	Robot.dt.resetGyroYaw();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.dt.driveStraightAngle(leftPower, rightPower, time);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.dt.runleftsidedrive(0);
    	Robot.dt.runrightsidedrive(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.dt.runleftsidedrive(0);
    	Robot.dt.runrightsidedrive(0);
    }
}
