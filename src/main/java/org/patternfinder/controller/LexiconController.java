package org.patternfinder.controller;

import org.patternfinder.dto.LexiconDto;
import org.patternfinder.service.LexiconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class LexiconController {

    private LexiconService lexiconService;

    @Autowired
    public LexiconController(LexiconService lexiconService) {
        this.lexiconService = lexiconService;
    }

    @PostMapping("/generate")
    public ResponseEntity<List<LexiconDto>> generateLexicon(@RequestBody(required = false) String inputText) {
        if (StringUtils.hasText(inputText)) {
            throw new RuntimeException();
        }
        List<LexiconDto> lexiconList = lexiconService.generateLexiconList(inputText);
        return new ResponseEntity<>(lexiconList, HttpStatus.OK);
    }

}
