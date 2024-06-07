package backend.myevent.MyEvent.news.application.internal.commandservices;

import backend.myevent.MyEvent.news.domain.model.aggregates.Event;
import backend.myevent.MyEvent.news.domain.model.commands.CreateEventCommand;
import backend.myevent.MyEvent.news.domain.model.commands.DeleteEventCommand;
import backend.myevent.MyEvent.news.domain.model.commands.UpdateEventCommand;
import backend.myevent.MyEvent.news.domain.services.EventCommandService;
import backend.myevent.MyEvent.news.infraestructure.persistence.jpa.EventSourceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventCommandServiceImpl implements EventCommandService{
    private final EventSourceRepository eventSourceRepository;

    public EventCommandServiceImpl(EventSourceRepository eventSourceRepository) {
        this.eventSourceRepository = eventSourceRepository;
    }

    @Override
    public Optional<Event> handle(CreateEventCommand command) {
        if (eventSourceRepository.existsByNameAndOrganizer(command.name(), command.organizer())){
            throw new IllegalArgumentException("Event already exists");
        }
        Event event = new Event(command);
        eventSourceRepository.save(event);
        return Optional.of(event);
    }

    @Override
    public void handle(DeleteEventCommand command){
        eventSourceRepository.deleteById(command.id());
    }

    @Override
    public Optional<Event> handle(UpdateEventCommand command){
        Optional<Event> eventOptional = eventSourceRepository.findById(command.id());
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            event.update(command);
            eventSourceRepository.save(event);
            return Optional.of(event);
        } else {
            return Optional.empty();
        }
    }
}
