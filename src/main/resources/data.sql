-- students
INSERT INTO Student (first_names, last_names, dni, date_birth) VALUES
('Carlos', 'Hernández', '12345678', '1999-04-10'),
('María', 'Gómez', '87654321', '2001-02-15'),
('Luis', 'Fernández', '11223344', '1998-07-25'),
('Ana', 'López', '44556677', '2000-11-30'),
('Sofía', 'Pérez', '99887766', '1997-05-20');

-- courses
INSERT INTO Course (name, acronym, state) VALUES
('Introducción a la Programación', 'INTPROG', true),
('Base de Datos Avanzada', 'BDADV', true),
('Cálculo Diferencial', 'CALDIFF', false),
('Inteligencia Artificial', 'IA', true),
('Diseño de Interfaces', 'UIUX', true);

-- enrollments
INSERT INTO Enrollment (enrollment_date, id_student, state) VALUES
('2024-01-05 08:30:00', 1, true),
('2024-01-06 10:00:00', 2, true),
('2024-01-06 11:00:00', 3, true),
('2024-01-07 09:30:00', 4, true),
('2024-01-08 14:00:00', 5, true);

-- enrollment details
INSERT INTO EnrollmentDetail (id_enrollment, id_course, classroom) VALUES
(1, 1, '101-A'),
(2, 2, '202-B'),
(2, 4, '303-C'),
(3, 2, '202-B'),
(4, 1, '101-A'),
(4, 5, '404-D'),
(5, 3, '505-E');
