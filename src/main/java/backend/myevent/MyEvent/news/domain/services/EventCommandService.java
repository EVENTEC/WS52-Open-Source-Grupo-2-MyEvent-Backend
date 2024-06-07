package backend.myevent.MyEvent.news.domain.services;

import backend.myevent.MyEvent.news.domain.model.aggregates.Event;
import backend.myevent.MyEvent.news.domain.model.commands.CreateEventCommand;
import backend.myevent.MyEvent.news.domain.model.commands.DeleteEventCommand;
import backend.myevent.MyEvent.news.domain.model.commands.UpdateEventCommand;

import java.util.Optional;

public interface EventCommandService {
    Optional<Event> handle(CreateEventCommand command);
    void handle(DeleteEventCommand command);
    Optional<Event> handle(UpdateEventCommand command);
}