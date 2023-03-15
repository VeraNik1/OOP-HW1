package tasks_2_3;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
        public static int i = 1;

        public static void main(String[] args) {

            Human me = new Human("Вера", Sex.female, 35);
            Dog dog = new Dog("Стивен", Sex.male, 5, me);
            Item item1 = new Item("Миска");
            Item item2 = new Item("Еда");
            Item item3 = new Item("Пакет с пакетами");

            // тест шкафа
//            Wardrobe myWard = new Wardrobe("шкаф в кухне", 8);
//            System.out.println("тест шкафа");
//            me.openWardrobe(myWard);//открыли дверь в шкаф
//            me.putItemInToWardrobe(myWard, item1, 1);//положить тарелку в шкаф
//            me.putItemInToWardrobe(myWard, item2, 4);//положить корм в шкаф
//            me.putItemInToWardrobe(myWard, item3, 6);//положить пакет в шкаф
//            me.viewInWardrobe(myWard); //посмотрели предметы в шкафу
//            me.putItemInToWardrobe(myWard, item2, 4);//положить корм в шкаф
//            item1 = me.getItemsInWardrobe(myWard, 4);//вынуть миску из шкафа
//            System.out.println(item1.getName());
//            item2 = me.getItemsInWardrobe(myWard, 1);//вынуть корм из шкафа
//            System.out.println(item2.getName());
//            me.closeWardrobe(myWard);//закрыли дверь шкафа
//            me.viewInWardrobe(myWard); //пытаемся посмотреть через закрытую дверь
//            me.openWardrobe(myWard); //открыли дверь
//            me.viewInWardrobe(myWard); //посмотрели предметы в шкафу


            // тест домашнего животного (Или история созависимых отношений)


/*            System.out.println("Тест домашнего животного или созависимые отношения");
            // 1-й сценарий умирает хозяин
              System.out.println();
              me.playWithPet(dog);
              me.playWithPet(dog);
              me.feedThePet(dog);
              me.playWithPet(dog);
              me.petThePet(dog);
              me.petThePet(dog);
              me.petThePet(dog);
              me.playWithPet(dog);
          System.out.println();*/

            // 2-й сценарий (умирает котик)
            Human he = new Human("Антон", Sex.male, 25);
            Cat kitty = new Cat("Мурка", Sex.female, 2, he);
//           System.out.println();
//          he.playWithPet(kitty);
//          he.feedThePet(kitty);
//          he.feedThePet(kitty);
//          he.petThePet(kitty);
//          he.playWithPet(kitty);
//          he.playWithPet(kitty);
//          he.kickThePet(kitty);
//          he.kickThePet(kitty);
//          he.kickThePet(kitty);
//          he.kickThePet(kitty);
//          he.kickThePet(kitty);
//          System.out.println();


            // 3-й сценарий (рыбка не может убивать, только умирает)
           Human she = new Human("Анна", Sex.female, 33);
           Fish fish = new Fish("Золотая рыбка", Sex.female, 2, she);
/*            she.playWithPet(fish);
            she.feedThePet(fish);
            she.petThePet(fish);
            she.playWithPet(fish);
            she.playWithPet(fish);
            she.kickThePet(fish);
            she.petThePet(fish);
            she.playWithPet(fish);
            she.playWithPet(fish);
            she.playWithPet(fish);
            she.playWithPet(fish);*/

        //Компараторы  и сортировка
        System.out.println("Компараторы  и сортировка");
        Human petsLover = new Human("Антонина", Sex.female, 63);
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Cat("Мурка",Sex.female,1, petsLover));
        pets.add(new Cat("Леопарда",Sex.female,5, petsLover));
        pets.add(new Fish("Раиса",Sex.female,1, petsLover));
        pets.add(new Dog("Шарик",Sex.male,7, petsLover));
        pets.add(new Cat("Васька",Sex.male,5, petsLover));
        pets.add(new Rat("ВВП",Sex.male,6,petsLover));
        System.out.println("Список домашних животных: "+ pets);
        pets.sort(new NameByComparator());
        System.out.println("Сортировка по имени: "+ pets);
        Collections.sort(pets);
        System.out.println("Сортировка по возрасту: "+ pets);

        // производим разные действия
        petsLover.playWithPet(pets.get(0));
        petsLover.playWithPet(pets.get(1));
        petsLover.playWithPet(pets.get(1));
        petsLover.playWithPet(pets.get(1));
        petsLover.playWithPet(pets.get(2));
        petsLover.playWithPet(pets.get(3));
        petsLover.playWithPet(pets.get(3));
        petsLover.playWithPet(pets.get(3));
        petsLover.playWithPet(pets.get(5));

        //сортируем по стемени голода от наибольшего к наименьшему
        System.out.println("Сортировка по уровню голода");
            for (Pet p:
                 pets) {
                System.out.println(p.toString() +" уровень голода - " + p.getHunger());
            }
        }
    }
