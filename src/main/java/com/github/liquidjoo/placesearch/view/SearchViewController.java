package com.github.liquidjoo.placesearch.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchViewController {

    @GetMapping("/search")
    public String search() {
        return "search/search.html";
    }
}
