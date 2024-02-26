CREATE TABLE degrees
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE lectors
(
    id         BIGSERIAL PRIMARY KEY,
    surname    VARCHAR(255) NOT NULL,
    name       VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255) NOT NULL,
    experience INT          NOT NULL,
    degree_id  INT          NOT NULL,
    FOREIGN KEY (degree_id) REFERENCES degrees (id)
);