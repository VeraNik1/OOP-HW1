package tasks_2_3;

public class Wardrobe {
        String description; //описание шкафа
        private Item[] storage; //хранилище вещей
        private boolean isOpenDoor;//состояние двери

        /**
         * @param Capacity - вместимость шкафа(максимальное число предметов)
         * @param name           - имя шкафа или примечание
         */
        public Wardrobe(String name, int Capacity) {

            this.storage = new Item[Capacity];
            this.isOpenDoor = false;
            this.description = name;
            System.out.println("У нас новый \""+name+"\""+" на "+Capacity+" мест");
        }

        /**
         * открываем двери
         *
         * @return
         */
        public boolean openDoor() {
            if (isOpenDoor) return false;
            isOpenDoor = true;
            return true;
        }

        /**
         * закрываем двери
         *
         * @return
         */
        public boolean closeDoor() {
            if (!isOpenDoor) return false;
            isOpenDoor = false;
            return true;
        }

        /**
         * получить предмет из шкафа
         *
         * @param index - место предмета c 1 до
         * @return - предмет или null(если предмет не получен)
         */
        public Item getItem(int index) {
            index -= 1;
            if (!isOpenDoor) {
                System.out.println("Сначала нужно открыть дверь!");
                return null;}
            if (index >= storage.length) return null;
            Item obj = storage[index];
            storage[index] = null;
            return obj;
        }

        /**
         * Поместить предмет в шкаф. Если полка уже занята то предмет не поместится
         *
         * @param obj - предмет
         * @return - результат true/false
         */
        public boolean setItem(Item obj, int index) {
            if (!isOpenDoor) {
                System.out.println("Сначала нужно открыть дверь!");
                return false;}
            index -= 1;
            if (0 > index || this.storage.length <= index) return false;
            if (storage[index] != null) {
                System.out.println("полка занята");
                return false;
            } else {
                storage[index] = obj;
                return true;
            }
        }

        public void viewItems() {
            if (isOpenDoor) {
                System.out.println("в шкафу " + this.storage.length + " мест");
                StringBuilder forPrint = new StringBuilder();
                int count = 0;
                for (int i = 0; i < this.storage.length; i++) {
                    if (this.storage[i] != null) {
                        count++;
                        forPrint.append (String.format("%5d  %s\n", i + 1,this.storage[i].getName()));
                    }else {
                        forPrint.append(String.format("%5d  %s\n", i + 1," --- "));
                    }
                }
                System.out.println("занято " + count + " мест(а|о)");
                System.out.println(forPrint);
            } else {
                System.out.println("шкаф закрыт");
            }
        }
}
