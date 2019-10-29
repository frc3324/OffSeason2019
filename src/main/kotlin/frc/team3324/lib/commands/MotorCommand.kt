package frc.team3324.lib.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team3324.lib.subsystems.MotorSubsystem

class MotorCommand(private val subsystem: MotorSubsystem, private val speed: Double): Command() {

    override fun execute() {
        subsystem.speed = speed
    }

    override fun isFinished(): Boolean {
        return false
    }
}