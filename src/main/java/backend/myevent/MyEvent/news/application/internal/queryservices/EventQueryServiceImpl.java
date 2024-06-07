package backend.myevent.MyEvent.news.application.internal.queryservices;

import backend.myevent.MyEvent.news.domain.model.aggregates.Event;
import backend.myevent.MyEvent.news.domain.model.queries.*;
import backend.myevent.MyEvent.news.domain.services.EventQueryService;
import backend.myevent.MyEvent.news.infraestructure.persistence.jpa.EventSourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventQueryServiceImpl implements EventQueryService {
    private final EventSourceRepository eventSourceRepository;

    public EventQueryServiceImpl(EventSourceRepository eventSourceRepository) {
        this.eventSourceRepository = eventSourceRepository;
    }

    @Override
    public List<Event> handle(GetAllEventsQuery query){
        return eventSourceRepository.findAll();
    }

    @Override
    public List<Event> handle(GetAllEventByEventApiKeyQuery query) {
        return eventSourceRepository.findAllByEventApiKey(query.eventApiKey());
    }

    @Override
    public Optional<Event> handle(GetEventByIdQuery query) {
        return eventSourceRepository.findById(query.id());
    }

    @Override
    public Optional<Event> handle(GetEventByNameQuery query) {
        return eventSourceRepository.findByName(query.name());
    }

    @Override
    public Optional<Event> handle(GetEventByNameAndOrganizerQuery query) {
        return eventSourceRepository.findByNameAndOrganizer(query.name(), query.organizer());
    }
}
