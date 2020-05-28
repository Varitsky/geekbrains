package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 10, 20);
        Plate plate = new Plate(15);

        System.out.println("History of hungry cat in 9 acts:" + "\n");

        cat.eat(plate);
        cat.eat(plate);
        cat.eat(plate);
        plate.increaseFood(10);
        plate.info();
        cat.eat(plate);
        plate.info();
        cat.eat(plate);
        plate.info();

        System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        plate.increaseFood(55);  // можно сыпать мало, можно очень много, будут разные варианты.
        plate.info();

        int herd = 5; // The number of Cats.

        Cat[] catArray = new Cat[herd];

        catArray[0] = new Cat("Ruby", 5, 30);
        catArray[1] = new Cat("Ryan", 10, 25);
        catArray[2] = new Cat("Grace", 15, 20);
        catArray[3] = new Cat("Pushistik", 5, 15);

        feedTheCats(catArray, plate, herd);
    }

    public static void feedTheCats(Cat[] catArray, Plate plate, int herd) {
        int tempPlate=plate.checkFoodOnThePlate();
        while (plate.checkFoodOnThePlate() > 0) {
            if (catsAreFedUp(catArray,plate,herd,tempPlate)){
                break;
            } else System.out.println("Next circle of omnomonomonomomnomomomomomomomomomomomomomomomomomomo" + "\n");

            for (int i = 0; i < herd - 1; i++) {
                catArray[i].eat(plate);
            }
            if (plate.checkFoodOnThePlate() == 0) {
                System.out.println("Cats ate everything! Please add more food!");
                System.out.println("ALl the cats are NOT FedUp."+"\n"+"It was "+tempPlate+" food on the Plate. ");
                plate.info();
                System.out.println("P.S. The Cats ate "+(tempPlate-plate.checkFoodOnThePlate())+" (ALL) food in summary.");

            }
        }
    }

    public static boolean catsAreFedUp(Cat[] catArray, Plate plate, int herd, int tempPlate) {

        int theCatIsFeedUpCountOrPleaseStopFeedTheCat = 0;
        for (int i = 0; i < herd - 1; i++) {
            if (catArray[i].fedUp()) {
                theCatIsFeedUpCountOrPleaseStopFeedTheCat++;
                if (theCatIsFeedUpCountOrPleaseStopFeedTheCat == herd - 1) {
                    System.out.println("ALl the cats are FedUp."+"\n"+"It was "+tempPlate+" food on the Plate. ");
                    plate.info();
                    System.out.println("P.S. The Cats ate "+(tempPlate-plate.checkFoodOnThePlate())+" food in summary.");
                    return true;
                }
            }
        }
        return false;
    }
}
