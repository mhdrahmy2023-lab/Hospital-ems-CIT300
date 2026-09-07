package hospital;

public class Main {
    public static void main(String[] args) {

        // ===================== BST DEMO =====================
        PatientBST bst = new PatientBST();

        // Insert patients
        bst.insert(201, "Ishara Wickramasinghe", 34, "0711122334", "Migraine");
        bst.insert(207, "Dilshan Jayasuriya", 52, "0722233445", "Diabetes Checkup");
        bst.insert(204, "Sanduni Rathnayake", 27, "0733344556", "Sprained Ankle");
        bst.insert(210, "Farhan Ismail", 19, "0744455667", "Food Poisoning");
        bst.insert(202, "Chamodi Perera", 41, "0755566778", "Hypertension");

        System.out.println("===== All Patients (In-Order Traversal) =====");
        bst.inOrderTraversal();

        System.out.println("===== Searching for Patient ID 204 =====");
        Patient found = bst.search(204);
        if (found != null) {
            found.displayDetails();
        } else {
            System.out.println("Patient not found.");
        }

        System.out.println("===== Deleting Patient ID 207 =====");
        bst.delete(207);

        System.out.println("===== All Patients After Deletion =====");
        bst.inOrderTraversal();

        System.out.println("===== Searching for Deleted Patient ID 207 =====");
        Patient deletedSearch = bst.search(207);
        if (deletedSearch != null) {
            deletedSearch.displayDetails();
        } else {
            System.out.println("Patient not found.");
        }

        // ===================== QUEUE DEMO =====================
        System.out.println("\n\n===== Emergency Patient Queue Demo =====");

        EmergencyQueue queue = new EmergencyQueue(10);

        // Enqueue patients
        queue.enqueue(new Patient(301, "Nadeesha Kumari", 24, "0766677889", "Severe Chest Pain"));
        queue.enqueue(new Patient(302, "Ashan Bandara", 47, "0777788990", "Broken Arm"));
        queue.enqueue(new Patient(303, "Thilini Gunasekara", 16, "0788899001", "High Fever"));

        System.out.println("\n----- Current Waiting Queue -----");
        queue.displayQueue();

        System.out.println("\n----- Dequeue (Next Patient for Treatment) -----");
        Patient nextPatient = queue.dequeue();
        if (nextPatient != null) {
            System.out.println("Now treating: " + nextPatient.name);
        }

        System.out.println("\n----- Queue After Dequeue -----");
        queue.displayQueue();

        System.out.println("\n----- Emptying the Queue -----");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // this should show "Queue is empty" message
    }
}
