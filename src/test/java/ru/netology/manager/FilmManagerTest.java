package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {
    FilmManager manager = new FilmManager();

    @Test
    void shouldAddFilm() {
        FilmItem santa = new FilmItem(1,15, "santa");
        FilmItem will = new FilmItem(2,15, "will");
        FilmItem coming = new FilmItem(3,15, "coming");
        FilmItem soon = new FilmItem(4,15, "soon");
        manager.addFilm(santa);
        manager.addFilm(will);
        manager.addFilm(coming);
        manager.addFilm(soon);


    }

    @Test
    void shouldGetAll() {
    }


}