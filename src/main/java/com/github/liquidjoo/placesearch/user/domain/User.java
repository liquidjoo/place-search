package com.github.liquidjoo.placesearch.user.domain;

import com.github.liquidjoo.placesearch.utils.PasswordUtils;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userId;

    @Column
    private String password;

    public User(final String userId, final String password) {
        this(null, userId, PasswordUtils.generatePasswordBySecure(password));
    }

    private User(final Long id, final String userId, final String password) {
        this.id = id;
        this.userId = userId;
        this.password = password;
    }

    User() {

    }

    public boolean match(final String password) {
        return this.password.equalsIgnoreCase(PasswordUtils.generatePasswordBySecure(password));
    }

    public String getUserId() {
        return userId;
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
