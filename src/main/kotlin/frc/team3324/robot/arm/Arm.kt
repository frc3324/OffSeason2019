package frc.team3324.robot.arm

import com.ctre.phoenix.motorcontrol.NeutralMode
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX
import edu.wpi.first.wpilibj.CounterBase
import edu.wpi.first.wpilibj.Encoder
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team3324.robot.util.Consts


object Arm: Subsystem() {
    private val encoder = Encoder(Consts.Arm.ENCODER_PORT_A, Consts.Arm.ENCODER_PORT_B, true, CounterBase.EncodingType.k4X)

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

    override fun initDefaultCommand() {

    }
}