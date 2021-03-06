package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.hardware.ColorSensor;
import frc.robot.hardware.Constantes;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;



public class MoveDisk{

    public static DoubleSolenoid pistonDisco;
    public static WPI_TalonSRX motorDisco;
    private static ColorSensor colorSensor;
    
    private int cambioDeColor;
    private int ForwardChannel = 0;
    private int BackWardChannel = 7;
    private boolean encendido, girable;
    private String ultimoColorLeido;


    public MoveDisk (){
        pistonDisco = new DoubleSolenoid(Constantes.ConexionCompresor,ForwardChannel, BackWardChannel);
        motorDisco = new WPI_TalonSRX(Constantes.ConexionMotorDisco);
        colorSensor = new ColorSensor();
        encendido = false;
        girable = false;
        motorDisco.setNeutralMode(NeutralMode.Brake);
    }

    private void moverDisco(double speed){
        motorDisco.set(ControlMode.PercentOutput, speed);
    }
    private void reverseMoverDisco(double speed){
        motorDisco.set(ControlMode.PercentOutput, -speed);
    }

    private void abrirPiston() {
        pistonDisco.set(Value.kForward);
        girable = true;
    }

    private void cerrarPiston(){
        pistonDisco.set(Value.kReverse);
        girable = false;
    }

    private void pararMotor(){
        motorDisco.stopMotor();
        motorDisco.setVoltage(0);
    }
    
    private void spin (int cambiosDeColor, boolean forward, double speed){
        if ( !(ultimoColorLeido.equalsIgnoreCase(colorSensor.leerColor())) ){
            cambioDeColor ++;
            ultimoColorLeido = colorSensor.leerColor();
        }
        if (cambioDeColor == cambiosDeColor){ //
            pararMotor();
            encendido = false;
        }else{
            if(forward){
                moverDisco(speed);
            }else{
                reverseMoverDisco(speed);
            }
            
        }
    }

    public void pararTodo(){
        cerrarPiston();
        pararMotor();
    }

    public void funcionar(){
        if (Robot.control.readJoystickButtons(Constantes.LG_B6)){
            abrirPiston();
        }
        if (Robot.control.readJoystickButtons(Constantes.LG_B5)){
            cerrarPiston();
        }
        if(girable){
            if (Robot.control.readJoystickButtons(Constantes.LG_B3)){
                cambioDeColor = 0;   
                encendido = true;
                ultimoColorLeido = colorSensor.leerColor();
            }
            if(Robot.control.readJoystickDPad() == 90){
                moverDisco(0.2);
            }else if(Robot.control.readJoystickDPad() == 270){
                reverseMoverDisco(0.2);
            }else{
                pararMotor();
            }

            if (encendido){
                spin(24, true, 0.2);
            }else{
                pararMotor();
            }
        }
        
        colorSensor.leerColor();
    }
}