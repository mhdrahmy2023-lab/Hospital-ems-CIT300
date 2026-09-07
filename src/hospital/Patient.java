package hospital;

/**
 * Represents a single patient record.
 * Used by both the PatientBST (Patient Records) and EmergencyQueue.
 */
public class Patient {
    int id;
    String name;
    int age;
    String contact;
    String condition;

    public Patient(int id, String name, int age, String contact, String condition) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.condition = condition;
    }

    public void displayDetails() {
        System.out.println("Patient ID: " + id +
                " | Name: " + name +
                " | Age: " + age +
                " | Contact: " + contact +
                " | Condition: " + condition);
    }
}
