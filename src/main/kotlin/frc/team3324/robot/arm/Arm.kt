package frc.team3324.robot.arm

import com.ctre.phoenix.motorcontrol.NeutralMode
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX
import edu.wpi.first.wpilibj.CounterBase
import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.Encoder
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team3324.robot.util.Consts


object Arm: Subsystem() {
    private val encoder = Encoder(Consts.Arm.ENCODER_PORT_A, Consts.Arm.ENCODER_PORT_B, true, CounterBase.EncodingType.k4X)
    private val frontSwitch = DigitalInput(Consts.Arm.FRONT_LIMIT_SWITCH)
    private val backSwitch = DigitalInput(Consts.Arm.BACK_LIMIT_SWITCH)

    private val armMotorOne = WPI_TalonSRX(Consts.Arm.MOTOR_PORT_ARM_ONE)
    private val armMotorTwo = WPI_VictorSPX(Consts.Arm.MOTOR_PORT_ARM_TWO)
    private val armMotorThree  = WPI_VictorSPX(Consts.Arm.MOTOR_PORT_ARM_THREE)

    init {
        initializeCurrentLimiting()
        setBrakeMode()
    }

    private fun initializeCurrentLimiting() {
        armMotorOne.configContinuousCurrentLimit(16)
        armMotorOne.enableCurrentLimit(true)

        armMotorTwo.follow(armMotorOne)
        armMotorThree.follow(armMotorOne)
    }

    fun setBrakeMode() {
        armMotorOne.setNeutralMode(NeutralMode.Brake)
        armMotorTwo.setNeutralMode(NeutralMode.Brake)
        armMotorThree.setNeutralMode(NeutralMode.Brake)
    }


    fun setArmSpeed(speed: Double) {
        var speed = speed
        if (frontSwitch.get()) { resetEncoder() }
        if (armIsAtHardstop(speed)) {
            speed = 0.0
        }
        val feedforward = 0.06 * Math.cos(getArmRadians())
        speed += feedforward
        armMotorOne.set(speed)
    }

    fun setArmRawSpeed(speed: Double) {
        armMotorOne.set(speed)
    }

    private fun armIsAtHardstop(speed: Double): Boolean {
        return (encoder.get() <= 0 && speed < 0) || (encoder.get() >= (Consts.Arm.ENCODER_TICKS_PER_REV) / 2 && speed > 0) ||
                ((frontSwitch.get() && speed < 0) || (backSwitch.get() && speed > 0))
    }

    fun getArmRadians(): Double {
        return encoder.get() * ((Math.PI * 2) / Consts.Arm.ENCODER_TICKS_PER_REV)
    }

    fun resetEncoder() {
        encoder.reset()
    }

    override fun initDefaultCommand() {

    }
}