package com.bl.birdsanctuary;

public class ViewLayer {

    public void print() {
        BirdSanctuaryRepository birdSanctuaryRepository = BirdSanctuaryRepository.getInstance();
        for(Object items: birdSanctuaryRepository.getAllBirds()) {
            System.out.println(items);
        }
    }

    public void printFlyable() {
        BirdSanctuaryRepository birdSanctuaryRepository = BirdSanctuaryRepository.getInstance();
        for(Bird item: birdSanctuaryRepository.getAllBirds()) {
            if ( item instanceof Flyable ) {
    //            ((com.bl.birdsanctuary.Flyable) item).fly();
                Flyable flyable = (Flyable) item;
                flyable.fly();
            }
        }
    }

    public void printSwimmable() {
        BirdSanctuaryRepository birdSanctuaryRepository = BirdSanctuaryRepository.getInstance();
        for(Bird item: birdSanctuaryRepository.getAllBirds()) {
            if (item instanceof Swimmable ) {
                ((Swimmable) item).swim();
            }
        }
    }

    public void printEatable() {
        BirdSanctuaryRepository birdSanctuaryRepository = BirdSanctuaryRepository.getInstance();
        for(Bird item: birdSanctuaryRepository.getAllBirds()) {
            item.eat();
        }
    }
}
