package ru.geekbrains;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public Plate(){
    }

    public boolean decreaseFood(int appetite) {
        if (food - appetite < 0) {
            System.out.println("Cat (with appetite " +appetite+") will remain hungry. The "+food+" food is not enough, please add more food.");
            food=0;
            return false;
        } else {
            System.out.println("Cat ate " + appetite + " food.");
            food-=appetite;
            return true;
        }
    }

    public void increaseFood(int additionalFood) {
        System.out.println("You add "+additionalFood+" additional food on the plate.");
        System.out.println();
        food += additionalFood;
    }

    public int checkFoodOnThePlate(){
        return food;
    }

    public void info() {
        System.out.println("For now its "+food+" food on the plate.");
        System.out.println();
    }
}
