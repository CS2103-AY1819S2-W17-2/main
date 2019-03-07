package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import seedu.address.logic.parser.AddCommandParser;

/**
 * Represents a Person's Nric in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidNric(String)}
 */
public class Nric {

    public static final String MESSAGE_CONSTRAINTS =
        "Nric should contain only \"-\" or \"XdddddddX\"";
    public static final String VALIDATION_REGEX = "^[STFG]\\d{7}[A-Z]$";
    public final String value;

    /**
     * Constructs a {@code Nric}.
     *
     * @param nric A valid Nric number.
     */
    public Nric(String nric) {
        requireNonNull(nric);
        checkArgument(isValidNric(nric), MESSAGE_CONSTRAINTS + " , provided: " + nric);
        value = nric;
    }

    /**
     * Returns true if a given string is a valid Nric number, or intentionally left empty (-).
     * @param test the string to be tested.
     */
    private static boolean isValidNric(String test) {
        requireNonNull(test);
        if (test.equals(AddCommandParser.DEFAULT_NRIC)) {
            return true;
        } else {
            return test.matches(VALIDATION_REGEX);
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof Nric // instanceof handles nulls
            && value.equals(((Nric) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
