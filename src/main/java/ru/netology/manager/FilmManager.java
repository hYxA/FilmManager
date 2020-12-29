package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.FilmItem;

import static java.lang.System.*;

public class FilmManager {
    private FilmItem[] items = new FilmItem[0];
    static int count;
    int id;
    FilmItem[] result = new FilmItem[0];
    FilmItem[] nonPrivateResult = items;


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
        }
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
        }
        return result;
    }

    /**
     * возвращает массив всех хранящихся в массиве объектов
     */
    public void findAll() {
        // создание массива для хранения результата
        FilmItem[] result = new FilmItem[items.length];
        int index = items.length - 1;
        for (int i = 0; i < index; i++) {
            result[i] = items[i];
        }
    }

    /**
     * возвращает объект по ID
     */
    public void findById(int id) {
        if (id > items.length) {
            out.println("Не существует объекта с таким ID");
            out.println("------------------");
        } else {
            FilmItem[] result = new FilmItem[1];
            result[0] = items[id];
        }
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
