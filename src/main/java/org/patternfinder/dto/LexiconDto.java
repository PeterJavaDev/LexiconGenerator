package org.patternfinder.dto;

import java.math.BigDecimal;

public record LexiconDto(String word, Long occurrences, Long rank) {
}
