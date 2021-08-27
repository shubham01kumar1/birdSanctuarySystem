package com.bl.birdsanctuary;

import java.util.EnumSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Main main = new Main();
        main.showUserMenu();
        System.out.println("Goodbye, have a nice day :) ");
    }

    void showUserMenu() {

        Scanner scan = new Scanner(System.in);
        int option = 0;
        final int EXIT_VALUE = 10;

        while(option != EXIT_VALUE) {
            System.out.println("Enter your options:");
            System.out.println(" 1 for Add a bird. \n 2 for remove a bird. \n 3 for print the birds.\n 4 for swimable \n 5 for flayable \n 6 for eatable"
                   + "\n 7 for edit Bird \n" + EXIT_VALUE +" to exit.");

            option = scan.nextInt();

            ViewLayer viewLayer = new ViewLayer();

            switch (option) {
                case 1:
                    Parrot parrot = new Parrot();
                    parrot.id = "p001";
                    Ostrich ostrich = new Ostrich();
                    ostrich.id = "o001";
                    Duck duck = new Duck();
                    duck.id = "d001";
                    Penguin penguin = new Penguin();
                    penguin.id = "pn001";
                    Penguin penguin2 = new Penguin();
                    penguin2.id = "pn002";

                    BirdSanctuaryRepository birdSancRepo = BirdSanctuaryRepository.getInstance();

                    birdSancRepo.add(parrot);
                    birdSancRepo.add(ostrich);
                    birdSancRepo.add(duck);
                    birdSancRepo.add(penguin);

                    break;
                case 2:
                    System.out.println("Enter the bird name to remove :");
                    birdSancRepo = BirdSanctuaryRepository.getInstance();
                    String birdName = scan.next();
                    Bird bird = birdSancRepo.getBird(birdName);
                    birdSancRepo.remove(bird);
                    break;
                case 3:
                    viewLayer.print();
                    break;
                case 4:
                    viewLayer.printSwimmable();
                    break;
                case 5:
                    viewLayer.printFlyable();
                    break;
                case 6:
                    viewLayer.printEatable();
                    break;
                case 7:
                    editBird();
                    break;
            }
        }
    }

    private void editBird() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the bird name to edit \n");
        String birdName = scan.nextLine();

        Bird editBird = BirdSanctuaryRepository.getInstance().getBird(birdName);

        int choice = 0;
        while (choice !=4) {
            System.out.println("1. Edit bird name\n2. Edit id\n3. Edit color\n4. To exit");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the new name for this bird");
                    editBird.name = scan.next();
                    break;
                case 2:
                    System.out.println("Enter the new id for this bird");
                    editBird.id = scan.next();
                    break;
                case 3:
                    System.out.println("Enter the new color for this bird");
                    System.out.println("Choose the color");

                    int count = 1;
                    for (Bird.Color color : EnumSet.allOf(Bird.Color.class)) {
                        System.out.println("" + count + "." + color);
                        count++;
                    }
                    int colorChoice = scan.nextInt();
                    int count1 = 1;
                    for (Bird.Color color : EnumSet.allOf(Bird.Color.class)) {
                        if (colorChoice == count1) {
                            editBird.color = color;
                            break;
                        }
                        count1++;
                    }

                    break;
                case 4:
                    break;

            }
        }
    }
}