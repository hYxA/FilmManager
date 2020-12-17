package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;
import ru.netology.domain.FilmItem;
import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {
    private FilmItem[] items = new FilmItem[0];


    @Test
    void addFilm(FilmItem[] items) {
        int expectedLength = items.length + 1;
        addFilm(items);
        assertEquals(expectedLength, items.length);
    }

    @Test
    void getAll() {
    }
}