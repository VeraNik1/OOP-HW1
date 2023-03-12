public interface SaveAndLoadGeoTree {

    /** Загрузка даных из файла
     * @param fileName - имя файла для загрузки
     * @return - полученный из файла объект GeoTree
     */
    default void load(String fileName) {
        /* Здесь считываем данные из файла с имененем fileName
         * для последующего парсинга и записи данных в GeoTree tree
         * возвращаем tree*/
        System.out.printf("Успешная загрузка данных из файла %s\n", fileName);
    }

    /** Запись данных в файл
     * @param fileName - имя файла для записи
     * @return - результат записи
     */
    default void save(String fileName) {
        /* Здесь считываем данные из файла с имененем fileName
         * для последующего парсинга и записи данных в GeoTree tree
         * возвращаем tree*/
        System.out.printf("Успешная запись данных в файл %s\n", fileName);
    }
}
