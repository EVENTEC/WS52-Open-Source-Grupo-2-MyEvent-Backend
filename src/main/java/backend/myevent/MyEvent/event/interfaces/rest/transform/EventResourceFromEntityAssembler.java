package backend.myevent.MyEvent.event.interfaces.rest.transform;

import backend.myevent.MyEvent.event.domain.model.aggregates.Event;
import backend.myevent.MyEvent.event.interfaces.rest.resources.EventResource;

public class EventResourceFromEntityAssembler {
    public static EventResource toResourceFromEntity(Event entity) {
        return new EventResource(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getCategory(),
                entity.getLocation(),
                entity.getOrganizer(),
                entity.getTotalTickets(),
                entity.getPriceTicket()
        );
    }
}
