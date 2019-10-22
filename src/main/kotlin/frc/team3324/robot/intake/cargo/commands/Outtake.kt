package frc.team3324.robot.intake.cargo.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team3324.lib.subsystems.MotorSubsystem

class Outtake(val subsystem: MotorSubsystem): Command() {
    init {
        requires(subsystem)
    }

    override fun execute() {
        subsystem.speed = -1.0
    }

    override fun isFinished(): Boolean {
        return false
    }
}