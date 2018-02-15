package org.usfirst.frc.team4939.robot.commands;

import org.usfirst.frc.team4939.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class turntime1 extends Command {

	public turntime1()
	{
		requires(Robot.dt);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		Robot.dt.rotateright(-1, -1, 0.45);
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
