Mini Hospital Emergency Management System
Course: CIT300 - Data Structures and Algorithms
Assignment: Individual Mid Assignment
Language: Java
Author: Mohamed Rahmy
Overview
This is a console-based Mini Hospital Emergency Management System that simulates
patient registration, emergency queueing, treatment completion, and (soon) patient
visit history tracking, using core data structures implemented from scratch.
Data Structures Used
Feature	Data Structure	File(s)
Patient Records	Binary Search Tree (BST), keyed on Patient ID	`PatientBST.java`
Emergency Patient Queue	Queue (FIFO), array-based	`EmergencyQueue.java`
Treatment History	Stack (LIFO), array-based	`TreatmentStack.java`
Patient Visit History	Singly Linked List (coming next)	`VisitLinkedList.java`
Project Structure
```
HospitalEMS/
└── src/
    └── hospital/
        ├── Patient.java           # Patient model
        ├── PatientBST.java        # BST: insert, search, delete, in-order traversal
        ├── EmergencyQueue.java    # Queue: enqueue, dequeue, display
        ├── TreatmentRecord.java   # Treatment record model (Stack payload)
        ├── TreatmentStack.java    # Stack: push, pop, display
        └── Main.java              # Demonstrates all data structures
```
How to Compile and Run
```bash
cd src
javac hospital/*.java
java hospital.Main
```
Or simply run `Main.java` from Eclipse (Run As → Java Application).
Features Implemented So Far
Patient Records (BST) — Insert, search, delete patients by ID; view all
patients sorted by ID via in-order traversal.
Emergency Queue — Add registered patients to the waiting line (enqueue)
and call the next patient for treatment (dequeue), FIFO order. Handles an
empty queue gracefully.
Treatment History (Stack) — Push a completed treatment onto the stack;
pop to undo/remove the most recent record; LIFO order. Handles an empty
stack gracefully.
Coming Next
Patient Visit History (Singly Linked List) — Each patient will have a
linked list of past visits (add, remove, search, display).
Design Notes
The BST, Queue, and Stack are implemented from first principles (not using
`java.util` collections) to demonstrate the underlying data structures.
BST deletion handles all three cases: leaf node, single child, and two
children (in-order successor replacement).
The Queue and Stack use fixed-size arrays for simplicity and to clearly
show FIFO/LIFO ordering logic.
