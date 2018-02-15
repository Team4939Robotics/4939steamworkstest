package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	public CANTalon CIMTop = new CANTalon(RobotMap.CIMTop);
	public CANTalon CIMBottom = new CANTalon(RobotMap.CIMBottom);
	public String climb_state = "off";
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public void climb()
	{
		this.CIMBottom.set(-0.3);
		this.CIMTop.set(-0.3);
		this.climb_state = "attempting to catch rope";
	}
	public void stop ()
	{
		this.CIMBottom.set(0);
		this.CIMTop.set(0);
		this.climb_state = "off";
	}
	public void fast_climb()
	{
		this.CIMBottom.set(-0.65);
		this.CIMTop.set(-0.65);
		this.climb_state = "fast climb engaged";
	}

}
