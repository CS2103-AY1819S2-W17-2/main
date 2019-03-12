package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STARTDATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ENDDATE;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.task.Task;


/**
 * Adds a patient to the address book.
 */
public class TaskAddCommand extends Command {

    public static final String COMMAND_WORD = "taskadd";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a task to the address book. "
            + "Parameters: "
            + PREFIX_TITLE + "NAME "
            + PREFIX_STARTDATE + "NRIC "
            + PREFIX_ENDDATE + "DOB \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TITLE + "Teeth removal surgery"
            + PREFIX_STARTDATE + "20-12-2019"
            + PREFIX_ENDDATE + "20-13-2019 ";


    public static final String MESSAGE_SUCCESS = "New task added: %1$s";
    public static final String MESSAGE_DUPLICATE_TASK = "An exact same task is already found in the records";

    private final Task toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Task}
     * @param task the task to be added.
     */
    public TaskAddCommand(Task task) {
        requireNonNull(task);
        toAdd = task;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);

        if (model.hasTask(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_TASK);
        }

        model.addTask(toAdd);
        model.commitAddressBook();
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd.getTitle()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TaskAddCommand // instanceof handles nulls
                && toAdd.equals(((TaskAddCommand) other).toAdd));
    }
}
