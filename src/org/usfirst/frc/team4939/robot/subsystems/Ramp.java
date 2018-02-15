package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Ramp extends Subsystem{
	public DoubleSolenoid ramp_piston = new DoubleSolenoid(RobotMap.ramp, RobotMap.ramp_in_frame);
	public boolean rampengaged = false;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	public void EngageRamp()
	{
		this.ramp_piston.set(DoubleSolenoid.Value.kReverse);
		this.rampengaged = true;
	}
	public void ResetRamp()
	{
		this.ramp_piston.set(DoubleSolenoid.Value.kForward);
		this.rampengaged = false;
	}

}
