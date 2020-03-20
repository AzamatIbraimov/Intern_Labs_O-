/**
 * Copyright (C) 2020 Intern Labs O!
 * <p>
 * Sokoban game made with Java and Swing with MVC pattern
 * Sokoban is a puzzle video game in which the player pushes crates or boxes around in a warehouse,
 * trying to get them to storage locations.
 * In main menu user can restart level and exit game
 * In level menu user can choose level
 * In music menu user can turn on/turn off the game
 * Enjoy the game!
 *
 * @author Erkin Koshoev
 * @author Azamat Ibraimov
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * This is our level parser
 * To parse file to sokoban level you need to provide a text file with .sok extension
 * If something is wrong sends exeption
 * Returns two-dimensional array
 */

public class LevelParser {
    public int[][] parse(String path) {
        File file = new File(path);
        List<String> list = new ArrayList<>();// использую arraylist, потому что мы не знаем конечный размер массива, а arraylist можно увеличивать динамически
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line; // читаем файл по строчкам
            while ((line = reader.readLine()) != null) { // будем продолжать считывать файл, пока не достигнем последней строки
                line = line.replaceAll("[^\\d.]", "");// нам нужны только цифры, поэтому мы удаляем все знаки и буквы
                if (line.length() > 0) {// если цифр в строке не было, то пустую строку добавлять не имеет смысла
                    list.add(line);
                }
            }// на выходе получаем arraylist содержайщий в себе строки , которые содержат только цифры)
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
        int[][] result = list.stream().map(line -> Stream.of(line.split("")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);// конвертируем наш arraylist в двумерный массив
        return result; //на выходе получили двумерный массив ,содержащий только цифры!
    }
}