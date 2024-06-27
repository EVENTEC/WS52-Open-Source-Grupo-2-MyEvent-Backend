package backend.myevent.MyEvent.event.domain.services;

import backend.myevent.MyEvent.event.domain.model.aggregates.Event;
import backend.myevent.MyEvent.event.domain.model.commands.CreateEventCommand;
import backend.myevent.MyEvent.event.domain.model.commands.DeleteEventCommand;
import backend.myevent.MyEvent.event.domain.model.commands.UpdateEventCommand;
import backend.myevent.MyEvent.event.domain.model.commands.UpdateEventCommandWithoutDates;

import java.util.Optional;

public interface EventCommandService {
    Long handle(CreateEventCommand command);
    Optional<Event> handle(UpdateEventCommand command);
    Optional<Event> handle(UpdateEventCommandWithoutDates command);
    void handle(DeleteEventCommand command);
}
