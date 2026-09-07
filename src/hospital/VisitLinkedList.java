package hospital;

public class VisitLinkedList {

    private class Node {
        VisitRecord data;
        Node next;

        Node(VisitRecord data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public VisitLinkedList() {
        head = null;
        tail = null;
    }

    // Add a new visit record to the end of the list
    public void add(VisitRecord record) {
        Node newNode = new Node(record);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Visit record added for Patient ID " + record.patientId
                + " (Visit ID: " + record.visitId + ")");
    }

    // Search for a visit record by Visit ID
    public VisitRecord search(int visitId) {
        Node current = head;
        while (current != null) {
            if (current.data.visitId == visitId) {
                return current.data;
            }
            current = current.next;
        }
        System.out.println("Visit ID " + visitId + " not found.");
        return null;
    }

    // Remove a visit record by Visit ID
    public void remove(int visitId) {
        if (head == null) {
            System.out.println("Visit history is empty. Nothing to remove.");
            return;
        }

        // If the record to remove is the head
        if (head.data.visitId == visitId) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            System.out.println("Visit ID " + visitId + " removed.");
            return;
        }

        // Search through the rest of the list
        Node previous = head;
        Node current = head.next;
        while (current != null) {
            if (current.data.visitId == visitId) {
                previous.next = current.next;
                if (current == tail) {
                    tail = previous;
                }
                System.out.println("Visit ID " + visitId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        }

        System.out.println("Visit ID " + visitId + " not found. Nothing removed.");
    }

    // Display every visit record in order
    public void displayList() {
        if (head == null) {
            System.out.println("No visit history recorded.");
            return;
        }

        Node current = head;
        while (current != null) {
            current.data.displayDetails();
            current = current.next;
        }
    }
}