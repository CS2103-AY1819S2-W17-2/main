package seedu.address.model.datetime;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.text.ParseException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;





/**
 * Represents a date.
 * Guarantees: immutable; is valid as declared in {@link #isValidDate(String)}
 */
public class DateCustom {
    public static final String MESSAGE_CONSTRAINTS = "Date should not be before today's date, End Date should not"
                                                   + " be before Start Date and a valid date should"
                                                   + " be in the form of dd-mm-yyyy";

    public static final String VALIDATION_REGEX = "^(((0[1-9]|[1-2][0-9]|3[0,1])-(01|03|05|07|08|10|12))|"
                                                + "((0[1-9]|[1-2][0-9]|30)-(04|06|09|11))|((0[1-9]|[1-2]["
                                                + "0-9])-(02)))-(\\d{4})$";

    private final String storedDate;

    /**
     * Constructs a {@code DateCustom}
     *
     * @param date A valid date
     */
    public DateCustom(String date) {
        requireNonNull(date);
        checkArgument(isValidDate(date), MESSAGE_CONSTRAINTS);
        storedDate = date;
    }


    public static String getFormat() {
        return "dd-MM-yyyy";
    }

    public static boolean isValidDate(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     *  Returns false if the given date is before the current date
     * @param test the date to be tested
     * @throws ParseException
     */
    public static boolean isDateBeforeToday(String test) {
        String currentDateString = LocalDate.now().format(DateTimeFormatter.ofPattern(getFormat()));
        return dateCompare(test, currentDateString);
    }

    public static boolean isEndDateBeforeStartDate(String format, String date1, String date2) {
        return dateCompare(date2, date1);
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate storedDate = LocalDate.parse(this.toString());
        return Period.between(storedDate, currentDate).getYears();
    }

    public LocalDate getDate() {
        return LocalDate.parse(storedDate);
    }
    /**
     *  Returns true if the first date given is before the second date given
     * @param date1 the first date to comapre with the second date
     * @param date2 the second date
     * @return
     * @throws ParseException
     */
    public static boolean dateCompare(String date1, String date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getFormat());
        LocalDate firstDate = LocalDate.parse(date1, formatter);
        LocalDate secondDate = LocalDate.parse(date2, formatter);
        return firstDate.isBefore(secondDate);
    }

    @Override
    public String toString() {
        return storedDate;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof DateCustom // instanceof handles nulls
            && storedDate.equals(((DateCustom) other).storedDate)); // state check
    }

    @Override
    public int hashCode() {
        return storedDate.hashCode();
    }
}
