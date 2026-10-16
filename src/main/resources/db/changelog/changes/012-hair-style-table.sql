--liquibase formatted sql
--changeset ba:11

CREATE TABLE hair_styles(
    id UUID PRIMARY KEY,
    name VARCHAR(200) NOT NULL UNIQUE,
    price INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
)