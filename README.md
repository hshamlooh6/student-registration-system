# Student Registration System (Java)

A console program for keeping track of students and the courses they're registered in. My classmate and I built it for the Data Structures course (ITCS214) at the University of Bahrain, first semester 2024/2025. I'm a computer engineering student, and this was one of the courses I took from the computer science department.

The main idea of the project was to practice lists: the students are kept in a Java `LinkedList`, sorted by ID, and each student has an `ArrayList` of the courses they're registered in.

## What it can do

- Register a student (the list stays sorted by student ID, and the same ID can't be added twice)
- Remove a student
- Add a course to a student
- Remove a course from a student
- Find a student's position in the list
- Print a student's advisor number
- Print all of a student's details and courses
- Show a student by their index in the list
- Show how many students are in the list
- List all students in ID order

## Registration rules

- A student can't register the same course twice.
- A student can register up to 18 credits. If their GPA is above 3.00, they can go up to 21.
- A course can't be removed if it would leave the student with fewer than 12 credits.

## Classes

| Class | What it does |
|---|---|
| `Course` | Course number, name, credits and section |
| `Student` | Student info (ID, name, gender, email, GPA, advisor) and their list of registered courses |
| `Roster` | The `LinkedList` of students, with all the add, delete, search and print methods |
| `Registration` | The menu you use to run everything (a `switch` inside a loop) |

## How to run

You need Java installed.

```bash
javac *.java
java Registration
```

Then choose a number from the menu.

## Authors

- Hussain Ali Mirza Shamlooh
- Mohammed Fadhel Abbas

## License

MIT License. See [LICENSE](LICENSE).
