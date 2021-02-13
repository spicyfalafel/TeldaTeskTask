DROP TABLE IF EXISTS regions;

CREATE TABLE regions (id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    abbreviation VARCHAR(250) DEFAULT NULL
);

INSERT INTO regions(name, abbreviation) VALUES
('Moscow', 'MSK'),

('Komi Republic', 'RK'),
('Saint-Petersburg', 'Spb');
