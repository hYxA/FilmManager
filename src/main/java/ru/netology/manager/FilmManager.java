package ru.netology.manager;

import ru.netology.domain.FilmItem;

import static java.lang.System.*;

public class FilmManager {
    private FilmItem[] items = new FilmItem[0];


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

    public FilmItem[] getAll() {
        // определение количества фильмов
        int count = Math.min(items.length, 10);

        // создание массива для хранения результата
        FilmItem[] result = new FilmItem[count];

        // выдаём массив в обратном порядке
        for (int i = 0; i < count; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
            System.out.println(result[i]);
        }
        return result;
    }
}
