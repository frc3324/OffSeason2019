package frc.team3324.robot.util

import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj.buttons.JoystickButton

object OI {
    private val BUTTON_A = 1
    private val BUTTON_B = 2
    private val BUTTON_X = 3
    private val BUTTON_Y = 4
    private val LEFT_BUMPER = 5
    private val RIGHT_BUMPER = 6
    private val BUTTON_BACK = 7
    private val BUTTON_START = 8
    private val JOYSTICK_LEFT_CLICK = 9
    private val JOYSTICK_RIGHT_CLICK = 10

    val primaryController = XboxController(0)
    val secondaryController = XboxController(1)

    private val PRIMARY_A_BUTTON = JoystickButton(primaryController, BUTTON_A)
    private val PRIMARY_X_BUTTON = JoystickButton(primaryController, BUTTON_X)
    private val PRIMARY_Y_BUTTON = JoystickButton(primaryController, BUTTON_Y)
    private val PRIMARY_B_BUTTON = JoystickButton(primaryController, BUTTON_B)
    private val PRIMARY_START_BUTTON = JoystickButton(primaryController, BUTTON_START)
    private val PRIMARY_BACK_BUTTON = JoystickButton(primaryController, BUTTON_BACK)
    private val PRIMARY_RIGHT_BUMPER = JoystickButton(primaryController, RIGHT_BUMPER)
    private val PRIMARY_LEFT_BUMPER = JoystickButton(primaryController, LEFT_BUMPER)

    private val SECONDARY_A_BUTTON = JoystickButton(secondaryController, BUTTON_A)
    private val SECONDARY_B_BUTTON = JoystickButton(secondaryController, BUTTON_B)
    private val SECONDARY_X_BUTTON = JoystickButton(secondaryController, BUTTON_X)
    private val SECONDARY_Y_BUTTON = JoystickButton(secondaryController, BUTTON_Y)
    private val SECONDARY_BACK_BUTTON = JoystickButton(secondaryController, BUTTON_BACK)
    private val SECONDARY_START_BUTTON = JoystickButton(secondaryController, BUTTON_START)
    private val SECONDARY_LEFT_JOYSTICK_BUTTON = JoystickButton(secondaryController, JOYSTICK_LEFT_CLICK)
    private val SECONDARY_RIGHT_JOYSTICK_BUTTON = JoystickButton(secondaryController, JOYSTICK_RIGHT_CLICK)


}