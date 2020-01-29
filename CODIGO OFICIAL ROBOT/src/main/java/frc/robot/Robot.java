/*----------------------------------------------------------------------------*/
/* Tamán Keet 3933 PrepaTec CSF                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.I2C;
import frc.robot.hardware.Constantes;
import frc.robot.hardware.Control;
import frc.robot.hardware.Gyro;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.Encoder;

public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";

  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  Control controles;
  DriveTrain dTrain;
  Intake intake;
  Elevator elevador;

  //sensor de color
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 SensorColor = new ColorSensorV3(i2cPort);


  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }


   /*
    //  ______           __                                                                 
    // /\  _  \         /\ \__                                                              
    // \ \ \L\ \  __  __\ \ ,_\   ___     ___     ___     ___ ___     ___   __  __    ____  
    //  \ \  __ \/\ \/\ \\ \ \/  / __`\ /' _ `\  / __`\ /' __` __`\  / __`\/\ \/\ \  /',__\ 
    //   \ \ \/\ \ \ \_\ \\ \ \_/\ \L\ \/\ \/\ \/\ \L\ \/\ \/\ \/\ \/\ \L\ \ \ \_\ \/\__, `\
    //    \ \_\ \_\ \____/ \ \__\ \____/\ \_\ \_\ \____/\ \_\ \_\ \_\ \____/\ \____/\/\____/
    //     \/_/\/_/\/___/   \/__/\/___/  \/_/\/_/\/___/  \/_/\/_/\/_/\/___/  \/___/  \/___/                                                                                    
   */
  @Override
  public void autonomousInit() {

    m_autoSelected = m_chooser.getSelected();
    
    // cosas de if selected has esto con nombres de cosas, si esta dentro de un loop

    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);

  }

  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        //si esta diseñado con loop externo aqui
        break;
      case kDefaultAuto:
      default:
        
        break; // Técnicamente es inneceseario
    }
  }

  /**
  //  ______   ______     __         ______     ______     ______  
  // /\__  _\ /\  ___\   /\ \       /\  ___\   /\  __ \   /\  == \ 
  // \/_/\ \/ \ \  __\   \ \ \____  \ \  __\   \ \ \/\ \  \ \  _-/ 
  //    \ \_\  \ \_____\  \ \_____\  \ \_____\  \ \_____\  \ \_\   
  //     \/_/   \/_____/   \/_____/   \/_____/   \/_____/   \/_/   
   */
  @Override
  public void teleopPeriodic() {
    // Aqui el codigo donde vamos a poner toda la estructura del robot

    DriveTrain.moverseConXbox(); // mueve el robot, control durante teleop

    if (Control.readXboxButtons(Constantes.XB_B_A)) intake.activarIntake();
    else intake.desactivarIntake();

    if (Control.readXboxButtons(Constantes.XB_B_B)) intake.activarAcercar();
    else intake.desactivarAcercar();

    if (Control.readXboxButtons(Constantes.XB_B_X)) elevador.activarEntregar();
    else elevador.desactivarEntregar();

    if (Control.readXboxButtons(Constantes.XB_B_Y)) elevador.activarSubir();
    else elevador.desactivarSubir();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}