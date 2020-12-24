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
    void shouldAddFilmWithCountFilm() {
        int countFilm = 12;
        FilmItem santa = new FilmItem(1, 115, "santa");
        FilmItem will = new FilmItem(2, 125, "will");
        FilmItem coming = new FilmItem(3, 135, "coming");
        FilmItem soon = new FilmItem(4, 145, "soon");
        FilmItem santa1 = new FilmItem(5, 115, "santa");
        FilmItem will1 = new FilmItem(6, 125, "will");
        FilmItem coming1 = new FilmItem(7, 135, "coming");
        FilmItem soon1 = new FilmItem(8, 145, "soon");
        FilmItem santa2 = new FilmItem(9, 115, "santa");
        FilmItem will2 = new FilmItem(10, 125, "will");
        FilmItem coming2 = new FilmItem(11, 135, "coming");
        FilmItem soon2 = new FilmItem(12, 145, "soon");
        manager.addFilm(santa);
        manager.addFilm(will);
        manager.addFilm(coming);
        manager.addFilm(soon);
        manager.addFilm(santa1);
        manager.addFilm(will1);
        manager.addFilm(coming1);
        manager.addFilm(soon1);
        manager.addFilm(santa2);
        manager.addFilm(will2);
        manager.addFilm(coming2);
        manager.addFilm(soon2);

        FilmItem[] actual = manager.getAll(countFilm);
        FilmItem[] expected = new FilmItem[]{soon2, coming2, will2, santa2, soon1, coming1, will1, santa1, soon, coming, will, santa};

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