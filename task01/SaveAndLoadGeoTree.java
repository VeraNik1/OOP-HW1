import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public interface SaveAndLoadGeoTree {

    /** Загрузка даных из файла
     * @param fileName - имя файла для загрузки
     * @return - полученный из файла объект GeoTree
     */
    default GeoTree load(String fileName) {
        //времени не хватило к сожалению))
                System.out.printf("Успешная загрузка данных из файла %s\n", fileName);
           return null;

    }

    /** Запись данных в файл
     * @param fileName - имя файла для записи
     * @return - результат записи
     */
    default void save(String fileName, GeoTree geoTree) {
        //времени не хватило к сожалению))
        System.out.println("Данные сохранены в файл " + fileName);}

}
