package backend.myevent.MyEvent.news.interfaces.rest;

import backend.myevent.MyEvent.news.domain.model.aggregates.Event;
import backend.myevent.MyEvent.news.domain.model.commands.DeleteEventCommand;
import backend.myevent.MyEvent.news.domain.model.commands.UpdateEventCommand;
import backend.myevent.MyEvent.news.domain.model.queries.GetAllEventsQuery;
import backend.myevent.MyEvent.news.domain.model.queries.GetEventByIdQuery;
import backend.myevent.MyEvent.news.domain.model.queries.GetEventByNameAndOrganizerQuery;
import backend.myevent.MyEvent.news.domain.model.queries.GetEventByNameQuery;
import backend.myevent.MyEvent.news.domain.services.EventCommandService;
import backend.myevent.MyEvent.news.domain.services.EventQueryService;
import backend.myevent.MyEvent.news.interfaces.rest.resources.CreateEventResource;
import backend.myevent.MyEvent.news.interfaces.rest.resources.EventResource;
import backend.myevent.MyEvent.news.interfaces.rest.transform.CreateEventCommandFromResourceAssembler;
import backend.myevent.MyEvent.news.interfaces.rest.transform.EventResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/events")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {

    private final EventCommandService eventCommandService;
    private final EventQueryService eventQueryService;

    public EventController(EventCommandService eventCommandService, EventQueryService eventQueryService) {
        this.eventCommandService = eventCommandService;
        this.eventQueryService = eventQueryService;
    }


    // @PostMapping("/create")
    @PostMapping("/create")
    public ResponseEntity<EventResource> createEvent(@RequestBody CreateEventResource resource) {
        Optional<Event> eventSource = eventCommandService.handle(CreateEventCommandFromResourceAssembler.toCommandFromResource(resource));
        return eventSource.map(source -> new ResponseEntity<>(EventResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    // @GetMapping("/{id}")
    @GetMapping("/{id}")
    public ResponseEntity<EventResource> getEventById(@PathVariable Long id) {
        Optional<Event> eventSource = eventQueryService.handle(new GetEventByIdQuery(id));
        return eventSource.map(source -> ResponseEntity.ok(EventResourceFromEntityAssembler.toResourceFromEntity(source))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // @GetMapping
    @GetMapping
    public ResponseEntity<List<EventResource>> getAllEvents() {
        List<Event> eventSources = eventQueryService.handle(new GetAllEventsQuery());
        List<EventResource> eventResources = eventSources.stream()
                .map(EventResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(eventResources);
    }

    // @GetMapping("/name/{name}")
    @GetMapping("/name/{name}")
    public ResponseEntity<EventResource> getEventByName(@PathVariable String name) {
        Optional<Event> eventSource = eventQueryService.handle(new GetEventByNameQuery(name));
        return eventSource.map(source -> ResponseEntity.ok(EventResourceFromEntityAssembler.toResourceFromEntity(source))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // @GetMapping("/name/{name}/organizer/{organizer}")
    @GetMapping("/name/{name}/organizer/{organizer}")
    public ResponseEntity<EventResource> getEventByNameAndOrganizer(@PathVariable String name, @PathVariable String organizer) {
        Optional<Event> eventSource = eventQueryService.handle(new GetEventByNameAndOrganizerQuery(name, organizer));
        return eventSource.map(source -> ResponseEntity.ok(EventResourceFromEntityAssembler.toResourceFromEntity(source))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // @DeleteMapping("/{id}")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventCommandService.handle(new DeleteEventCommand(id));
        return ResponseEntity.noContent().build();
    }

    // @PutMapping("/{id}")
    @PutMapping("/{id}")
    public ResponseEntity<EventResource> updateEvent(@PathVariable Long id, @RequestBody CreateEventResource resource) {
        UpdateEventCommand command = new UpdateEventCommand(id, resource.name(), resource.date(), resource.organizer(), resource.location(), resource.resale(), resource.description(), resource.price(), resource.capacity(), resource.image(), resource.category(), resource.eventApiKey());
        Optional<Event> eventSource = eventCommandService.handle(command);
        return eventSource.map(source -> ResponseEntity.ok(EventResourceFromEntityAssembler.toResourceFromEntity(source))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

/*

{
  "name": "Concierto de Rock",
  "date": "2024-06-15",
  "organizer": "Rock Productions",
  "location": "Estadio Central",
  "resale": true,
  "description": "¡Ven y disfruta de una noche llena de música rockera!",
  "price": 25.99,
  "capacity": 1000,
  "image": "https://ejemplo.com/imagen.jpg",
  "category": "Conciertos",
  "eventApiKey": "tu_clave_de_API"
}
**/