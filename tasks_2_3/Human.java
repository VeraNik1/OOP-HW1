package tasks_2_3;

public class Human {


    enum Mood {
        ok,
        furious,
        happy,
        depressed,
        dead
    }

    String name;
    int age;
    Sex sex;

    static Mood hMood;

    public Mood gethMood() {
        return hMood;
    }

    public void sethMood(Mood hMood) {
        this.hMood = hMood;
    }

    public Human(String name, Sex sex, int age) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.hMood = Mood.ok;
    }

    /**
     * Положить пердмет в шкаф
     *
     * @param obj - используемый шкаф
     */
    public void openWardrobe(Wardrobe obj) {
        if (obj.openDoor()) {
            System.out.println("Открыли " + obj.description);
        } else {
            System.out.println("Не смогли открыть " + obj.description);
        }
    }

    /**
     * Закрыть шкаф
     *
     * @param obj - используемый шкаф
     */
    public void closeWardrobe(Wardrobe obj) {
        if (obj.closeDoor()) {
            System.out.println("Зыкрыли " + obj.description);
        } else {
            System.out.println("Не смогли закрыть " + obj.description);
        }
    }

    /**
     * Положить предмет в шкаф
     *
     * @param obj   - шкаф
     * @param item  - предмет
     * @param index - номер полки
     */
    public void putItemInToWardrobe(Wardrobe obj, Item item, int index) {
        if (obj.setItem(item, index)) {
            System.out.println("Положили предмет " + item.getName() + " на полку " + index + " в " + obj.description);
        } else {
            System.out.println("Не удалось положить предмет " + item.getName() + " на полку " + index + " в " + obj.description);
        }
    }

    /**
     * @param obj   - шкаф
     * @param index - номер места в шкафу
     */
    public Item getItemsInWardrobe(Wardrobe obj, int index) {
        Item tempItem = obj.getItem(index);
        if (tempItem == null) {
            System.out.println("Предметов нет");
        } else {
            System.out.println("Получили предмет " + tempItem.getName());
        }
        return tempItem;
    }

    /**
     * Посмотреть в шкаф
     */
    public void viewInWardrobe(Wardrobe obj) {
        obj.viewItems();
    }

    public void feedTheCat(Cat cat, Integer meal) {//кормим кошку
        if(this.gethMood() == Mood.dead){
            System.out.println("Мертвый кота не покормит)");
            return;}
        System.out.println("Вы кормите кошку");
        cat.eat(meal);//кошка есть

    }

    public void petTheCat(Cat cat) {
        if(this.gethMood() == Mood.dead){
            System.out.println("Мертвый кота не погладит)");
        return;}
        showHumanMood();
        cat.tryToPetCat();//реакция кота на ласку
        showHumanMood();
    }

    public void callCat(Cat cat) {//позвать кота
        System.out.println("Котик говорит");
        cat.reply();//кот должен ответить
    }

    public void showHumanMood() {
        System.out.printf("%s Ваше состояние %s \n", this.name, this.gethMood());
    }
}
