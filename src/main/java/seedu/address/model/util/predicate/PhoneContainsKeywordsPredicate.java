package seedu.address.model.util.predicate;

import java.util.List;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.person.Person;

/**
 * Tests that a {@code Person}'s {@code Phone} matches any of the keywords given.
 */
public class PhoneContainsKeywordsPredicate extends ContainsKeywordsPredicate<Person> {

    public PhoneContainsKeywordsPredicate(List<String> keywords) {
        super(keywords);
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream().anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getPhone().toString(),
         keyword));
    }
}
