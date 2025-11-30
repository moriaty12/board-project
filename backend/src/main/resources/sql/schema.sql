-- schema.sql
CREATE TABLE board (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(200),
                       content TEXT,
                       writer VARCHAR(100),
                       created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);
