package hospital;

/**
 * Represents a completed treatment record.
 * Pushed onto the TreatmentStack once a patient's treatment is finished.
 */
public class TreatmentRecord {
    int patientId;
    String patientName;
    String treatmentDetails;
    String completionDate;

    public TreatmentRecord(int patientId, String patientName, String treatmentDetails, String completionDate) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentDetails = treatmentDetails;
        this.completionDate = completionDate;
    }

    public void displayDetails() {
        System.out.println("Patient ID: " + patientId +
                " | Name: " + patientName +
                " | Treatment: " + treatmentDetails +
                " | Completed: " + completionDate);
    }
}
