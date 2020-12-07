import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarCont {



    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    private CarVi carviewer;
    private CarModel carmodel;
    int gasAmount = 0;
    int brakeAmount=0;

    public CarCont(CarVi carviewer, CarModel carmodel){
        this.carmodel=carmodel;
        this.carviewer=carviewer;


        this.carviewer.liftBedButton.addActionListener(new BedUpListener());
        this.carviewer.lowerBedButton.addActionListener(new BedDownListener());
        this.carviewer.turboOnButton.addActionListener(new TurboOnListener());
        this.carviewer.turboOffButton.addActionListener(new TurboOffListener());
        this.carviewer.stopButton.addActionListener(new StopListener());
        this.carviewer.startButton.addActionListener(new StartListener());
        this.carviewer.gasSpinner.addChangeListener(new GasListener());
        this.carviewer.brakeSpinner.addChangeListener(new BrakeListener());
        this.carviewer.gasButton.addActionListener(new GasButtonListener());
        this.carviewer.brakeButton.addActionListener(new BrakeButtonListener());

    }

    public void startTimer(){
        timer.start();
    }

    class StartListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.startCars();
        }
    }
    class StopListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.stopCars();
        }
    }

    class BrakeListener implements ChangeListener{ //de här två för spinners

        @Override
        public void stateChanged(ChangeEvent e) {
            brakeAmount= (int) ((JSpinner)e.getSource()).getValue();
        }

    }

    class GasListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            gasAmount = (int) ((JSpinner)e.getSource()).getValue();
        }
    }

    class GasButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.gas(gasAmount);
        }
    }

    class BrakeButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.brake(brakeAmount);
        }
    }
    class BedDownListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.setBedDown();
        }

    }
    class BedUpListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.liftBed();
        }
    }

    class TurboOnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.setTurboOn();
        }
    }

    class TurboOffListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.setTurboOff();
        }
    }

    public class TimerListener implements ActionListener { //Göra if satserna till en metod och anropa, för att göra det snyggare
        public void actionPerformed(ActionEvent e) {
            //carviewer.drawPanel.paint(carmodel.getCars());

            carviewer.drawPanel.repaint();
            carmodel.move();

     //HÄR SLUTADE VI
        }
    }















}
