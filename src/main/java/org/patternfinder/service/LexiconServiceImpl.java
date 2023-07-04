package org.patternfinder.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.patternfinder.dto.LexiconDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LexiconServiceImpl implements LexiconService {

    private static final Logger log = LogManager.getLogger(LexiconServiceImpl.class);

    public List<LexiconDto> generateLexiconList(String inputText) {
        log.debug("Generating lexicon");

        String[] words = inputText.toLowerCase().split("[\\p{Punct}\\s]+");

        Map<String, Long> wordCounts = Stream.of(words)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        Map<String, Long> sortedWordCounts = wordCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (firstDuplicate, secondDuplicate) -> firstDuplicate,
                        LinkedHashMap::new));

        List<LexiconDto> lexiconList = new ArrayList<>();

        if (sortedWordCounts.containsKey("")) {
            return lexiconList;
        }

        long rank = 1;

        for (Map.Entry<String, Long> entry : sortedWordCounts.entrySet()) {
            lexiconList.add(new LexiconDto(entry.getKey(), entry.getValue(), rank++));
        }

        return lexiconList;
    }
}
