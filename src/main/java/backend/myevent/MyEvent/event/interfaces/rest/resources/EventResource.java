package backend.myevent.MyEvent.event.interfaces.rest.resources;

import backend.myevent.MyEvent.event.domain.model.aggregates.Location;
import backend.myevent.MyEvent.event.domain.model.aggregates.Organizer;

import java.util.Date;

public record EventResource(
        Long id,
        String name,
        String description,
        String category,
        Date startDate,
        Date endDate,
        Location location,
        Organizer organizer,
        int totalTickets,
        double priceTicket) {
}
