CREATE TABLE album (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fechaLanzamiento DATE,
    genero VARCHAR(255),
    urlImg VARCHAR(255)
);