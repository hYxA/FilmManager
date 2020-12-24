package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.FilmItem;

import static java.lang.System.*;

public class FilmManager {
    private FilmItem[] items = new FilmItem[0];
    static int count;
    int id;
    int countFilm;

    /**
     * Добавление фильма
     */
    public void addFilm(FilmItem item) {
        // создание массива на единицу больше размером
        int length = items.length + 1;
        FilmItem[] tmp = new FilmItem[length];

        // копируем поэлементно
        arraycopy(items, 0, tmp, 0, items.length);

        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    /**
     * Выдаёт последние 10 добавленных фильмов
     */
    public FilmItem[] getAll() {
        // определение количества фильмов
        count = Math.min(items.length, 10);

        // создание массива для хранения результата
        FilmItem[] result = new FilmItem[count];

        // выдаём массив в обратном порядке
        for (int i = 0; i < count; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
            System.out.println(result[i]);
        }
        out.println("------------------");
        return result;
    }

    /**
     * Выдаёт последние *countFilm* добавленных фильмов
     */
    public FilmItem[] getAll(int countFilm) {
        // определение количества фильмов
        count = Math.min(items.length, countFilm);

        // создание массива для хранения результата
        FilmItem[] result = new FilmItem[count];

        // выдаём массив в обратном порядке
        for (int i = 0; i < count; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
            System.out.println(result[i]);
        }
        out.println("------------------");
        return result;
    }

    /**
     * возвращает массив всех хранящихся в массиве объектов
     */
    public void findAll() {
        for (FilmItem item : items) {
            out.println(item);
        }
        out.println("------------------");
    }

    /**
     * возвращает объект по ID
     */
    public void findById(int id) {
        if (id > items.length) {
            out.println("Не существует объекта с таким ID");
        } else {
            out.println(items[id]);
        }
        out.println("------------------");
    }

    /**
     * удаляет объект по ID
     */
    public void removeByID(int id) {
        if (id > items.length) {

            out.println("Не существует объекта с таким ID");
            out.println("------------------");

        } else {

            int index = 0;
            int length = items.length - 1;
            FilmItem[] resultByRemove = new FilmItem[length];

            for (FilmItem item : items) {

                if (item.getId() != id) {
                    resultByRemove[index] = item;
                    index++;
                }
            }
        }
    }

    /**
     * создание тестового шаблона
     */
    @BeforeEach
    public void createTemplate() {
        FilmItem santa = new FilmItem(1, 115, "santa");
        FilmItem will = new FilmItem(2, 125, "will");
        FilmItem coming = new FilmItem(3, 135, "coming");
        FilmItem soon = new FilmItem(4, 145, "soon");
        addFilm(santa);
        addFilm(will);
        addFilm(coming);
        addFilm(soon);
    }

    /**
     * удаление всех элементов
     */
    public void removeAll() {
        FilmItem[] nullArray = new FilmItem[0];
        items = nullArray;
    }

}
