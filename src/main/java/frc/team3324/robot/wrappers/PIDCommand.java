package frc.team3324.robot.wrappers;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;

public class PIDCommand extends Command {

    protected double kP;
    protected double kI;
    protected double kD;
    protected double goal;
    protected double dt;

    protected DoubleSupplier measurement;
    protected DoubleConsumer useOutput;

    protected double lastPosition = 0;
    protected double integral = 0;

    protected Notifier notifier = new Notifier(this ::executePID);

    public PIDCommand(double kP, double kI, double kD, double goal, double dt, Subsystem subsystem, DoubleSupplier measurement,
                      DoubleConsumer useOutput) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;

        this.goal = goal;
        this.dt = dt;

        this.requires(subsystem);
        this.measurement = measurement;
        this.useOutput = useOutput;
    }

    @Override
    protected void initialize() {
        integral = 0;
        notifier.startPeriodic(dt);
    }

    protected void executePID() {
        double position = measurement.getAsDouble();
        double error = goal - position;
        double deriv = position - lastPosition;
        integral += error;
        lastPosition = position;

        double output = (error * kP) + (integral * kI) - (deriv * kD);
        useOutput.accept(output);
    }

    @Override
    protected void end() {
        stopNotifier();
    }

    @Override
    protected void interrupted() {
        end();
    }

    public void stopNotifier() {
        notifier.stop();
        notifier.stop();
    }

    @Override
    protected boolean isFinished() {
        return measurement.getAsDouble() == goal;
    }
}
