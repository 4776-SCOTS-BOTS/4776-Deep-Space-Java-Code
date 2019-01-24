/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Encoder;
/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  //private DifferentialDrive m_myRobot;                               //COUNTS HAS TO EQUAL 1500 AND -1500
   
  //private static final int kMotorChannelLeft = 1;
  //private static final int kMotorChannelRight = 3;
  
  private PIDController m_pidControllerLeft;
  private PIDController m_pidControllerRight;
  private static final double Kp = 0.1;
  private static final double Ki = 0;
  private static final double Kd = 0;

  public static Encoder LEFT_ENCODER = new Encoder(9, 8, true, Encoder.EncodingType.k4X);
  private static Encoder RIGHT_ENCODER = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
  private Joystick m_Stick = new Joystick(0);

 public static PWMVictorSPX m_MotorLeft = new PWMVictorSPX(11);
 public static PWMVictorSPX m_MotorRight = new PWMVictorSPX(13);
  public AnalogInput m_EncoderLeft;
  public AnalogInput m_EncoderRight;
  private boolean m_previousButtonValue;
  private Joystick m_joystick;
  @Override
  public void robotInit() {
    //m_myRobot = new DifferentialDrive(new PWMVictorSPX(11), new PWMVictorSPX(13));
    m_joystick = new Joystick(0);
    //m_EncoderLeft = new AnalogInput(1);
    //m_EncoderRight = new AnalogInput(3);
   
   
 //commented to get teleop running
    m_pidControllerLeft = new PIDController(Kp, Ki, Kd, LEFT_ENCODER, m_MotorLeft);
    m_pidControllerRight = new PIDController(Kp, Ki, Kd, RIGHT_ENCODER, m_MotorRight);
    m_pidControllerLeft.setInputRange(-52, 52);
    m_pidControllerRight.setInputRange(-52, 52);
    m_pidControllerLeft.setOutputRange(-0.5, 0.5);
    m_pidControllerRight.setOutputRange(-0.5, 0.5);
  }
  @Override
  
   
  //@Override
  public void teleopInit() {
    LEFT_ENCODER.reset();
    RIGHT_ENCODER.reset();
    m_pidControllerLeft.enable();
    m_pidControllerRight.enable();                         //COUNTS HAS TO BE EQUAL TO 1500 AND -1500
  }
  
                                                    
  
  
  
  @Override
  public void teleopPeriodic() {
    //m_myRobot.tankDrive(-m_Stick.getRawAxis(1), -m_Stick.getRawAxis(5));
   m_pidControllerLeft.setSetpoint(-12);
   m_pidControllerRight.setSetpoint(12);
   
  
    System.out.println( LEFT_ENCODER.getRaw() + " " +  RIGHT_ENCODER.getRaw());
    //System.out.println(m_MotorLeft.getRaw() + " " + m_MotorRight.getRaw());
  }
}
