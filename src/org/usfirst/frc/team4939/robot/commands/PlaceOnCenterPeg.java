package org.usfirst.frc.team4939.robot.commands;

import org.usfirst.frc.team4939.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PlaceOnCenterPeg extends Command {

	public PlaceOnCenterPeg()
	{
		requires(Robot.dt);
		requires(Robot.gear);
	}
	
	@Override
	protected void initialize() {
		Robot.dt.resetGyro();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.dt.driveStraight(0.25, -0.25, 2.15);
		Robot.dt.driveStraight(0, 0, 2);
		Robot.gear.Resetgear();
		Robot.dt.driveStraight(0, 0, 1);
		Robot.dt.driveStraight(-0.23, 0.25, 2);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.dt.stop();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
    cancel();
	}

}
