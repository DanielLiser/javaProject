import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner s= new Scanner(System.in);

    public static void main(String[] args) {
        Car c=new Car("suzuki","alto","green",2014,"11-11-11",true);
        Car c1=new Car("mazda","miata","blue",2010,"22-22",false);
        Parking parkingLot=new Parking(1,"tel-aviv","alrozorv",1,1);
        boolean isRunning=true;
        int option;
        while (isRunning){
            printMenu();
            option=s.nextInt();
            s.nextLine();
            switch (option){
                case 0:{
                    isRunning=false;
                    break;
                }
                case 1:{
                    parkingLot.park(c,c.isHandi());
                    break;
                }
                case 2:{
                    parkingLot.exit(c.getPlateNUm(),c.isHandi());
                    break;
                }
                case 3:{
                    System.out.println(parkingLot.findByPlateNumber(c.getPlateNUm(),c.isHandi()));
                    break;
                }
                case 4:{
                    System.out.println("Size of parking slot is: "+parkingLot.size());
                }
            }
        }
        //test to git second commit
//        System.out.println(parkingLot.park(c,true));
//        System.out.println(parkingLot.isFull(false));
//        System.out.println(parkingLot.park(c1,false));





    }

    private static void printMenu() {
        System.out.println("0- Close menu");
        System.out.println("1- park");
        System.out.println("2- Exit");
        System.out.println("3- Find a car");
        System.out.println("4- Amount of parking slots");
        System.out.println("5- Amount of handicapped parking slots");
        System.out.println("6- Amount of cars");
        System.out.println("7- Amount of handicapped cars");
        System.out.println("8- Next free parking slot");
        System.out.println("9- Is the parking slot full");
        System.out.println("10 - Is the handicapped parking slot full");





    }
}