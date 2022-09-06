package com.qa.main.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.EqualsVerifier;

public class FilmModelUnitTest {

    private static Film testFilm;

    @Test
    void testConstructor() {
        testFilm = new Film(1L, "Goldeneye", 90L, "15");
        assertThat(testFilm).isNotNull().isInstanceOf(Film.class);
        assertThat(testFilm.getFilmId()).isEqualTo(1L);
        assertThat(testFilm.getTitle()).isEqualTo("Goldeneye");
        assertThat(testFilm.getDuration()).isEqualTo(90L);
        assertThat(testFilm.getRating()).isEqualTo("15");
    }

    @Test
    void testProductionConstructor() {
        testFilm = new Film(2L, "Grease",100L, "12");
        assertThat(testFilm).isNotNull().isInstanceOf(Film.class);
        assertThat(testFilm.getFilmId()).isEqualTo(2L);
        assertThat(testFilm.getTitle()).isEqualTo("Grease");
        assertThat(testFilm.getDuration()).isEqualTo(100L);
        assertThat(testFilm.getRating()).isEqualTo("12");
}


    @Test
    void toStringTest() {
        testFilm = new Film(3L,"Mamma Mia", 120L, "12");
        String expecting = "Film [filmId=" + testFilm.getFilmId() + ", title=" + testFilm.getTitle() + ", duration=" + testFilm.getDuration() + ", rating= " + testFilm.getRating() + "]";
        assertEquals(expecting,testFilm.toString());

    }


}