package frc.robot.hardware;

public class Constantes {
    // conecciones de controles -----------------------------------------------------------------------------------------------------------

    public static final int controlAdelante = 2; // palanquita derecha
    public static final int controlAtras = 3; // palanqquita izquierda

    public static final int controlGirar = 0;
    public static final int controlGirarRaw = 4;

    public static final int controlDrift = 9;

    public static final float controlSensivilidadDrift = 2;
    public static final float controlSensivilidadDrive = .8f;

    public static final float controlMaximaVelocidadDeGiro = .8f;


    // gyro stuff -------------------------------------------------------------------------------------------------------------------------

    public static double anguloTotalRobot;
    public static double anguloRobot; 
    public static int vueltasDelRobot; 
    
//      _____                      _                         _____       _           _   
//     / ____|                    (_)                       |  __ \     | |         | |  
//    | |     ___  _ __   _____  ___  ___  _ __   ___  ___  | |__) |___ | |__   ___ | |_ 
//    | |    / _ \| '_ \ / _ \ \/ / |/ _ \| '_ \ / _ \/ __| |  _  // _ \| '_ \ / _ \| __|
//    | |___| (_) | | | |  __/>  <| | (_) | | | |  __/\__ \ | | \ \ (_) | |_) | (_) | |_ 
//     \_____\___/|_| |_|\___/_/\_\_|\___/|_| |_|\___||___/ |_|  \_\___/|_.__/ \___/ \__|          
    

    public static final int PosicionMotorDriveDerecha1 = 4;
    public static final int PosicionMotorDriveDerecha2 = 1;
    public static final int PosicionMotorDriveIzquierda1 = 3;
    public static final int PosicionMotorDriveIzquierda2 = 2;
    
    public static final int ConexionPosicionIntake = 5;
    public static final int ConexionPosicionAcercar = 6;

    public static final int ConexionPosicionSubir = 7;
    public static final int ConexionPosicionEntregar = 8;

//-----------------------------------------------------
//      _____            _             _            
//     / ____|          | |           | |           
//    | |     ___  _ __ | |_ _ __ ___ | | ___  ___  
//    | |    / _ \| '_ \| __| '__/ _ \| |/ _ \/ __| 
//    | |___| (_) | | | | |_| | | (_) | |  __/\__ \ 
//     \_____\___/|_| |_|\__|_|  \___/|_|\___||___/ 

public static final int puertoXbox = 0;
public static final int puertoJoystick = 1;
public static final int puertoBottonera = 2;



//-----------------------------------------------------
//    __   __           ____            
//    \ \ / /          |  _ \           
//     \ V /   ______  | |_) | _____  __
//      > <   |______| |  _ < / _ \ \/ /
//     / . \           | |_) | (_) >  < 
//    /_/ \_\          |____/ \___/_/\_\
                                  
// XB stands for X-Box
// B standsFor Button
// L/R Left and Right
// J joystick
// T Trigger

public static final int XB_B_A = 1;
public static final int XB_B_B = 2;
public static final int XB_B_X = 3;
public static final int XB_B_Y = 4;
// botón de torreta

public static final int XB_B_LB = 5;
public static final int XB_B_RB = 6;

public static final int XB_B_Back = 7;
public static final int XB_B_Start = 8;

public static final int XB_B_JL = 9;
public static final int XB_B_JR = 10;

public static final int XB_LJ_X = 0;
public static final int XB_LJ_Y = 1;
public static final int XB_RJ_X = 4;
public static final int XB_RJ_Y = 5;

public static final int XB_LT = 2;
public static final int XB_RT = 3;

//-----------------------------------------------------
//        _                 _   _      _    
//       | |               | | (_)    | |   
//       | | ___  _   _ ___| |_ _  ___| | __
//   _   | |/ _ \| | | / __| __| |/ __| |/ /
//  | |__| | (_) | |_| \__ \ |_| | (__|   < 
//   \____/ \___/ \__, |___/\__|_|\___|_|\_\
//                 __/ |                    
//                |___/  

// LG stands for Logitech
// X,Y,Z Joystick

public static final int LG_XJ = 0;
public static final int LG_YJ = 1;
public static final int LG_ZJ = 2;
public static final int LG_Slider = 3;



}