package frc.team3324.lib.commands

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import edu.wpi.first.wpilibj.command.Command
import frc.team3324.lib.subsystems.MotorSubsystem

class MotorCommand(val subsystem: MotorSubsystem, val speed: Double): Command() {

    override fun execute() {
        subsystem.speed = speed
    }

    override fun isFinished(): Boolean {
        return false
    }
}