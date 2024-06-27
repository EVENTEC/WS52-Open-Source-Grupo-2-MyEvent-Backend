package backend.myevent.MyEvent.event.interfaces.rest;

import backend.myevent.MyEvent.event.domain.model.commands.CreateEventCommand;
import backend.myevent.MyEvent.event.domain.model.commands.DeleteEventCommand;
import backend.myevent.MyEvent.event.domain.model.queries.GetAllEventsQuery;
import backend.myevent.MyEvent.event.domain.model.queries.GetEventByIdQuery;
import backend.myevent.MyEvent.event.domain.services.EventCommandService;
import backend.myevent.MyEvent.event.domain.services.EventQueryService;
import backend.myevent.MyEvent.event.interfaces.rest.resources.CreateEventResource;
import backend.myevent.MyEvent.event.interfaces.rest.resources.EventResource;
import backend.myevent.MyEvent.event.interfaces.rest.resources.UpdateEventResource;
import backend.myevent.MyEvent.event.interfaces.rest.resources.UpdateEventWithoutDatesResource;
import backend.myevent.MyEvent.event.interfaces.rest.transform.CreateEventCommandFromResourceAssembler;
import backend.myevent.MyEvent.event.interfaces.rest.transform.EventResourceFromEntityAssembler;
import backend.myevent.MyEvent.event.interfaces.rest.transform.UpdateEventCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/events", produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class EventsController {
    private final EventCommandService eventCommandService;
    private final EventQueryService eventQueryService;

    public EventsController(EventCommandService eventCommandService, EventQueryService eventQueryService) {
        this.eventCommandService = eventCommandService;
        this.eventQueryService = eventQueryService;
    }

    @PostMapping
    public ResponseEntity<EventResource> createEvent(@RequestBody CreateEventResource resource) {
        CreateEventCommand command = CreateEventCommandFromResourceAssembler.toCommandFromResource(resource);
        var eventId = eventCommandService.handle(command);
        if (eventId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getEventByIdQuery = new GetEventByIdQuery(eventId);
        var event = eventQueryService.handle(getEventByIdQuery);
        if (event.isEmpty()) return ResponseEntity.badRequest().build();
        var eventResource = EventResourceFromEntityAssembler.toResourceFromEntity(event.get());
        return new ResponseEntity<>(eventResource, HttpStatus.CREATED);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventResource> getEventById(@PathVariable Long eventId) {
        var getEventByIdQuery = new GetEventByIdQuery(eventId);
        var event = eventQueryService.handle(getEventByIdQuery);
        if (event.isEmpty()) return ResponseEntity.badRequest().build();
        var eventResource = EventResourceFromEntityAssembler.toResourceFromEntity(event.get());
        return ResponseEntity.ok(eventResource);
    }

    @GetMapping
    public ResponseEntity<List<EventResource>> getAllEvents() {
        var getAllEventsQuery = new GetAllEventsQuery();
        var events = eventQueryService.handle(getAllEventsQuery);
        var eventResources = events.stream().map(EventResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(eventResources);
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<EventResource> updateEvent(@PathVariable Long eventId, @RequestBody UpdateEventResource resource) {
        var updateEventCommand = UpdateEventCommandFromResourceAssembler.toCommandFromResource(resource);
        var updatedEvent = eventCommandService.handle(updateEventCommand);
        if (updatedEvent.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var eventResource = EventResourceFromEntityAssembler.toResourceFromEntity(updatedEvent.get());
        return ResponseEntity.ok(eventResource);
    }

    @PutMapping("/{eventId}/without-dates")
    public ResponseEntity<EventResource> updateEventWithoutDates(@PathVariable Long eventId, @RequestBody UpdateEventWithoutDatesResource resource) {
        var updateEventCommand = UpdateEventCommandFromResourceAssembler.toCommandFromResource(resource);
        var updatedEvent = eventCommandService.handle(updateEventCommand);
        if (updatedEvent.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var eventResource = EventResourceFromEntityAssembler.toResourceFromEntity(updatedEvent.get());
        return ResponseEntity.ok(eventResource);
    }


    @DeleteMapping("/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId) {
        var deleteEventCommand = new DeleteEventCommand(eventId);
        eventCommandService.handle(deleteEventCommand);
        return ResponseEntity.ok("Event with given id successfully deleted");
    }
}
