# Mini Hospital Emergency Management System

**Course:** CIT300 - Data Structures and Algorithms
**Assignment:** Individual Mid Assignment
**Language:** Java
**Author:** Mohamed Rahmy
**Student ID:** 23DA2-0641

## Overview

This is a console-based Mini Hospital Emergency Management System that simulates patient registration, emergency queueing, treatment completion, and patient visit history tracking, using core data structures implemented from scratch (without `java.util` collections).

## Data Structures Used

| Feature | Data Structure | File(s) |
|---|---|---|
| Patient Records | Binary Search Tree (BST), keyed on Patient ID | `PatientBST.java` |
| Emergency Patient Queue | Queue (FIFO), array-based | `EmergencyQueue.java` |
| Treatment History | Stack (LIFO), array-based | `TreatmentStack.java`, `TreatmentRecord.java` |
| Patient Visit History | Singly Linked List | `VisitLinkedList.java`, `VisitRecord.java` |

## Project Structure

```
HospitalEMS/
└── src/
    └── hospital/
        ├── Patient.java           # Patient model
        ├── PatientBST.java        # BST: insert, search, delete, in-order traversal
        ├── EmergencyQueue.java    # Queue: enqueue, dequeue, display
        ├── TreatmentRecord.java   # Treatment record model (Stack payload)
        ├── TreatmentStack.java    # Stack: push, pop, display
        ├── VisitRecord.java       # Visit record model (Linked List payload)
        ├── VisitLinkedList.java   # Linked List: add, search, remove, display
        └── Main.java              # Demonstrates all four data structures
```

## How to Compile and Run

```
cd src
javac hospital/*.java
java hospital.Main
```

Or simply run `Main.java` from Eclipse (Run As → Java Application).

## Features Implemented

**1. Patient Records (BST)**
Insert, search, and delete patients by ID; view all patients sorted by ID via in-order traversal. Deletion handles all three cases: leaf node, single child, and two children (in-order successor replacement).

**2. Emergency Queue**
Add registered patients to the waiting line (enqueue) and call the next patient for treatment (dequeue), following FIFO order. Handles an empty queue gracefully with a clear message instead of crashing.

**3. Treatment History (Stack)**
Push a completed treatment record onto the stack; pop to undo/remove the most recently completed record, following LIFO order. Handles an empty stack gracefully.

**4. Patient Visit History (Singly Linked List)**
Each patient's visit history (Visit ID, Date, Doctor Name, Diagnosis, Treatment) is tracked using a singly linked list. Supports adding a new visit, searching for a visit by ID, removing a visit by ID, and displaying the full history in order. Handles searching/removing on an empty list, and removing a non-existent visit ID, without crashing.

## How Each Data Structure Is Used (in my own words)

- **BST for Patient Records:** Patient ID is used as the BST key so that patients can be inserted, found, and removed in better-than-linear time on average, and an in-order traversal naturally produces patients sorted by ID — useful for a clean patient list.
- **Queue for the Emergency Line:** New arrivals must be treated in the order they arrived (fairness), which is exactly what a FIFO queue guarantees. Enqueue adds to the back, dequeue serves from the front.
- **Stack for Treatment History:** Completed treatments are stored LIFO so the most recently completed treatment is always the quickest to access/undo — this mirrors how staff would typically want to review "what did we just do" first.
- **Linked List for Visit History:** Each patient can have any number of past visits, added over time, with no fixed maximum — a linked list grows dynamically without needing to resize an array, and supports straightforward add/search/remove by Visit ID.

## Design Notes

- The BST, Queue, Stack, and Linked List are all implemented from first principles (not using `java.util` collections) to demonstrate the underlying mechanics of each structure.
- The Queue and Stack use fixed-size arrays for simplicity and to clearly show FIFO/LIFO ordering logic.
- The Linked List uses dynamically linked nodes (head/tail pointers), since a patient's visit count isn't known in advance.
- `TreatmentRecord` and `VisitRecord` are kept as separate small classes (rather than reusing `Patient` directly) because a treatment/visit needs extra context (date, doctor, diagnosis) that doesn't belong on the `Patient` model itself.
- Every structure explicitly checks for the empty case (empty queue, empty stack, empty/not-found in the linked list) and prints a clear message instead of throwing an exception.

## Testing Notes

The `Main.java` demo explicitly exercises the following edge cases, with console output captured as screenshots for submission:
- Searching for and deleting a non-existent Patient ID from the BST
- Dequeuing from an already-empty Emergency Queue
- Popping from an already-empty Treatment Stack
- Searching for and removing a non-existent Visit ID from the Visit History list
- Removing from an already-empty Visit History list
