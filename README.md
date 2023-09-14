# AcademyJPA
__________

# **Backend (Spring Boot con Java)**

 ## ALL

|Http method	|URL	|Params/Body	|Efecto en el servidor	|Respuesta|
|------------|-----|-------------|-----------------------|---------|
| **POST**   |/api/persons/register|Body: { <br />*"firstName","lastName" ,"password" ,"email"* <br />}|"Crear un nuevo registro de persona en el servidor"|**201:** si fue creado<br /> **403:** si los campos estan vacios <br /> **403:** si el mail ya esta registrado|
| **POST**    |/api/login|Params:<br/> *email: value password: value*|Creacion de sesion| **200:** exito <br /> **401:** valores invalidos"|
 
  
## ADMIN
|Http method	|URL	             |Params/Body	     |Efecto en el servidor	|Respuesta|
|------------|------------|-----------|-----------------------|---------|
|  **GET**   |/api/admin/teachers |none |none|200: listado de profesores (TeacherDTO)|
|  **GET**   |/api/admin/students |none |none|200: listado de alumnos (StudentDTO)|
|  **GET**   |/api/admin/subjects |none |none|200: listado de materias (SubjectDTO)|
| **PATCH**  |/api/admin/teacher/{id}|none |Modificar rol de una persona a teacher|200: TeacherDTO<br/> 403: persona no existe|
| **PATCH**  |/api/admin/admin|Params:<br/> *id : value*|Modificar rol de una persona a admin|200: Exito<br/> 403: persona no existe|

 
## TEACHER

|Http method	|URL	|Params/Body	|Efecto en el servidor	|Respuesta|
|------------|-----|-------------|-----------------------|---------|
|  **GET**     |/api/teacher|none|none|200: TeacherDTO
| **POST**    |/api/teacher/subject|Params:<br/>*name : value*|Crear nueva materia|200: Exito<br/>403: Nombre ya existe<br/>403: Campo vacio
| **POST**    |/api/teacher/workshop|Body: {<br/> ***"id","year",<br/>"month","day",<br/>"hour","minutes"*** <br/>}|Crear un nuevo Workshop<br/>Asignar ese Workshop a una materia<br/ >Asignar ese Workshop a un Teacher|200: Exito<br/>403: Campos vacios<br/>|

## STUDENT
|Http method	|URL	|Params/Body	|Efecto en el servidor	|Respuesta|
|------------|-----|-------------|-----------------------|---------|
| **GET**    |/api/student|none	|none	|200: StudentDTO
| **POST**    |/api/student/subject|"Params:<br/>***id:value***| Asignar una materia al estudiante(maximo 3 materias) |200: Exito<br/>403: Materia no existe<br/>403: Maximo de materias alcanzado|



## Frontend (HTML, CSS, JavaScript, Vue.js, Bootstrap)

