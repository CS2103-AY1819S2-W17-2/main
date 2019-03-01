package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import seedu.address.MainApp;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.storage.AddressBookStorage;
import seedu.address.storage.JsonAddressBookStorage;
import seedu.address.storage.StorageManager;

/**
 * Exports records to a text file.
 */
public class ExportCommand extends Command {

    public static final String COMMAND_WORD = "export";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Exports to text file in the \"data\" folder \n"
            + "Parameters: FILENAME\n"
            + "Example: " + COMMAND_WORD + " records1.json";

    public static final String MESSAGE_SUCCESS = "Exported the records!";
    private static final String MESSAGE_FAILURE = "Problem while writing to the file.";

    private final File file;

    public ExportCommand(File file) {
        this.file = file;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        requireNonNull(model);
        writeFile(model);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }

    private void writeFile(Model model) {
        AddressBookStorage addressBookStorage = new JsonAddressBookStorage(file.toPath());

        StorageManager storage = new StorageManager(addressBookStorage, null);

        final Logger logger = LogsCenter.getLogger(MainApp.class);

        try {
            storage.saveAddressBook(model.getAddressBook(), file.toPath());
        } catch (IOException e) {
            logger.warning(MESSAGE_FAILURE);
        }
    }
}
