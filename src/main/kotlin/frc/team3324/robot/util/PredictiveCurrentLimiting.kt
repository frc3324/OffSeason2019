package frc.team3324.robot.util

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import kotlin.math.sign


class PredictiveCurrentLimiting(val motor: Motors.Motor, val upperLimit: Double, val lowerLimit: Double) {

    fun limit(voltage: Double, angularAcceleration: Double): Double {
        var voltage = voltage

        val voltageMin = lowerLimit * motor.resistance + angularAcceleration/motor.Kv
        val voltageMax = upperLimit * motor.resistance + angularAcceleration/motor.Kv
        Math.max(voltageMin, voltage)
        Math.min(voltageMax, voltage)
        SmartDashboard.putNumber("Voltage min", voltageMin)
        SmartDashboard.putNumber("Voltage max", voltageMax)
        SmartDashboard.putNumber("Voltage", voltage)
        return voltage
    }
}