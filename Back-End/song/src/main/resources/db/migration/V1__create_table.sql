CREATE TABLE song (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    duration INT,
    album_id BIGINT,
    url VARCHAR(1023)
);
