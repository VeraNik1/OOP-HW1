package tasks_2_3;

public class Human {

    enum Status{
        dead,
        alive
    }
    static Status Stat;

    public Status getStat() {
        return Stat;
    }

    public void setStat(Status Stat) {
        this.Stat = Stat;
    }


    enum Mood {
        ok,
        furious,
        happy,
        depressed,
        nervous
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



 /** Действия, которые человек делает со шкафом*/

    /**
     * Открыть шкаф
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

    /** взять предмет из шкафа
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
     * Посмотреть, что лежит в шкафу
     */
    public void viewInWardrobe(Wardrobe obj) {
        obj.viewItems();
    }


// ----------------------------------------------------------------
    /** Действия, которые человек делает с котом**/

    /** кормим котика
     * @param cat
     * @param meal
     */
    public void feedTheCat(Cat cat, Integer meal) {//кормим кошку
        System.out.printf("%s кормит кота\n", this.name);
        checkHumanStat();
        cat.behaviorOfCat();
        if(cat.getStage() == Cat.Stage.hungry || cat.getStage() == Cat.Stage.angry) {
            System.out.printf("%s накидывается на еду\n", cat.getName());
            cat.eat();}
        else if (cat.getStage() == Cat.Stage.sleepy) {
            System.out.printf("%s медленно кушает\n", cat.getName());
            cat.eat();
        } else {
            System.out.printf("%s отказывается от еды\n", cat.getName());
            }
        cat.viewParamCat();

    }
    public void feedTheCat(Cat cat) {//кормим кошку
        feedTheCat(cat, 10);

    }
    /** гладим котика
     * @param cat
     */
    public void petTheCat(Cat cat) {
        System.out.printf("%s гладит кота\n", this.name);
        checkHumanStat();
        cat.behaviorOfCat();
        if(cat.getStage() == Cat.Stage.sleepy) {
            System.out.printf("%s мирно дремлет на коленях хозяина\n", cat.getName());
            cat.speak();
            cat.cameForSnuggling();}
        else if (cat.getStage() == Cat.Stage.hungry){
            System.out.printf("%s слишком голоден, чтобы гладиться\n", cat.getName());
            cat.speak();
            cat.biteHuman();
            this.kickTheCat(cat);
            return;
        }
        else if (cat.getStage() == Cat.Stage.angry){
            System.out.printf("%s озверел\n", cat.getName());
            cat.speak();
            cat.killHuman();}
        else{
            System.out.printf("%s игнорирует нежности\n", cat.getName());
            this.sethMood(Mood.depressed);}
        cat.viewParamCat();
        showHumanMood();
    }
    /** играем с котом
     * @param cat
     */
    public void playWithCat(Cat cat) {
        System.out.println("Вы пытаетесь поиграть с котом");
        cat.viewParamCat();
        checkHumanStat();
        cat.behaviorOfCat();
        if(cat.getStage() == Cat.Stage.playful) {
            cat.speak();
            System.out.printf("%s с удовольствием играет с %s\n", cat.getName(), this.name);
            cat.playing();}
        else if (cat.getStage() == Cat.Stage.hungry){
            System.out.printf("%s слишком голоден, чтобы играть\n", cat.getName());
            cat.biteHuman();
            this.kickTheCat(cat);
            return;
            }
        else if (cat.getStage() == Cat.Stage.angry){
            System.out.printf("%s озверел\n", cat.getName());
            cat.speak();
            cat.killHuman();}
        else{
            System.out.printf("%s не хочет с вами играть\n", cat.getName());
            this.sethMood(Mood.depressed);}
        showHumanMood();
    }

    /** зовем котика
     * @param cat
     */
    public void callCat(Cat cat) {//позвать кота
        System.out.printf("Зовете кота: %s, кис-кис-кис, иди ко мне\n", cat.getName());
        checkHumanStat();
        cat.behaviorOfCat();
        cat.speak();//кот должен ответить
        showHumanMood();
        cat.viewParamCat();
    }
    /** пинаем котика
     * @param cat
     */
    public void kickTheCat(Cat cat) {
        System.out.println("Вы пинаете кота!");
        checkHumanStat();
        cat.beaten();
        System.out.println("маааааааааааааау");
        cat.behaviorOfCat();
        if(cat.getMood() == 0) System.out.println("Зверь будет мстить!");
        cat.viewParamCat();
    }
    // ----------------------------------------------------------------
    /** Проверка настроения и статуса человека**/


    /** показать настроение человека
     */
    public void showHumanMood() {
        checkHumanStat();
        System.out.printf("%s Ваше состояние %s \n", this.name, this.gethMood());
    }

    /** проверить жив или мертв человек
     * Если мертв выполнение программы заканчивается
     */
    public void checkHumanStat(){
        if (this.getStat() == Status.dead) {
            System.out.println("К сожалению вы мертвы, ничего не получится");
            System.exit(0);
        }
    }

    }

