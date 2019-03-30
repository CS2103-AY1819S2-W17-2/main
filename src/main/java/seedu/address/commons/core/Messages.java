package seedu.address.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_INVALID_RECORD_DISPLAYED_INDEX = "The record index provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_INVALID_TASK_DISPLAYED_INDEX = "The task index provided is invalid";
    public static final String MESSAGE_DUPLICATE_TASK = "An exact same task is already found in the records";
    public static final String MESSAGE_DATE_CLASH = "The task's start date should not be after its end date";
    public static final String MESSAGE_TIME_CLASH = "The tasks start time should not be before its end time if"
                                                 + " its' start date is the same as its end date.";
    public static final String MESSAGE_INVALID_FILE_TYPE = "Invalid file type!";
    public static final String MESSAGE_ONLY_GO_TO_MODE_COMMANDS = "This command can only be used in patient mode "
                                                                + "to return to patient mode, use the back command";
    public static final String MESSAGE_ONLY_TASK_OR_DATE_COMMANDS = "This command cannot be ran here. Only task related"
                                                                + " commands and dates should be enteredit com here.";
    public static final String MESSAGE_IN_GO_TO_MODE = "Please exit the goto mode using the back command first";
    public static final String MESSAGE_IN_PATIENT_MODE = "Patient list is already shown";
    public static final String MESSAGE_NOTHING_DONE = "Cancelled, nothing has been done";
    public static final String MESSAGE_CALENDAR_SHOWN = "Task Calendar is already displayed";
}
