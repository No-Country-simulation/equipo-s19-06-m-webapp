CREATE TABLE song (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    duration INT,
    album_id BIGINT,
    url_preview VARCHAR(1023)
);
