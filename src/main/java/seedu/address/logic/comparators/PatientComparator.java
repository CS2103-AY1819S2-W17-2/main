package seedu.address.logic.comparators;

import java.util.Comparator;

import seedu.address.model.patient.Patient;

/**
 * Contains comparators for each patient attribute
 */
public class PatientComparator {

    /**
     * Comparator to sort via Name
     */
    private static Comparator<Patient> compPatientName = new Comparator<Patient>() {
        @Override
        public int compare(Patient p1, Patient p2) {
            return p1.getName().toString().compareTo(p2.getName().toString());
        }
    };

    /**
     * Comparator to sort via Phone number
     */
    private static Comparator<Patient> compPatientPhone = new Comparator<Patient>() {
        @Override
        public int compare(Patient p1, Patient p2) {
            return p1.getPhone().toString().compareTo(p2.getPhone().toString());
        }
    };

    /**
     * Comparator to sort via Email.
     */
    private static Comparator<Patient> compPatientEmail = new Comparator<Patient>() {
        @Override
        public int compare(Patient p1, Patient p2) {
            return p1.getEmail().toString().compareTo(p2.getEmail().toString());
        }
    };

    /**
     * Comparator to sort via Address.
     */
    private static Comparator<Patient> compPatientAddress = new Comparator<Patient>() {
        @Override
        public int compare(Patient p1, Patient p2) {
            return p1.getAddress().toString().compareTo(p2.getAddress().toString());
        }
    };

    /**
     * Comparator to sort via Nric.
     */
    private static Comparator<Patient> compPatientNric = new Comparator<Patient>() {
        @Override
        public int compare(Patient p1, Patient p2) {
            return p1.getNric().toString().compareTo(p2.getNric().toString());
        }
    };

    /**
     * Comparator to sort via Date of Birth.
     */
    private static Comparator<Patient> compPatientDob = new Comparator<Patient>() {
        @Override
        public int compare(Patient p1, Patient p2) {
            return p1.getDateOfBirth().getDate().compareTo(p2.getDateOfBirth().getDate());
        }
    };

    public static Comparator<Patient> getPatientComparator(String parameterType) {
        //TODO: Implement parameter checking

        return null;
    }

}
