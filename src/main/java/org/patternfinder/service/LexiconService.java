package org.patternfinder.service;

import org.patternfinder.dto.LexiconDto;

import java.util.List;

public interface LexiconService {

    List<LexiconDto> generateLexiconList(String inputText);

}
