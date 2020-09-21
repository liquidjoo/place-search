DROP TABLE IF EXISTS USER;

CREATE TABLE USER
(
    id       bigint auto_increment not null,
    user_id  varchar(12)           NOT NULL,
    password varchar(255)          NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS KEYWORD;

CREATE TABLE KEYWORD
(
    id    bigint auto_increment not null,
    query varchar(30) unique    not null,
    count bigint,

    primary key (id)
)
