package org.usfirst.frc.team4939.robot.commands;

import org.usfirst.frc.team4939.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class lowVleft extends Command {

	public lowVleft()
	{
		requires(Robot.dt);
		requires(Robot.gear);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.dt.driveStraight(0.25, -0.25, 2.35);
		Robot.dt.pause(1);
		Robot.dt.rotateright(1, 1, 0.5);
		Robot.dt.pause(1);
		Robot.dt.driveStraight(0.2, -0.2, 1.9);
//		Robot.gear.Resetgear();
//		Robot.dt.pause(0.5);
//		Robot.dt.driveStraight(-0.23, 0.25, 1.5);
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
