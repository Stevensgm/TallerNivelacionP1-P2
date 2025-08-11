# Preguntas teoricas

## 1. ¿Qué es un repositorio en Git y cómo se diferencia de un proyecto “normal”?
- Un repositorio Git es una base de datos que almacena el historial completo de un proyecto, incluyendo todos los archivos, revisiones, ramas y metadatos. Es el corazón de Git.
- la diferencias con un proyecto normal es qu un repositorio Git tiene un historia de versiones 

## 2. ¿Cuáles son las tres áreas principales de Git (working directory, staging area/index y repository) y qué papel cumple cada una?
- Working Directory (Directorio de Trabajo): Es el área donde trabajas directamente con los archivos del proyecto. Aquí es donde editas, borras y creas archivos.
- Staging Area (Área de Preparación) / Index: Es un área intermedia donde preparas los cambios que quieres incluir en tu próximo "commit". Con git add, seleccionas los archivos del working directory que quieres guardar.
- Repository (Repositorio): Es la base de datos de Git donde se almacenan todos los "commits" y el historial del proyecto de forma permanente.

## 3. ¿Cómo representa Git los cambios internamente? (objetos blob, tree, commit y tag).
- Blob (Binary Large Object): Almacena el contenido de un archivo. Si el contenido de un archivo cambia, se crea un nuevo objeto blob. Git no almacena archivos completos, sino su contenido.
- Tree (Árbol): Es una estructura que mapea nombres de archivos y directorios a los objetos blob y otros tree. Es como el "árbol de directorios" de tu proyecto en un momento dado.
- Commit: Es un "snapshot" de tu proyecto. Un commit es un puntero a un objeto tree (el estado de todos los archivos) y a su commit padre (el estado anterior). También guarda metadatos como el autor y el mensaje.
- ag: Es un nombre descriptivo (como "v1.0") que se le da a un commit específico. A diferencia de las ramas, los tags no se mueven; son un hito fijo en el historial.

## 4. ¿Cómo se crea un commit y qué información almacena un objeto commit?
- Un commit se crea después de preparar tus cambios con git add y luego ejecutar git commit -m "Mensaje del commit".

- Un objeto commit almacena:

- Un hash único (SHA-1).

- Un puntero al tree (el estado de los archivos).

- Un puntero a uno o más commits padres.

- El autor del commit.

- La fecha.

- El mensaje que explica los cambios.

## 5. ¿Cuál es la diferencia entre git pull y git fetch?
- git fetch: Es el comando para "traer" la información. Descarga los commits y ramas del repositorio remoto a tu repositorio local, pero no los integra en tu working directory. Es útil para ver qué cambios han hecho otros antes de decidir si quieres aplicarlos.

- git pull: Es un atajo que hace dos cosas: primero, un git fetch (descarga los cambios) y luego un git merge (integra esos cambios en tu rama actual). pull actualiza automáticamente tu working directory. Es el comando que usas para sincronizar tu trabajo con el del equipo.

## 6. ¿Qué es un branch (rama) en Git y cómo Git gestiona los punteros a commits?
- Una rama es simplemente un puntero móvil a un commit. Por defecto, Git crea la rama main (o master).

- Punteros:

1. Cada rama es un puntero que apunta al último commit en esa línea de desarrollo.

2. El puntero HEAD es el que te dice en qué rama estás.

3. Cuando haces un nuevo commit, Git crea un nuevo commit y mueve el puntero de la rama actual (y el HEAD) para que apunten a ese nuevo commit.

## 7. ¿Cómo se realiza un merge y qué conflictos pueden surgir? ¿Cómo se resuelven?
- Un merge es la operación de combinar el historial de dos ramas. Usas git merge <nombre_rama> para integrar los cambios de otra rama en la tuya. Git crea un nuevo commit de tipo merge con dos padres.

- Conflictos: Ocurren cuando Git no puede fusionar los cambios automáticamente porque la misma línea de un archivo fue modificada de forma diferente en ambas ramas.

- Resolución:

1. Git te avisa de los archivos conflictivos.

2. Abre el archivo. Verás marcadores (<<<<<<<, =======, >>>>>>>) que indican los cambios de cada rama.

3. Edita el archivo manualmente para elegir la versión final que quieres.

4. Borra los marcadores de conflicto.

5. Usa git add <archivo> para marcar que el conflicto ha sido resuelto.

6. Finaliza el merge con git commit.

## 8. ¿Cómo funciona el área de staging (git add) y qué pasa si omito este paso?
- El staging area es tu "canasta de compras" para el commit. git add coloca los archivos modificados en esa canasta. Es esencial porque te permite hacer commits atómicos y bien definidos.

- Si lo omites, git commit no incluirá los cambios. El comando por defecto solo ve los archivos que ya están en el staging area. La única excepción es git commit -a, que agrega automáticamente todos los archivos rastreados por Git (pero no los nuevos) al commit.

## 9. ¿Qué es el archivo .gitignore y cómo influye en el seguimiento de archivos?
- .gitignore es un archivo de texto donde le dices a Git qué archivos y directorios debe ignorar.

- Influencia: Git simplemente no los rastrea. Esto es vital para evitar que archivos temporales, logs, dependencias (como la carpeta node_modules o los binarios de un proyecto compilado) se suban al repositorio, manteniendo tu historial limpio y tu repo ligero.

## 10. ¿Cuál es la diferencia entre un “commit amend” (--amend) y un nuevo commit?
- git commit --amend: No crea un nuevo commit, reescribe el último. Lo usas para corregir un error en el mensaje del commit anterior o para incluir un archivo que se te olvidó. Es como si el último commit no hubiera existido. Precaución: Nunca uses --amend en un commit que ya fue subido y compartido.

- Nuevo commit: Es la operación estándar. Crea un nuevo commit con un nuevo hash y lo añade al final del historial.

## 11. ¿Cómo se utiliza git stash y en qué escenarios es útil?
- git stash es una herramienta para "guardar temporalmente" tus cambios sin hacer un commit. Es útil para "pausar" tu trabajo.

- Escenarios:

1. Te piden urgentemente un hotfix en otra rama. Guardas tu trabajo actual con git stash, cambias de rama, haces el fix, vuelves a tu rama y recuperas tus cambios con git stash pop.

2. Tu rama se ha desincronizado con el remoto y quieres actualizarla sin hacer un commit a medias. Haces un stash, luego un pull y finalmente un stash pop.

## 12. ¿Qué mecanismos ofrece Git para deshacer cambios (por ejemplo, git reset, git revert, git checkout)?
- git reset: Un comando poderoso que reescribe el historial. Mueve la rama actual a un commit anterior. ¡Úsalo con cuidado!

--soft: Mantiene los cambios del commit en el staging area.

--mixed (por defecto): Mueve los cambios al working directory.

--hard: Elimina todos los cambios.

- git revert: La forma segura de deshacer un commit. Crea un nuevo commit que revierte los cambios del commit especificado. No reescribe el historial, por lo que es la opción ideal para deshacer cambios que ya se han compartido en un repositorio remoto.

- git checkout: Se usa principalmente para cambiar de rama o para mover HEAD a un commit específico. También puedes usarlo para descartar los cambios en un archivo (git checkout -- <archivo>).

## 13. ¿Cómo funciona la configuración de remotos (origin, upstream) y qué comandos uso para gestión de forks?
- Remotos: Son enlaces a otros repositorios. origin es el nombre por defecto para el repositorio desde el que clonaste.

- Forks:

1. git clone Clonas tu propio fork del proyecto.

2. git remote add upstream  Añades el repositorio original como un remoto con el nombre upstream.

3. git fetch upstream: Traes los cambios del repositorio original.

4. git pull upstream main: Integras los cambios de la rama main del repo original en tu rama local.

5. git push origin main: Subes tus cambios a tu propio fork.

## 14. ¿Cómo puedo inspeccionar el historial de commits (por ejemplo, git log, git diff, git show)?
- git log: El comando principal para ver el historial de commits. Úsalo con flags como --oneline para una vista compacta o --graph para ver la estructura de las ramas.

- git diff: Muestra las diferencias. Es fundamental para ver lo que has cambiado.

1. git diff: Muestra las diferencias entre tu working directory y el staging area.

2. git diff --staged: Muestra las diferencias entre el staging area y el último commit.

3. git diff <commit1> <commit2>: Compara el estado del proyecto entre dos commits.

- git show: Muestra los detalles de un commit específico, incluyendo el mensaje, autor y el diff de los cambios que se hicieron.

