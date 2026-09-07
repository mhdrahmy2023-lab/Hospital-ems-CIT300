package hospital;

/**
 * Emergency Patient Queue implemented using a fixed-size array (FIFO).
 * Supports: enqueue, dequeue, displayQueue, and empty-queue handling.
 */
public class EmergencyQueue {

    private Patient[] queueArray;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public EmergencyQueue(int capacity) {
        this.capacity = capacity;
        this.queueArray = new Patient[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Add a patient to the back of the waiting queue
    public void enqueue(Patient patient) {
        if (size == capacity) {
            System.out.println("Queue is full. Cannot add patient " + patient.name);
            return;
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = patient;
        size++;
        System.out.println("Patient " + patient.name + " (ID: " + patient.id + ") added to the emergency queue.");
    }

    // Remove and return the next patient to be treated
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No patients waiting.");
            return null;
        }
        Patient treated = queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % capacity;
        size--;
        return treated;
    }

    // Display all patients currently waiting, in FIFO order
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No patients currently waiting in the emergency queue.");
            return;
        }
        System.out.println("Patients waiting (front to back):");
        int index = front;
        for (int i = 0; i < size; i++) {
            queueArray[index].displayDetails();
            index = (index + 1) % capacity;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
