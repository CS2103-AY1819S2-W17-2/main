package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STARTDATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ENDDATE;

import java.util.Set;
import java.util.stream.Stream;

import seedu.address.logic.commands.TaskAddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.task.Task;
import seedu.address.model.datetime.DateCustom;
import seedu.address.model.task.Title;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<TaskAddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public TaskAddCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_TITLE, PREFIX_STARTDATE, PREFIX_ENDDATE);

        if (!arePrefixesPresent(argMultimap, PREFIX_TITLE, PREFIX_STARTDATE, PREFIX_ENDDATE) ||
                !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, TaskAddCommand.MESSAGE_USAGE));
        }

        Title title = ParserUtil.parseTitle(argMultimap.getValue(PREFIX_NAME).get());
        DateCustom startDate = ParserUtil.parseDate(argMultimap.getValue(PREFIX_PHONE).get());
        DateCustom endDate = ParserUtil.parseDate(argMultimap.getValue(PREFIX_PHONE).get());

        return new TaskAddCommand(patient);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
