import javax.swing.*;
import java.util.ArrayList;

public class CarModel {

    public java.util.ArrayList<Car> getCars() {
        return cars;
    }

    ArrayList<Car> cars = new ArrayList<>();
//har problem att få bilarna att bromsa till 0
 //kan bromsa bilarna genom att "stop all cars".
    void move(){
        checkingCarsStayInWindow();
        for(Car car : cars){
            car.move();
            System.out.println(car.getX());
        }
    }


    void checkingCarsStayInWindow(){//just nu en manuell metod, alltså hur stort fönstret är får vi ange här
        for (Car car : cars) { //nedansteående hade kunnat vara en metod
            if (car.getX() >= 700 && car.getCurrentdirection().contains("east")) {      //FRÅGA hur vet vi hur stor bilden är, så den studsar på väggen
                car.turnLeft();
                car.turnLeft();
            } else if (car.getX() < 0 && car.getCurrentdirection().contains("west")) {
                car.turnLeft();
                car.turnLeft();
            } else if (car.getY() < 0 && car.getCurrentdirection().contains("south")) {
                car.turnLeft();
                car.turnLeft();
            } else if (car.getY() >= 700 && car.getCurrentdirection().contains("north")) {
                car.turnLeft();
                car.turnLeft();
            }
        }
    }




    void gas(int amount){
        double gas = ((double) amount) / 100;
        for(Car car : cars){
            car.gas(gas); //ska ja anropa spinner och se vad den är
        }
    }
    void brake(int amount){
        double brake = ((double) amount) / 100;
        for(Car car: cars){
            car.brake(brake); //samma visa som över
        }
    }

    void setTurboOn(){
        for(Car car : cars){ //Kanske en lista med turboable
            System.out.println("utanför");
            if (car.hasTurbo()) {
                System.out.println("innanför");
                ((Turboable) car).setTurboOn();
            }
        }
    }
    void setTurboOff(){
        for(Car car : cars){
            if (car.hasTurbo()) {
                ((Turboable) car).setTurboOff();
            }
            //  car.setTurboOff();
        }
    }
    void startCars(){
        for(Car car: cars){
            car.startEngine();
        }
    }

    void stopCars(){
        for(Car car: cars){
            car.stopEngine();
        }
    }
    void liftBed(){
        for(Car car : cars){
            if(car.getHasLift()){
                if(car.getCurrentSpeed()==0) {
                    System.out.println("Weee raising my truck bed");
                    ((Liftable) car).setAngleTrBed(70);
                }
                else{
                    System.out.println("The car must stop, If you want to raise the truck bed");
                }

            }
        }
    }
    void setBedDown(){
        for(Car car : cars){
            if(car.getHasLift()){
                ((Liftable) car).setAngleTrBed(0);
                System.out.println("MY truck bed is down");
            }
        }
    }


}







