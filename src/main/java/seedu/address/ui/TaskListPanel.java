package seedu.address.ui;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.logging.Logger;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.task.Task;

/**
 * Panel containing the list of persons.
 */
public class TaskListPanel extends UiPart<Region> {
    private static final String FXML = "TaskListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    @FXML
    private ListView<Task> taskListView;

    public TaskListPanel(ObservableList<Task> personList, ObservableValue<Task> selectedPerson,
                           Consumer<Task> onSelectedPersonChange) {
        super(FXML);
        taskListView.setItems(personList);
        taskListView.setCellFactory(listView -> new TaskListViewCell());
        taskListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            logger.fine("Selection in person list panel changed to : '" + newValue + "'");
            onSelectedPersonChange.accept(newValue);
        });
        selectedPerson.addListener((observable, oldValue, newValue) -> {
            logger.fine("Selected person changed to: " + newValue);

            // Don't modify selection if we are already selecting the selected person,
            // otherwise we would have an infinite loop.
            if (Objects.equals(taskListView.getSelectionModel().getSelectedItem(), newValue)) {
                return;
            }

            if (newValue == null) {
                taskListView.getSelectionModel().clearSelection();
            } else {
                int index = taskListView.getItems().indexOf(newValue);
                taskListView.scrollTo(index);
                taskListView.getSelectionModel().clearAndSelect(index);
            }
        });
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class TaskListViewCell extends ListCell<Task> {
        @Override
        protected void updateItem(Task task, boolean empty) {
            super.updateItem(task, empty);

            if (empty || task == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new TaskCard(task, getIndex() + 1).getRoot());
            }
        }
    }

}
