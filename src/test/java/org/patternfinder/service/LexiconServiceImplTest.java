package org.patternfinder.service;

import org.junit.jupiter.api.Test;
import org.patternfinder.dto.LexiconDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LexiconServiceImplTest {

    LexiconService lexiconService = new LexiconServiceImpl();

    @Test
    void testGenerateLexiconListCorrect() {
        String inputText = "Na straganie w dzień targowy\n" +
                "Takie słyszy się rozmowy:\n" +
                "Może pan się o mnie oprze,\n" +
                "Pan tak więdnie, panie koprze.\n" +
                "Cóż się dziwić, mój szczypiorku,\n" +
                "Leżę tutaj już od wtorku!”\n" +
                "Rzecze na to kalarepka:\n" +
                "Spójrz na rzepę - ta jest krzepka!\n" +
                "Groch po brzuszku rzepę klepie:\n" +
                "Jak tam, rzepo? Coraz lepiej?\n" +
                "Dzięki, dzięki, panie grochu,\n" +
                "Jakoś żyje się po trochu.\n" +
                "Lecz pietruszka - z tą jest gorzej:\n" +
                "Blada, chuda, spać nie może”.\n" +
                "A to feler -\n" +
                "Westchnął seler.\n" +
                "Burak stroni od cebuli,\n" +
                "A cebula doń się czuli:\n" +
                "Mój buraku, mój czerwony,\n" +
                "Czybyś nie chciał takiej żony?\n" +
                "Burak tylko nos zatyka:\n" +
                "„Niech no pani prędzej zmyka,\n" +
                "Ja chcę żonę mieć buraczą,\n" +
                "Bo przy pani wszyscy płaczą”.\n" +
                "A to feler -\n" +
                "Westchnął seler.\n" +
                "Naraz słychać głos fasoli:\n" +
                "Gdzie się pani tu gramoli?!\n" +
                "Nie bądź dla mnie taka wielka -\n" +
                "Odpowiada jej brukselka.\n" +
                "Widzieliście, jaka krewka! -\n" +
                "Zaperzyła się marchewka.\n" +
                "Niech rozsądzi nas kapusta!\n" +
                "Co, kapusta?! Głowa pusta?!\n" +
                "A kapusta rzecze smutnie:\n" +
                "Moi drodzy, po co kłótnie,\n" +
                "Po co wasze swary głupie,\n" +
                "Wnet i tak zginiemy w zupie!\n" +
                "A to feler -\n" +
                "Westchnął seler.";

        List<LexiconDto> lexiconList = lexiconService.generateLexiconList(inputText);

        assertNotNull(lexiconList);
        assertEquals(130L, lexiconList.size());

        LexiconDto lexiconDto = lexiconList.get(0);

        assertEquals("się", lexiconDto.word());
        assertEquals(7L, lexiconDto.occurrences());
        assertEquals(1L, lexiconDto.rank());
    }

    @Test
    void testGenerateLexiconListEmpty() {
        String inputText = "";

        List<LexiconDto> lexiconList = lexiconService.generateLexiconList(inputText);

        assertNotNull(lexiconList);
        assertEquals(0L, lexiconList.size());
    }
}