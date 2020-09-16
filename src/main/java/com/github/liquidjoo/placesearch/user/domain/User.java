package com.github.liquidjoo.placesearch.user.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String password;

    public User(final String userId, final String password) {
        this(null, userId, password);
    }

    private User(final Long id, final String userId, final String password) {
        this.id = id;
        this.userId = userId;
        this.password = password;
    }

    User() {

    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        final User user = (User) object;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
