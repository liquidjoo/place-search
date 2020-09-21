package com.github.liquidjoo.placesearch.local.place.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    List<Keyword> findTop10ByOrderByCountDesc();

}
