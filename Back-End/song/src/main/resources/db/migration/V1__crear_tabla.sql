CREATE TABLE cancion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    duracion INT,
    album_id BIGINT,
    url VARCHAR(1023)
);
