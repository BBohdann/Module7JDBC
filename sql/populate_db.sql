insert into worker (name,birthday,"level",salary) values
('John Doe', '1990-05-15', 'Senior', 8000),
('Bohdan Marcun', '2003-02-03', 'Middle', 1500),
('Maria Marcun', '1999-06-18', 'Trainee', 650),
('David Taylor', '1970-12-18', 'Senior', 7000),
('Olivia Martinez', '1983-04-22', 'Trainee', 950),
('Michael Lee', '1992-11-12', 'Junior', 1500),
('Jane Smith', '1985-09-20', 'Junior', 1200),
('William Anderson', '1987-08-08', 'Junior', 1300),
('Julia Brain', '1999-06-09', 'Middle', 1800),
('Roberto Smith', '1998-02-15', 'Middle', 2100);

INSERT INTO client (id, name) VALUES
(1, 'Emma Thompson'),
(2, 'Liam Harris'),
(3, 'Sophia Miller'),
(4, 'Noah Wilson'),
(5, 'Olivia Taylor');


INSERT INTO project (client_id, start_date, finish_date)
VALUES
(1, '2023-01-15', '2024-03-20'),
(2, '2022-05-10', '2023-07-25'),
(3, '2022-08-25', '2023-11-30'),
(4, '2023-03-08', '2023-09-12'),
(5, '2022-11-01', '2024-01-05');

INSERT INTO project_worker (project_id, worker_id)
VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 6),
(4, 7),
(4, 8),
(5, 9),
(5, 10);