--liquibase formatted sql
--changeset balambert:015-barber-hairstyle

CREATE TABLE barber_hairstyle (
    barber_id UUID NOT NULL REFERENCES barbers (id) ON DELETE CASCADE,
    hairstyle_id UUID NOT NULL REFERENCES hair_style (id) ON DELETE CASCADE,
    PRIMARY KEY (barber_id, hairstyle_id)
);

CREATE INDEX idx_barber_hairstyle_hairstyle_id ON barber_hairstyle (hairstyle_id);
