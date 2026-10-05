## ESCENARIO 1 - Crear cuenta administrador:

DESCRIPCIÓN
Verifica que un usuario sin sesión iniciada pueda registrarse exitosamente como Administrador completando el formulario de registro de usuario, y que la cuenta quede disponible.

PRECONDICIONES
- No tener sesión iniciada en AdminCES.
- Contar con los datos de conexión al sitio (URL, contraseña de acceso).
- Contar con un conjunto de datos para creación de usuario admin (Nombre, Apellido, Email, Contraseña, País) por cada caso a probar.

PASOS
1) Ingresar al sitio con la contraseña de acceso. Validar que se accedió correctamente.
2) Ir a "Registrarse".
3) Completar el formulario con Nombre, Apellido, Email, Contraseña y País.
4) Confirmar el alta de usuario creado.
5) Iniciar sesión con el email y contraseña recién creados. Validar que la sesión se inició.
6) Ir a "Ver usuarios".
7) Validar que el usuario aparece con los datos ingresados y que el perfil sea "Administrador".
8) Repetir para cada caso de datos.

FUNCIONES AUXILIARES
- ingresarAlSitio(): accede al sitio y valida que cargó correctamente.
- iniciarSesionAdministrador(email, contraseña): inicia sesión y valida que quedó iniciada.
- crearCuentaAdministrador(nombre, apellido, email, contraseña, país): completa y confirma el alta de Administrador.


## ESCENARIO 2: Reiniciar contraseña
DESCRIPCIÓN
Verifica que se pueda reiniciar la contraseña de una cuenta existente ingresando el email y una nueva clave, y que el usuario pueda loguearse con la nueva contraseña.

PRECONDICIONES
- Contar con los datos de conexión al sitio.
- Contar con un conjunto de datos para crear la cuenta administrador (Nombre, Apellido, Email, País, Contraseña inicial, Contraseña nueva).

PASOS
1) Ingresar al sitio.
2) Crear una cuenta Administrador (precondición)
3) Ir a "Reiniciar contraseña".
4) Completar el Email con el email utilizado en la cuenta creada en el paso 2 y la colocar una contraseña nueva (y su repetición).
5) Confirmar el reinicio.
6) Iniciar sesión con el email y la contraseña nueva.
7) Validar que el login fue exitoso.
8) Repetir para cada caso de datos.

FUNCIONES AUXILIARES
- ingresarAlSitio()
- crearCuentaAdministrador(nombre, apellido, email, contraseña, país)
- reiniciarContrasena(email, contraseñaNueva)
- iniciarSesionAdministrador(email, contraseña)


## ESCENARIO 3: Crear cuenta tester
DESCRIPCIÓN
Verifica que un Administrador logueado pueda dar de alta un nuevo usuario Tester (Junior/Senior/Líder) y que quede visible en el listado de usuarios con el perfil correcto.

PRECONDICIONES
- Contar con las credenciales (usario y contraseña) del Administrador predefinido.
- Contar con un conjunto de datos por caso para la creación de usuario tipo tester (Nombre, Apellido, Email, País, Contraseña, Perfil a probar).

PASOS
1) Ingresar al sitio.
2) Iniciar sesión como el Administrador predefinido (precondiciòn). 
3) Validar que la sesión se inició.
4) Ir a "Crear usuario". 
5) Completar Nombre, Apellido, Email, País y Contraseña por defecto.  seleccionar el Perfil correspondiente al caso (Junior / Senior / Líder). 
6) Confirmar el alta. 
7) Ir a "Ver usuarios". 
8) Validar que el usuario aparece con los datos ingresados y el Perfil seleccionado. 
9) Repetir para cada uno de los 3 perfiles.

FUNCIONES AUXILIARES
- ingresarAlSitio()
- iniciarSesionAdministrador(email, contraseña)
- crearCuentaTester(nombre, apellido, email, país, contraseña, perfil)


## ESCENARIO 4: Eliminar cuenta tester
DESCRIPCIÓN
Verifica que un Administrador logueado pueda eliminar una cuenta Tester existente desde "Ver usuarios", y que la cuenta deje de estar disponible en el sistema.

PRECONDICIONES
- Contar con las credenciales del Administrador predefinido.
- Contar con un conjunto de datos por caso (Nombre, Apellido, Email, País, Contraseña) para el Tester a crear y eliminar.

PASOS
1) Ingresar al sitio. 
2) Iniciar sesión como el Administrador predefinido. 
3) Crear una cuenta Tester con los datos del caso (precondición). 
4) Validar que el Tester quedó creado antes de intentar eliminarlo. 
5) Ir a "Ver usuarios". 
6) eliminar el usuario recientemente creado 
7) Confirmar la eliminación con el modal que aparece 
8) Volver a "Ver usuarios"
9) Validar que el usuario ya no aparece en el listado. 
10) Repetir para cada caso de datos.

FUNCIONES AUXILIARES
- ingresarAlSitio()
- iniciarSesionAdministrador(email, contraseña)
- crearCuentaTester(nombre, apellido, email, país, contraseña, perfil): (precondición).
- eliminarUsuarioYConfirmar(email)