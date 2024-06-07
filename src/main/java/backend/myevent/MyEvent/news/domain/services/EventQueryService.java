package backend.myevent.MyEvent.news.domain.services;

import backend.myevent.MyEvent.news.domain.model.aggregates.Event;
import backend.myevent.MyEvent.news.domain.model.aggregates.User;
import backend.myevent.MyEvent.news.domain.model.queries.*;

import java.util.Optional;
import java.util.List;

public interface EventQueryService {
    List<Event> handle(GetAllEventsQuery query);
    List<Event> handle(GetAllEventByEventApiKeyQuery query);
    Optional<Event> handle(GetEventByIdQuery query);
    Optional<Event> handle(GetEventByNameAndOrganizerQuery query);
    Optional<Event> handle(GetEventByNameQuery query);

    //
}
