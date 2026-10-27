--liquibase formatted sql
--changeset ba:14

ALTER TABLE hair_style ADD COLUMN duration INTEGER NOT NULL;
