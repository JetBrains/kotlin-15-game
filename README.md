# Kotlin 15th Anniversary Game

This browser-based 2D sandbox game celebrates Kotlin’s 15th birthday. It is written entirely in Kotlin, with a Kotlin backend for high scores.

## Projects

This repository contains two independent Gradle projects.

### [`game/`](./game) – Kodee vs. Friction

A 2D sandbox game built with **Kotlin Multiplatform Compose** targeting **WebAssembly**. It runs directly in the browser and showcases what Kotlin/Wasm can do: procedural world generation, chunk-based terrain, fluid simulation, particle effects, a sprite-animated player, a roster of enemies with distinct AI, an unlock system with Kotlin-themed names (Elvis Operator, Smart Casts, Coroutines, and more), special attacks, a portal, and a final boss.

To run the game locally, use the following command:

```shell
cd game
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

See [`game/README.md`](./game/README.md) for more build targets.

### [`highscore-server/`](./highscore-server) – Kodee vs. Friction Server

This **Ktor 3** backend (Kotlin/JVM 21) stores and serves high scores for Kodee vs. Friction. It uses Exposed ORM against PostgreSQL (H2 for embedded/testing), kotlinx.serialization for JSON, and HTTP Basic Auth. Tests start the full app against a Testcontainers PostgreSQL instance.

To run the server locally, use the following commands:

```shell
cd highscore-server
./gradlew run      # starts on localhost:8080
./gradlew test
```

A `Dockerfile` and `docker-compose.yml` are also provided.

## How to play

* **Move:** `A` / `D` or the arrow keys.
* **Jump:** `Space` (tap again in midair once you unlock Double Jump; hold for Jetpack or Hover).
* **Dash:** `Shift` (available after you unlock Dash).
* **Anchor / Become invulnerable:** `S` (available after you unlock Immutability).
* **Aim and attack:** Move the mouse and left-click to use your current weapon.
* **Switch weapon/tool:** Number keys `1`–`3` for hotkey slots.
* **Special attack:** `R` (when available).
* **Pause:** `Esc`.

Explore the world, mine resources with the pickaxe, build with the hammer, and fight enemies with the staff. Find shrines to choose one of three random unlocks, collect special combos, pass through the portal, and face the Final Void.

## Tech stack highlights

* Kotlin Multiplatform and Compose Multiplatform with a Wasm target.
* Ktor 3, Exposed, and PostgreSQL.
* Gradle with the Kotlin DSL in both subprojects.

Happy 15th, Kotlin!
