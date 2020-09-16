DROP TABLE IF EXISTS USER;

CREATE TABLE USER
(
    id       bigint      auto_increment not null,
    user_id   varchar(12) NOT NULL,
    password varchar(12) NOT NULL,
    PRIMARY KEY (id)
);
