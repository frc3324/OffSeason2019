package frc.team3324.lib.subsystems

import com.ctre.phoenix.motorcontrol.NeutralMode
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team3324.lib.commands.MotorCommand

class MotorSubsystem(private val motor: WPI_TalonSRX, currentLimit: Int, private val defaultSpeed: Double = 0.0): Subsystem() {
    init {
        motor.setNeutralMode(NeutralMode.Brake)
        motor.configContinuousCurrentLimit(currentLimit)
        motor.enableCurrentLimit(true)
    }

    var speed: Double
        get() = motor.get()
        set(input) = motor.set(input)

    override fun initDefaultCommand() {
        if (defaultSpeed != 0.0) {
            defaultCommand = MotorCommand(this, defaultSpeed)
        }
    }
}