package frc.team3324.robot.util

import edu.wpi.first.wpilibj.Notifier
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Subsystem
import java.util.function.DoubleConsumer
import java.util.function.DoubleSupplier

class PIDCommand(val kP: Double, val kI: Double, val kD: Double, val goal: Double, val dt: Double, val subsystem: Subsystem, val measurement: () -> Double, val useOutput: (Double) -> Unit): Command() {
    protected var integral = 0.0
    protected var lastPosition = 0.0
    private val notifier = Notifier(this ::executePID)

    init {
        this.requires(subsystem)
    }

    override fun initialize() {
       integral = 0.0
       notifier.startPeriodic(dt)
    }

    fun executePID() {
        val position = measurement()
        val error = goal - position
        val deriv = position - lastPosition

        integral += error
        lastPosition = position

        val output = (error * kP) + (integral * kI) - (deriv * kD)
        useOutput(output)
    }

    override fun end() {
        stopNotifier()
    }

    override fun interrupted() {
        stopNotifier()
        end()
    }

    fun stopNotifier() {
        notifier.stop()
        notifier.stop()
    }

    override fun isFinished(): Boolean {
        return measurement() == goal
    }

}