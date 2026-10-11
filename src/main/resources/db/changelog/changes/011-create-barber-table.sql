--liquibase formatted sql
--changeset ba:11
CREATE TABLE BARBERS(
    id UUID PRIMARY KEY,
    names VARCHAR(200) NOT NULL,
    phone BIGINT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    address_district VARCHAR(100) NOT NULL,
    address_sector VARCHAR(100) NOT NULL,
    address_cell VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    CONSTRAINT chk_barbers_gender CHECK (gender IN ('MALE','FEMALE'))
);