package backend.myevent.MyEvent.event.interfaces.rest.transform;


import backend.myevent.MyEvent.event.domain.model.commands.UpdateEventCommand;
import backend.myevent.MyEvent.event.domain.model.commands.UpdateEventCommandWithoutDates;
import backend.myevent.MyEvent.event.interfaces.rest.resources.UpdateEventResource;
import backend.myevent.MyEvent.event.interfaces.rest.resources.UpdateEventWithoutDatesResource;

import java.util.Date;

public class UpdateEventCommandFromResourceAssembler {
    public static UpdateEventCommand toCommandFromResource(UpdateEventResource resource) {
        Long id = resource.id();
        String eventName = resource.title();
        String eventDescription = resource.description();
        Date eventStartDate = resource.eventStartDate();
        Date eventEndDate = resource.eventEndDate();
        return new UpdateEventCommand(id, eventName, eventDescription, eventStartDate, eventEndDate);
    }
    public static UpdateEventCommandWithoutDates toCommandFromResource(UpdateEventWithoutDatesResource resource) {
        Long id = resource.id();
        String eventName = resource.title();
        String eventDescription = resource.description();
        return new UpdateEventCommandWithoutDates(id, eventName, eventDescription);
    }
}
