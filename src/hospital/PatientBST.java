package hospital;

/**
 * Binary Search Tree (BST) that stores Patient records keyed on Patient ID.
 * Supports: insert, search, delete, in-order traversal (ascending Patient ID).
 */
public class PatientBST {

    private class Node {
        Patient patient;
        Node left, right;

        Node(Patient patient) {
            this.patient = patient;
        }
    }

    private Node root;

    // Insert a new patient given individual details
    public void insert(int id, String name, int age, String contact, String condition) {
        Patient newPatient = new Patient(id, name, age, contact, condition);
        root = insertRec(root, newPatient);
    }

    private Node insertRec(Node node, Patient patient) {
        if (node == null) {
            return new Node(patient);
        }
        if (patient.id < node.patient.id) {
            node.left = insertRec(node.left, patient);
        } else if (patient.id > node.patient.id) {
            node.right = insertRec(node.right, patient);
        } else {
            System.out.println("A patient with ID " + patient.id + " already exists.");
        }
        return node;
    }

    // Search for a patient by ID
    public Patient search(int id) {
        Node result = searchRec(root, id);
        return (result == null) ? null : result.patient;
    }

    private Node searchRec(Node node, int id) {
        if (node == null || node.patient.id == id) {
            return node;
        }
        if (id < node.patient.id) {
            return searchRec(node.left, id);
        }
        return searchRec(node.right, id);
    }

    // Delete a patient by ID
    public void delete(int id) {
        if (search(id) == null) {
            System.out.println("No patient found with ID " + id + " to delete.");
            return;
        }
        root = deleteRec(root, id);
        System.out.println("Patient with ID " + id + " deleted.");
    }

    private Node deleteRec(Node node, int id) {
        if (node == null) return null;

        if (id < node.patient.id) {
            node.left = deleteRec(node.left, id);
        } else if (id > node.patient.id) {
            node.right = deleteRec(node.right, id);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node successor = findMin(node.right);
                node.patient = successor.patient;
                node.right = deleteRec(node.right, successor.patient.id);
            }
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // In-order traversal: displays patients in ascending Patient ID order
    public void inOrderTraversal() {
        if (root == null) {
            System.out.println("No patient records found.");
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            node.patient.displayDetails();
            inOrderRec(node.right);
        }
    }
}
