# Pokémon Browser App

A modern Android application built to browse and explore Pokémon data using the public PokeAPI. This project demonstrates modern Android development practices, focusing on a robust architecture, responsive UI, and efficient state management.


## 🌟 Features

* **Paginated Pokémon Roster:** Displays a scrollable list of Pokémon with their names and sprite images fetched dynamically.

* **Detailed Views (In Progress):** A dedicated details screen showcasing specific types (e.g., Grass, Fire) as chips and base stats (HP, Attack, Defense).

* **Resilient UI States:** Handles network delays and failures gracefully by displaying clear loading indicators and user-friendly error messages.

* **Custom Theming:** Utilizes custom dynamic gradient cards for a polished, visually appealing list UI.

* **Upcoming Features:** Infinite scroll pagination, search by name, and offline favorites persistence.


## 🛠 Tech Stack

* **Language:** Kotlin

* **UI Toolkit:** Jetpack Compose & Navigation Compose

* **Asynchrony & Concurrency:** Kotlin Coroutines & Flow (`StateFlow`)

* **Networking:** Retrofit2 & Gson

* **Image Loading:** Coil for Compose


## 🏗 Architecture & Implementation Details

* **Clean Architecture:** Separation of concerns into strictly defined `data`, `domain`, and `ui` layers to decouple business logic from the Android framework.

* **MVVM Pattern:** ViewModels manage UI-related data and handle interactions, ensuring the UI remains stateless and reactive.

* **Unidirectional Data Flow (UDF):** The UI strictly observes a `sealed interface` representing state (`Loading`, `Success`, `Error`), preventing invalid state rendering.

* **Repository Pattern:** Centralized data fetching strategy that maps raw remote API DTOs into clean domain models before exposing them to the UI.
