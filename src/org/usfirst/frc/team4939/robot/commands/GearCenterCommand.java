package org.usfirst.frc.team4939.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearCenterCommand extends CommandGroup {

    public GearCenterCommand() {
        addSequential(new DriveCommand(0.25, -0.25, 2.9));
        addSequential(new WaitCommand(1.0));
        addSequential(new resetgear());
        addSequential(new WaitCommand(0.5));
        addSequential(new DriveCommand(-0.23, 0.25, 2));
    }
}
