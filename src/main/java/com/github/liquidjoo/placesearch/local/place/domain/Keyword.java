package com.github.liquidjoo.placesearch.local.place.domain;

import lombok.Getter;
import lombok.ToString;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString
@Entity
@Table(name = "keyword")
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String query;

    @Column
    private int count;

    @Transient
    private int size;
    @Transient
    private int page;

    public Keyword(final String query, final int size, final int page) {
        validate(query);
        this.query = query;
        this.size = size;
        this.page = page;
        this.count = 1;
    }

    public Keyword(final String query) {
        this(query, 15, 1);
    }

    public Keyword(final String query, int count) {
        this(query, 15, 1);
        this.count = count;
    }

    Keyword() {

    }

    private void validate(String query) {
        if (Strings.isBlank(query)) {
            throw new IllegalArgumentException("검색어를 입력해주세요");
        }
    }

    void increaseCount() {
        this.count++;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        final Keyword keyword = (Keyword) object;
        return Objects.equals(query, keyword.query);
    }

    @Override
    public int hashCode() {
        return Objects.hash(query);
    }
}
