package backend.myevent.MyEvent.event.domain.services;

import backend.myevent.MyEvent.event.domain.model.aggregates.Event;
import backend.myevent.MyEvent.event.domain.model.queries.GetAllEventsQuery;
import backend.myevent.MyEvent.event.domain.model.queries.GetEventByIdQuery;

import java.util.List;
import java.util.Optional;

public interface EventQueryService {
    Optional<Event> handle(GetEventByIdQuery query);
    List<Event> handle(GetAllEventsQuery query);
}
