import javax.swing.*;
import java.awt.*;

public class VechicleApplication {

    public static void main(String[] args) {
        CarVi carvi = new CarVi("frame");
        CarModel carmod = new CarModel();
        CarCont cc = new CarCont(carvi, carmod);

       // Timer timer = new Timer(50, );
        Saab95 saab95 = new Saab95(2,Color.black,300, 1650);
        Volvo240 volvo240 = new Volvo240(2,Color.black,240,1600);
        Scania scanis = new Scania(2,Color.black,300,16000);
        saab95.setCurrentdirection("east");
        volvo240.setCurrentdirection("east");
        scanis.setCurrentdirection("east");
        carmod.cars.add(saab95);
        carmod.cars.add(volvo240);
        carmod.cars.add(scanis);
        saab95.setY(0);
        volvo240.setY(200);
        scanis.setY(400);
        carvi.drawPanel.receiveCars(carmod.getCars());
        //här slutade vi
       // carvi.drawPanel.paintComponent(carvi.getGraphics(), volvo240);
        //carvi.drawPanel.paintComponent(carvi.getGraphics(), scanis);
            // försökte alltså få en paintComponent som tar en Car som inparameter.
        cc.startTimer();

    }
}
