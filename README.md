# Rip Off Pokemon
## Premise:
This Project will be a multiplayer game that is like a simple version of pokemon. There will be 2 game modes a map mode to run around and catch monsters and a battle mode where you can battle a (RNG) CPU or a friend.

## Features
  - [X] Present a Welcome screen.
    - [x] Be able to start a new game
    - [X] Be able to Load a game
    - [x] Be able to exit program
  - [x] Character creation
    - [x] present a player with customization options
    - [x] let a player choose thier name
    - [x] let a player pick between starting monsters
  - [x] Save a game
    - [x] Local Save
    - [ ] Database save
  - [x] Load a game
    - [x] Load from Local Save
    - [ ] Load from Database save
  - [x] Exploration
    - [x] move player on map
    - [x] Capture Monsters
  - [x] Battle
    - [x] be able to attack another monster
    - [x] battle a CPU
    - [x] battle a friend
  - [x] Multithreading
     - [x] pick up kill signal and ask to save progress on new thread 
  
## Usage
 ### Compile
```bash
  mvn compile
```
### Run
```bash
  mvn exec:java -q
```
### Test
```bash
  mvn test
```
## Tech Stack
- Java 8:
  - File I/O
    -used to save game locally
  - Collections API
    - used many places including list of monsters and player  choice options
  - Concurrency
    - still working this one out, something with multiplayer maybe??
- Maven 3
    - used to create and manage project
- JUnit 5
  - used to unit test the project
- Git
   - used as source control
- PostgreSQL 9+
  - conceptually used as an optional save to save game state to DB to be used on a seperate system. (though it may not ever be hosted in an acessible place online)

