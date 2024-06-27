package backend.myevent.MyEvent.event.application.internal.queryservices;

import backend.myevent.MyEvent.event.domain.model.aggregates.Event;
import backend.myevent.MyEvent.event.domain.model.queries.GetAllEventsQuery;
import backend.myevent.MyEvent.event.domain.model.queries.GetEventByIdQuery;
import backend.myevent.MyEvent.event.domain.services.EventQueryService;

import backend.myevent.MyEvent.event.infrastructure.persistence.jpa.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventQueryServiceImpl implements EventQueryService {

    private final EventRepository eventRepository;

    public EventQueryServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Optional<Event> handle(GetEventByIdQuery query) {
        return eventRepository.findById(query.eventId());
    }

    @Override
    public List<Event> handle(GetAllEventsQuery query) {
        return eventRepository.findAll();
    }
}
