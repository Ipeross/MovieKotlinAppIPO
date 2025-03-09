# Movies Kotlin App IPO 🎬

## Descripción

Este es un proyecto de una aplicación con un slider de pelícualas een cartelera en Android utilizando Jetpack Compose. 📱

## Tecnologías Utilizadas

- **Jetpack Compose**: Para la creación de la interfaz de usuario.
- **MutableState**: Para manejar cambios de estado de las peliculas.
- **Retrofit**: Para la comunicación y las peticiones con la API REST.
- **LazyColumn**: Para mostrar las películas de forma eficiente, cargando solo los elementos visibles para optimizar memoria.
- **AsyncImage**: Para mostrar las portadas de las películas dentro del componente personalizado.

## Funcionalidad ⚡

- Permite ver las películas en cartelera (now playing) de TMDB.
- Uso de LazyColumn para poder navegar entre las carteleras de manera eficiente.

# Rubrica 🖊

---

## **3. Uso de Retrofit con LazyColumn o Similares (1.5 puntos)**  

- **(0.75 pts)** Integración de Retrofit para consumir datos externos.
**--> Uso correcto de Retrofit en la clase MovieApiService para la peticiones.**
- **(0.75 pts)** Uso correcto de LazyColumn u otro componente similar para mostrar los datos.
**--> Se usa LazyColumn en el MainActivity para mostrar de manera eficiente las carteleras.**

---
