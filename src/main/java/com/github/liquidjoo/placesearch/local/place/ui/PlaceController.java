package com.github.liquidjoo.placesearch.local.place.ui;

import com.github.liquidjoo.placesearch.local.place.application.PlaceResponse;
import com.github.liquidjoo.placesearch.local.place.application.PlaceService;
import com.github.liquidjoo.placesearch.local.place.application.PopularKeywordsResponse;
import com.github.liquidjoo.placesearch.local.place.domain.Keyword;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(final PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/search")
    public ResponseEntity search(
            @RequestParam(value = "query") String query,
            @RequestParam(value = "size", defaultValue = "15", required = false) int size,
            @RequestParam(value = "page", defaultValue = "1", required = false) int page
    ) {
        try {
            final PlaceResponse response = placeService.search(new Keyword(query, size, page));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/popular/keywords")
    public ResponseEntity getKeywords() {
        try {
            final PopularKeywordsResponse response = placeService.getKeywords();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
