# 🛠️ Proyecto de Refactorización

## 📌 Descripción
Este repositorio contiene el proyecto inicial de refactorización, en el cual cada miembro del equipo trabajará en su propia rama siguiendo buenas prácticas de control de versiones.

## 🚀 Requisitos
Antes de comenzar, asegúrate de tener instalado:
- **Git** → [Descargar Git](https://git-scm.com/downloads)
- **IDE** → Usa el IDE de tu eleccion, se creo un .gitignore para tener un entorno lo mas desacoplado al IDE que estes usando. Cualquier sugerencia es bienvenida.
- Acceso al repositorio de GitHub (**agregado como colaborador**).

---

## 🔗 Clonar el repositorio
Cada miembro debe descargar el código en su máquina local ejecutando:
```sh
git clone https://github.com/TuUsuario/TuRepositorio.git
cd TuRepo
```
##⚠️ Acuerdate de Solo Trabajar en tu Rama
Esto asegura mantener el main en su version mas estable posible.

##⚠🏗️ Creacion de tu Rama
```sh
git checkout -b nombre_de_tu_rama
git push -u origin nombre_de_tu_rama
```

## Verificacion de la Rama
```sh
//ver en que rama estas!!!
git branch
//cambiar a tu rama
git checkout -b nombre_de_tu_rama
git push -u origin nombre_de_tu_rama
```

## ⚠️⚠️⚠️ ANTES DE TRABAJAR, ESCRIBIR, MODIFICAR CODEAR O CUALQUIER COSA, PRIMERO UN PULL, asi te aseguras si hay un cambio en la rama principal, tengas tu repo lo mas actualizado posible. ⚠️⚠️⚠️
```sh
git checkout main
git pull origin main
git checkout nombre_de_tu_rama
git merge main
```

## 🚀 Enviar tus cambios a main "hacer Pull Request (merge de tu rama con la rama main)".
### Cuando tengas todo listo para revisión:

Ve a GitHub.

Haz clic en Pull Requests → New Pull Request.

Compara tu rama con la main.

Agrega un título y una descripción clara de los cambios realizados.

Asigna un revisor (admin o compañero).

Espera aprobación para hacer el merge.


