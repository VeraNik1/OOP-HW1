package tasks_2_3;

    public class Main {
        public static int i = 1;

        public static void main(String[] args) {

            Human me = new Human("Вера", Sex.female, 35);
            Cat cat = new Cat("Вася", Sex.male, 5, me);
            Item item1 = new Item("Миска");
            Item item2 = new Item("Еда");
            Item item3 = new Item("Пакет с пакетами");

            // тест шкафа
            Wardrobe myWard = new Wardrobe("шкаф в кухне", 8);
            System.out.println("тест шкафа");
            me.openWardrobe(myWard);//открыли дверь в шкаф
            me.putItemInToWardrobe(myWard, item1, 1);//положить тарелку в шкаф
            me.putItemInToWardrobe(myWard, item2, 4);//положить корм в шкаф
            me.putItemInToWardrobe(myWard, item3, 6);//положить пакет в шкаф
            me.viewInWardrobe(myWard); //посмотрели предметы в шкафу
            me.putItemInToWardrobe(myWard, item2, 4);//положить корм в шкаф
            item1 = me.getItemsInWardrobe(myWard, 4);//вынуть миску из шкафа
            System.out.println(item1.getName());
            item2 = me.getItemsInWardrobe(myWard, 1);//вынуть корм из шкафа
            System.out.println(item2.getName());
            me.closeWardrobe(myWard);//закрыли дверь шкафа
            me.viewInWardrobe(myWard); //пытаемся посмотреть через закрытую дверь
            me.openWardrobe(myWard); //открыли дверь
            me.viewInWardrobe(myWard); //посмотрели предметы в шкафу


            // тест кота( история созависимых отношений)
            System.out.println("тест кота");
            cat.metabolism();
            me.callCat(cat);//позвать кошку
            me.feedTheCat(cat, 10);//покормить кошку
            me.petTheCat(cat);//приласкать кошку
            me.petTheCat(cat);//приласкать кошку
            me.petTheCat(cat);//приласкать кошку
            me.petTheCat(cat);//приласкать кошку
            System.out.println();

        }
    }
