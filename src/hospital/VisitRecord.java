package hospital;

public class VisitRecord {
    int visitId;
    int patientId;
    String patientName;
    String visitDate;
    String doctorName;
    String diagnosis;
    String treatment;

    public VisitRecord(int visitId, int patientId, String patientName, String visitDate,
                        String doctorName, String diagnosis, String treatment) {
        this.visitId = visitId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public void displayDetails() {
        System.out.println("Visit ID: " + visitId + " | Patient ID: " + patientId
                + " | Name: " + patientName + " | Date: " + visitDate
                + " | Doctor: " + doctorName + " | Diagnosis: " + diagnosis
                + " | Treatment: " + treatment);
    }
}
