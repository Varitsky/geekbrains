package ru.geekbrains;

public class Cat {

    private String name;
    private int appetite;
    private int capacityOfCat;
    public int hunger;

    public String getName() {
        return name;
    }

    public Cat(String name, int appetite, int capacityOfCat) {
        this.name = name;
        this.appetite = appetite;
        this.capacityOfCat=capacityOfCat;
    }

    public Cat(){
    }

    public void eat(Plate plate) {

        /** 1. Нет еды на тарелке
         *  2. Кот наелся
         *  3. Кот почти наелся, ему столько не нужно
         *  4. На тарелке недостаточно еды, чтобы кот съел свою стандартную порцию
         *  5. Кот ест.
         */

        if (plate.checkFoodOnThePlate() == 0) {
            System.out.println("There is no food on the plate. Please add more food."+"\n");
            filledOn();
        } else if (hunger == capacityOfCat) {
            System.out.println(getName() + " is Fed Up. He cant eat."+"\n");
            filledOn();
        } else if (hunger != capacityOfCat & hunger + appetite > capacityOfCat) {
            int tempAppetite = appetite;
            System.out.print(String.format("%s is too much for %s. ", appetite, getName()));
            appetite = capacityOfCat - hunger;
            System.out.println("Cat is almost full and will eat only " + appetite + " food");
            plate.decreaseFood(appetite);
            hunger=hunger+appetite;
            appetite = tempAppetite;
            System.out.println("But this is only for this time. Next time he want " + appetite + " food.");
            filledOn();
        } else if (plate.checkFoodOnThePlate() > 0 & plate.checkFoodOnThePlate() < appetite) {
            int tempAppetite = appetite;
            System.out.println("There is only " + plate.checkFoodOnThePlate() + " food for " + getName() + " left on the plate. But less is better then nothing.");
            appetite = plate.checkFoodOnThePlate();
            plate.decreaseFood(appetite);
            hunger=hunger+appetite;
            appetite = tempAppetite;
            System.out.println("But this is only for this time. Next time he want " + appetite + " food.");
            System.out.println("The plate is empty now. Need more food, please add some.");
            filledOn();
        } else if (hunger!=capacityOfCat){
            plate.decreaseFood(appetite);
            hunger = hunger + appetite;
            filledOn();
        }
    }


    public void filledOn(){ // насколько наелся кот в десятичнодробном отображении и в процентах
        System.out.print(getName() + " filled on " + hunger + "/" + capacityOfCat + " (" + ((float) hunger / (float) capacityOfCat * 100) + "%). ");
        System.out.println("Fed Up: " + fedUp());
        System.out.println();
    }

    public boolean fedUp(){ // наелся ли кот вообще
        return hunger == capacityOfCat;
    }
}
