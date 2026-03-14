# Pokédex Application

A full-stack Pokédex application that allows users to browse Pokémon, view detailed information, and explore data retrieved from the public Pokémon API.

This project was built to practice **full-stack development**, including a **React frontend** and a **Java backend** that acts as a proxy layer between the client and the external API.

---

# 📸 Application Preview

### Main Interface

<img width="1904" height="941" alt="image" src="https://github.com/user-attachments/assets/6f90c9a6-45d9-43c1-9189-5a5342310e9f" />
<img width="377" height="815" alt="image" src="https://github.com/user-attachments/assets/7126cfbf-5073-4c28-a525-89102603fa45" />

### Pokémon Details

<img width="370" height="814" alt="image" src="https://github.com/user-attachments/assets/588c1087-eb96-4946-b8a5-910c62a3d097" />
<img width="1885" height="941" alt="image" src="https://github.com/user-attachments/assets/af5a55bd-b66b-4815-b1a3-9bb8d2af48aa" />

---

# 🎯 Project Goals

The main goal of this project was to:

* Build a **clean full-stack architecture**
* Practice **API integration**
* Implement **data mapping and DTO patterns**
* Apply **layered backend architecture**
* Structure a **React application with hooks and services**
* Document architecture clearly for maintainability

---

# 🧱 Architecture Overview

This project follows a **layered architecture**, separating responsibilities between frontend and backend.

<img width="728" height="603" alt="image" src="https://github.com/user-attachments/assets/9fb4de36-d0ec-4869-9e01-20c4f1aa21b3" />

### Frontend Flow

React Components → Custom Hooks → Service Layer → HTTP Client → Backend API

### Backend Flow

Controller → Service → API Client → External API

External responses are transformed into internal models using **DTOs and mappers**.

---

# 📦 Technologies Used

### Frontend

* React
* JavaScript
* CSS

### Backend

* Spring Boot
* Java
* REST API

### Tools

* Figma
* IntelliJ IDEA
* GitHub
* Vs Code
* Draw.io
* Postman
* Canvas

---

# 🖥 Frontend

The frontend was built using **React**.

### Responsibilities

* UI rendering
* State management via custom hooks
* API communication through service layer

### Main Structure

```
src
 ├── components
 │   ├── PokemonCard
 │   ├── PokemonDetails
 │   └── Filters
 │
 ├── hooks
 │   └── usePokemon
 │
 └── services
    └── pokemonService.js
 
```

### Key Concepts Used

* Custom React Hooks
* Component-based architecture
* Service layer abstraction
* API data fetching
* UI state management

---

# ⚙️ Backend

The backend was built using **Spring Boot**.

It acts as a **proxy layer** between the frontend and the external Pokémon API.

### Responsibilities

* Handle HTTP requests from frontend
* Fetch data from external API
* Transform external responses
* Return structured DTO responses

### Backend Structure

```
src
 ├── controller
 │   └── PokemonController
 │
 ├── service
 │   └── PokemonService
 │
 ├── client
 │   └── PokeApiClient
 │
 ├── dto
 │   └── PokemonDTO
 │
 ├── mapper
 │   └── PokemonMapper
 │
 └── utils
     └── PokemonUtils
```

# 🔗 External API

The project consumes data from the public Pokémon API:

PokeAPI

https://pokeapi.co

---

# 🔄 Data Flow

The application follows this request lifecycle:

1. User interacts with the UI
2. React component triggers a custom hook
3. Hook calls the service layer
4. Service performs HTTP request
5. Backend controller receives the request
6. Service layer fetches data from the external API
7. Response is mapped to DTO objects
8. Backend returns structured data to the frontend
9. UI updates accordingly

---

# 🎨 UI Design

Initial UI layout and interface ideas were created using **Figma**.

Mock Example on Figma:
<img width="866" height="617" alt="image" src="https://github.com/user-attachments/assets/74384cd2-4495-4a53-ab95-125d784dafb4" />

---

# 👤 Author

Hugo Faria

GitHub: https://github.com/your-username
