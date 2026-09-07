package hospital;

/**
 * Treatment History implemented as a Stack (LIFO) using a fixed-size array.
 * Supports: push, pop, display, and empty-stack handling.
 */
public class TreatmentStack {

    private TreatmentRecord[] stackArray;
    private int top;
    private int capacity;

    public TreatmentStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new TreatmentRecord[capacity];
        this.top = -1;
    }

    // Push a newly completed treatment record onto the stack
    public void push(TreatmentRecord record) {
        if (top == capacity - 1) {
            System.out.println("Stack is full. Cannot add treatment record for " + record.patientName);
            return;
        }
        top++;
        stackArray[top] = record;
        System.out.println("Treatment record for " + record.patientName + " pushed onto the stack.");
    }

    // Pop (remove and return) the most recently completed treatment record
    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No treatment records to remove.");
            return null;
        }
        TreatmentRecord popped = stackArray[top];
        stackArray[top] = null;
        top--;
        return popped;
    }

    // Display all treatment records, most recent first (LIFO order)
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("No completed treatment records yet.");
            return;
        }
        System.out.println("Treatment history (most recent first):");
        for (int i = top; i >= 0; i--) {
            stackArray[i].displayDetails();
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
