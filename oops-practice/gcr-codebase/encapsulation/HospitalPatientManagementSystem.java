public class HospitalPatientManagementSystem {
    public static void main(String[] args) {
        InPatient inPatient = new InPatient();
        inPatient.setPatientId(1);
        inPatient.setName("Rahul");
        inPatient.setAge(30);
        inPatient.setRoomCharges(5000);
        inPatient.setTreatmentCharges(2000);

        OutPatient outPatient = new OutPatient();
        outPatient.setPatientId(2);
        outPatient.setName("Anita");
        outPatient.setAge(25);
        outPatient.setConsultationFees(500);
        outPatient.setTreatmentCharges(1500);

        displayPatient(inPatient);
        displayPatient(outPatient);
    }

    private static void displayPatient(Patient patient) {
        patient.displayPatientDetails();
        System.out.println("Bill: " + patient.calculateBill());
        System.out.println();
    }
}

abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract double calculateBill();
}

class InPatient extends Patient {
    private double roomCharges;
    private double treatmentCharges;

    public double getRoomCharges() {
        return roomCharges;
    }

    public void setRoomCharges(double roomCharges) {
        this.roomCharges = roomCharges;
    }

    public double getTreatmentCharges() {
        return treatmentCharges;
    }

    public void setTreatmentCharges(double treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    public double calculateBill() {
        return roomCharges + treatmentCharges;
    }
}

class OutPatient extends Patient {
    private double consultationFees;
    private double treatmentCharges;

    public double getConsultationFees() {
        return consultationFees;
    }

    public void setConsultationFees(double consultationFees) {
        this.consultationFees = consultationFees;
    }

    public double getTreatmentCharges() {
        return treatmentCharges;
    }

    public void setTreatmentCharges(double treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    public double calculateBill() {
        return consultationFees + treatmentCharges;
    }
}
