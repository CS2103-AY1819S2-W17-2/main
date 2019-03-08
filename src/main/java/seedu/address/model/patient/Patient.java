package seedu.address.model.patient;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.patient.exceptions.PersonIsNotPatient;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.record.Record;
import seedu.address.model.tag.Tag;

/**
 * Represents a patient which is extend from the Person class.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Patient extends Person {
    private static final String NONE = "none";
    private static final String CHILD = "child";
    private static final String ADULT = "adult";
    private Nric nric;
    private DateOfBirth dateOfBirth;
    private Teeth teeth = null;
    private boolean buildSpecified = false;
    private ArrayList<Record> records = new ArrayList<>();

    /**
     * Every field must be present and not null.
     */
    public Patient(Name name, Phone phone, Email email, Address address, Set<Tag> tags, Nric nric,
                   DateOfBirth dateOfBirth) {
        super(name, phone, email, address, tags);
        requireAllNonNull(nric, dateOfBirth);
        this.nric = nric;
        this.dateOfBirth = dateOfBirth;
        inferTeethBuild();
    }

    private Patient(Name name, Phone phone, Email email, Address address, Set<Tag> tags,
                   Person personToCopy, int copyCount, Nric nric, DateOfBirth dateOfBirth) {
        super(name, phone, email, address, tags, personToCopy, copyCount);
        requireAllNonNull(nric, dateOfBirth);
        this.nric = nric;
        this.dateOfBirth = dateOfBirth;
        inferTeethBuild();
    }

    /**
     * Adds a new medical record to a patient.
     * @param record the medical record to be added.
     */
    public void addRecord(Record record) {
        this.records.add(record);
    }

    /**
     * Age inferred teeth layout.
     * Takes in the age of the patient and infers the teeth build he/she has.
     */
    private void inferTeethBuild() {
        int age = getPatientAge();
        if (age < 2) {
            buildTeeth(NONE);
        } else if (age < 13) {
            buildTeeth(CHILD);
        } else {
            buildTeeth(ADULT);
        }
    }

    /**
     * User specified teeth layout.
     * Build a default none/child/adult teeth layout, according to the parameters.
     */
    private void specifyBuild(String teethLayout) {
        buildSpecified = true;
        buildTeeth(teethLayout);
    }

    /**
     * Build a default none/child/adult teeth layout, according to the parameters.
     */
    private void buildTeeth(String teethLayout) {
        teeth = new Teeth(teethLayout);
    }

    /**
     * Using the patient's year of birth and the current year, derive his or her age.
     * @return the age of the patient.
     */
    private int getPatientAge() {
        return dateOfBirth.getAge();
    }

    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }

    public Teeth getTeeth() {
        return teeth;
    }

    public Nric getNric() {
        return nric;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isBuildSpecified() {
        return buildSpecified;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    /**
     * Returns true if both patients has the same NRIC.
     */
    @Override
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson instanceof Patient) {
            return nric.equals(((Patient) otherPerson).getNric());
        } else {
            System.out.println(otherPerson);
            throw new PersonIsNotPatient();
        }
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, tags, nric, dateOfBirth, records);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" NRIC: ")
                .append(nric.getNric())
                .append(" Date of Birth: ")
                .append(dateOfBirth.getDate())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Address: ")
                .append(getAddress())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }
}
