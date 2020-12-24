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
        id = 1;
        manager.findById(id);
    }

    @Test
    void shouldNOTFindByID() {
        manager.createTemplate();
        id = 123;
        manager.findById(id);
    }

    @Test
    void removeByID() {
        manager.createTemplate();
        int id = 1;
        manager.removeByID(id);

    }

    @Test
    void doNotRemoveByID() {
        manager.createTemplate();
        int id = 666;
        manager.removeByID(id);

    }

    @Test
    void shouldRemoveAll() {
        manager.removeAll();
        int exceptedLength = 0;

        FilmItem[] actual = manager.getAll();

        assertEquals(exceptedLength, actual.length);
    }

}