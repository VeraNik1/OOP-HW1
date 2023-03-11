package tasks_2_3;

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


            System.out.println("Тест домашнего животного или созависимые отношения");
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
          System.out.println();

            // 2-й сценарий (умирает котик)
            Human he = new Human("Антон", Sex.male, 25);
            Cat kitty = new Cat("Мурка", Sex.female, 2, he);
           System.out.println(kitty);
          he.playWithPet(kitty);
          he.feedThePet(kitty);
          he.feedThePet(kitty);
          he.petThePet(kitty);
          he.playWithPet(kitty);
          he.playWithPet(kitty);
          he.kickThePet(kitty);
          he.kickThePet(kitty);
          he.kickThePet(kitty);
          he.kickThePet(kitty);
          he.kickThePet(kitty);
          System.out.println(kitty);

        }
    }
