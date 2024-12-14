# Edutrack

Edutrack es un sistema de seguimiento y gestión de matrículas diseñado para academias educativas. Permite almacenar y administrar la información de estudiantes, cursos y sus respectivas matrículas, ofreciendo una API REST para realizar diversas operaciones CRUD y consultas específicas.

---

## Endpoints REST

### **Estudiantes**

#### GET /students
Devuelve la lista de todos los estudiantes ordenados de manera descendente por edad.

#### GET /students/{id}
Devuelve el registro de un estudiante específico según su identificador.

#### POST /students
Registra un nuevo estudiante.

#### PUT /students/{id}
Actualiza la información de un estudiante existente.

#### DELETE /students/{id}
Elimina el registro de un estudiante específico.

---

### **Cursos**

#### GET /courses
Devuelve la lista de todos los cursos disponibles.

#### GET /courses/{id}
Devuelve el registro de un curso específico según su identificador.

#### POST /courses
Registra un nuevo curso.

#### PUT /courses/{id}
Actualiza la información de un curso existente.

#### DELETE /courses/{id}
Elimina el registro de un curso específico.

---

### **Matrículas**

#### GET /enrollments
Devuelve la lista de todas las matrículas registradas con sus detalles.

#### GET /enrollments/{id}
Devuelve el registro de una matrícula específica según su identificador.

#### POST /enrollments
Registra una nueva matrícula.

#### PUT /enrollments/{id}
Actualiza la información de una matrícula existente.

#### DELETE /enrollments/{id}
Elimina el registro de una matrícula específica.

#### GET /enrollments/courses-students
Muestra la relación de cursos matriculados y sus estudiantes correspondientes usando programación funcional.

---

## Inicialización de datos

La aplicación incluye un archivo `data.sql` en `src/main/resources` con datos de ejemplo que pueden ser utilizados manualmente para probar la aplicación. Este archivo no se ejecutará automáticamente al iniciar la aplicación, pero puedes usarlo para cargar datos iniciales si es necesario.

### Configuración inicial

Dentro del proyecto se incluye un archivo `application-sample.properties` en `src/main/resources`. Este archivo sirve como plantilla para configurar la aplicación y debe ser copiado y ajustado según el entorno en el que se ejecute la aplicación.

#### **Pasos para configurar:**
1. Copia el archivo `application-sample.properties` a `application.properties`:
   ```bash
   cp src/main/resources/application-sample.properties src/main/resources/application.properties
   ```

2. Ajusta los valores de configuración en `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/edutrack
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```

---

## Ejemplos de datos para probar los endpoints

### **Estudiante (StudentDTO)**
```json
{
  "firstNames": "Carlos",
  "lastNames": "Hernández",
  "dni": "12345678",
  "dateBirth": "1999-04-10"
}
```

### **Curso (CourseDTO)**
```json
{
  "name": "Introducción a la Programación",
  "acronym": "INTPROG",
  "isActive": true
}
```

### **Matrícula (EnrollmentDTO)**
```json
{
  "enrollmentDate": "2024-01-05T08:30:00",
  "student": {"idStudent":1},
  "details": [
    {
      "course":{"idCourse": 1},
      "classroom": "101-A"
    }
  ],
  "state": true
}
```

---

## Contenido del archivo `data.sql`

### **Estudiantes**
```sql
INSERT INTO Student (first_names, last_names, dni, date_birth) VALUES
('Carlos', 'Hernández', '12345678', '1999-04-10'),
('María', 'Gómez', '87654321', '2001-02-15'),
('Luis', 'Fernández', '11223344', '1998-07-25'),
('Ana', 'López', '44556677', '2000-11-30'),
('Sofía', 'Pérez', '99887766', '1997-05-20');
```

### **Cursos**
```sql
INSERT INTO Course (name, acronym, state) VALUES
('Introducción a la Programación', 'INTPROG', true),
('Base de Datos Avanzada', 'BDADV', true),
('Cálculo Diferencial', 'CALDIFF', false),
('Inteligencia Artificial', 'IA', true),
('Diseño de Interfaces', 'UIUX', true);
```

### **Matrículas**
```sql
INSERT INTO Enrollment (enrollment_date, id_student, state) VALUES
('2024-01-05 08:30:00', 1, true),
('2024-01-06 10:00:00', 2, true),
('2024-01-06 11:00:00', 3, true),
('2024-01-07 09:30:00', 4, true),
('2024-01-08 14:00:00', 5, true);

INSERT INTO EnrollmentDetail (id_enrollment, id_course, classroom) VALUES
(1, 1, '101-A'),
(2, 2, '202-B'),
(2, 4, '303-C'),
(3, 2, '202-B'),
(4, 1, '101-A'),
(4, 5, '404-D'),
(5, 3, '505-E');
```

