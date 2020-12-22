package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {
    FilmManager manager = new FilmManager();
    int id;


    @Test
    void shouldAddFilm() {
        FilmItem santa = new FilmItem(1, 115, "santa");
        FilmItem will = new FilmItem(2, 125, "will");
        FilmItem coming = new FilmItem(3, 135, "coming");
        FilmItem soon = new FilmItem(4, 145, "soon");
        manager.addFilm(santa);
        manager.addFilm(will);
        manager.addFilm(coming);
        manager.addFilm(soon);

        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{soon, coming, will, santa};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindAll() {
        manager.createTemplate();
        manager.findAll();
    }

    @Test
    void shouldFindByID() {
        manager.createTemplate();
        id = 123;
        manager.findById(id);
    }

    @Test
    void removeByID(int id) {
        manager.createTemplate();
        id = 1;
        removeByID(id);

    }

    @Test
    void doNotRemoveByID(int id) {
        manager.createTemplate();
        id = 666;
        removeByID(id);

    }

}