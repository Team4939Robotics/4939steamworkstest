package org.usfirst.frc.team4939.robot.commands;

import org.usfirst.frc.team4939.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {
	
	private double leftPower;
	private double rightPower;
	private double setpoint;
	private double angle = Robot.dt.getGyroYaw();

    public Turn(double leftPower, double rightPower, double setpoint) {
    	this.setpoint = setpoint;
        this.leftPower = leftPower;
        this.rightPower = rightPower;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.dt.driveStraight(leftPower, rightPower, setpoint);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	 if (angle >= setpoint){
    		 return true;
    	 }
    	 else {
    		 return false;
    	 }
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
