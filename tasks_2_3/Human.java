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
     * @param pet
     * @param meal
     */
    public void feedThePet(Pet pet, Integer meal) {//кормим кошку
        System.out.printf("%s кормит питомца\n", this.name);
        checkHumanStat();
        pet.behaviorOfPet();
        if(pet.getStage() == Cat.Stage.hungry || pet.getStage() == Cat.Stage.angry) {
            System.out.printf("%s накидывается на еду\n", pet.getName());
            pet.eat();}
        else if (pet.getStage() == Cat.Stage.sleepy) {
            System.out.printf("%s медленно кушает\n", pet.getName());
            pet.eat();
        } else {
            System.out.printf("%s отказывается от еды\n", pet.getName());
            }
        pet.viewParamPet();

    }
    public void feedThePet(Pet pet) {//кормим кошку
        feedThePet(pet, 10);

    }
    /** гладим котика
     * @param pet
     */
    public void petThePet(Pet pet) {
        System.out.printf("%s гладит питомца\n", this.name);
        checkHumanStat();
        pet.behaviorOfPet();
        if(pet.getStage() == Cat.Stage.sleepy) {
            System.out.printf("%s питомец расслабленно дремлет рядом с хозяином\n", pet.getName());
            pet.speak();
            pet.cameForSnuggling();}
        else if (pet.getStage() == Cat.Stage.hungry){
            System.out.printf("%s слишком голоден, чтобы гладиться\n", pet.getName());
            pet.speak();
            pet.biteHuman();
            this.kickThePet(pet);
            return;
        }
        else if (pet.getStage() == Cat.Stage.angry){
            System.out.printf("%s озверел\n", pet.getName());
            pet.speak();
            pet.killHuman();}
        else{
            System.out.printf("%s игнорирует нежности\n", pet.getName());
            this.sethMood(Mood.depressed);}
        pet.viewParamPet();
        showHumanMood();
    }
    /** играем с котом
     * @param pet
     */
    public void playWithPet(Pet pet) {
        System.out.println("Вы пытаетесь поиграть с питомцем");
        pet.viewParamPet();
        checkHumanStat();
        pet.behaviorOfPet();
        if(pet.getStage() == Cat.Stage.playful) {
            pet.speak();
            System.out.printf("%s с удовольствием играет с %s\n", pet.getName(), this.name);
            pet.playing();}
        else if (pet.getStage() == Cat.Stage.hungry){
            System.out.printf("%s слишком голоден, чтобы играть\n", pet.getName());
            pet.biteHuman();
            this.kickThePet(pet);
            return;
            }
        else if (pet.getStage() == Cat.Stage.angry){
            System.out.printf("%s озверел\n", pet.getName());
            pet.speak();
            pet.killHuman();}
        else{
            System.out.printf("%s не хочет с вами играть\n", pet.getName());
            this.sethMood(Mood.depressed);}
        showHumanMood();
    }

    /** зовем питомца
     * @param pet
     */
    public void callPet(Pet pet) {//позвать кота
        System.out.printf("Зовете питомца: %s, иди ко мне\n", pet.getName());
        checkHumanStat();
        pet.behaviorOfPet();
        pet.speak();//пет должен ответить
        showHumanMood();
        pet.viewParamPet();
    }
    /** пинаем пета
     * @param pet
     * */
    public void kickThePet(Pet pet) {
        System.out.println("Вы пинаете питомца");
        checkHumanStat();
        pet.beaten();
        System.out.println("вжуууух");
        pet.behaviorOfPet();
        if(pet.getMood() == 0) System.out.println("Питомец будет мстить!");
        pet.viewParamPet();
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

