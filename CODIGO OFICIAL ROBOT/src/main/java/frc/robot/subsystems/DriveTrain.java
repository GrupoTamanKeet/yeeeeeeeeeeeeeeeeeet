package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.hardware.Constantes;
import frc.robot.hardware.Control;

public class DriveTrain { 
    //mandar a Sofi
    //DriveMotors
    WPI_TalonSRX MotorDerecha1;
    WPI_TalonSRX MotorDerecha2;
    WPI_TalonSRX MotorIzquierda1;
    WPI_TalonSRX MotorIzquierda2;

    private static SpeedControllerGroup MotoresDriveDerecha;
    private static SpeedControllerGroup MotoresDriveIzquierda;
    public static DifferentialDrive MovimientoBaseCompleto;

    private static double movimientoAdelanteX;
    private static double movimientoAdelanteY; // private double movimientoAdelanteZ;

    //encoders de ambas líneas de motores
  private Encoder EncoderMotoresDerecha;
  private Encoder EncoderMotoresIzquierda;

    public DriveTrain(Control Control) {
      MotorDerecha1 = new WPI_TalonSRX(Constantes.PosicionMotorDriveDerecha1);
      MotorDerecha2 = new WPI_TalonSRX(Constantes.PosicionMotorDriveDerecha2);
      MotorIzquierda1 = new WPI_TalonSRX(Constantes.PosicionMotorDriveIzquierda1);
      MotorIzquierda2 = new WPI_TalonSRX(Constantes.PosicionMotorDriveIzquierda2);

      MotoresDriveIzquierda = new SpeedControllerGroup(MotorIzquierda1, MotorIzquierda2);
      MotoresDriveDerecha = new SpeedControllerGroup(MotorDerecha1, MotorDerecha2);

      MovimientoBaseCompleto = new DifferentialDrive(MotoresDriveIzquierda, MotoresDriveDerecha);

      //pid
      EncoderMotoresDerecha = new Encoder(0,1);
      EncoderMotoresIzquierda = new Encoder(2,3);

      EncoderMotoresDerecha.setDistancePerPulse(4./10000.);
      EncoderMotoresIzquierda.setDistancePerPulse(4./10000.);
    }

    public static void moverseConXbox() { // funcion principal del movimiento del chasis

        // inputs del control para movimiento
        movimientoAdelanteY = Control.readXboxAxis(Constantes.XB_RT)
                - Control.readXboxAxis(Constantes.XB_LT); // toma el valor para ir hacia adelante o hacia atras

        movimientoAdelanteX = Control.readXboxAxis(Constantes.XB_LJ_X) * movimientoAdelanteY
                * Constantes.controlSensivilidadDrive // toma una funcion para saber cuanto giro deberia de tener el robot y que sirva mejor
                + Control.readXboxAxis(Constantes.XB_RJ_X); // Toma input raw y lo suma a lo que va a girar para que sea solo una funcion 
                // nota que esta separada en 2 lineas, pero en verdad es solamente 1
    
        if (Control.readXboxButtons(Constantes.controlDrift)){ // controla el drift del drive, para que pueda dar vueltas mas cerradas
          movimientoAdelanteX = movimientoAdelanteX * Constantes.controlSensivilidadDrift;
        }
    
        if (movimientoAdelanteX > Constantes.controlMaximaVelocidadDeGiro || movimientoAdelanteX < -Constantes.controlMaximaVelocidadDeGiro) { // si va muy rapido, se desconfigura el gyroscopio, asi que no queremos eso 
          if (movimientoAdelanteX < 0) movimientoAdelanteX = -Constantes.controlMaximaVelocidadDeGiro;
          else movimientoAdelanteX = Constantes.controlMaximaVelocidadDeGiro;
        }

        MovimientoBaseCompleto.arcadeDrive(movimientoAdelanteY,movimientoAdelanteX);
    }

    public void tankdriveConXbox(){
        MovimientoBaseCompleto.tankDrive(-Control.readXboxAxis(1), -Control.readXboxAxis(5));
    }

    public void moverseConPiloto(){ // funcion principal del movimiento del chasis 

        // inputs del control para movimiento
        movimientoAdelanteY = Control.readJoystickAxis(Constantes.LG_YJ); // toma el valor para ir hacia adelante o hacia atras 
    
        movimientoAdelanteX = Control.readJoystickAxis(Constantes.LG_XJ)*movimientoAdelanteY*Constantes.controlSensivilidadDrive // toma una funcion para saber cuanto giro deberia de tener el robot y que sirva mejor
                + Control.readJoystickAxis(Constantes.LG_ZJ); // Toma input raw y lo suma a lo que va a girar para que sea solo una funcion 
                // nota que esta separada en 2 lineas, pero en verdad es solamente 1
    
        if (Control.readJoystickButtons(Constantes.controlDrift)){ // controla el drift del drive, para que pueda dar vueltas mas cerradas
          movimientoAdelanteX = movimientoAdelanteX * Constantes.controlSensivilidadDrift;
        }
    
        if (movimientoAdelanteX > Constantes.controlMaximaVelocidadDeGiro || movimientoAdelanteX < -Constantes.controlMaximaVelocidadDeGiro) { // si va muy rapido, se desconfigura el gyroscopio, asi que no queremos eso 
          if (movimientoAdelanteX < 0) movimientoAdelanteX = -Constantes.controlMaximaVelocidadDeGiro;
          else movimientoAdelanteX = Constantes.controlMaximaVelocidadDeGiro;
        }

        MovimientoBaseCompleto.arcadeDrive(movimientoAdelanteY,movimientoAdelanteX);
    }

    public void moverseAPos(float pos){

    }

}