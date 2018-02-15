package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSubsystem extends Subsystem{

	public DoubleSolenoid scoring_piston = new DoubleSolenoid(RobotMap.release, RobotMap.reset);
	public boolean dooropen = false;
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	public void Releasegear ()
	{
		this.scoring_piston.set(DoubleSolenoid.Value.kForward);
		this.dooropen = false;
	}
	
	public void Resetgear()
	{
		this.scoring_piston.set(DoubleSolenoid.Value.kReverse);
		this.dooropen = true;
	}
	
}
