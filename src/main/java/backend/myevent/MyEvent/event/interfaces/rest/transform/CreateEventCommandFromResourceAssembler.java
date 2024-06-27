package backend.myevent.MyEvent.event.interfaces.rest.transform;


import backend.myevent.MyEvent.event.domain.model.commands.CreateEventCommand;
import backend.myevent.MyEvent.event.interfaces.rest.resources.CreateEventResource;

import java.util.Date;

public class CreateEventCommandFromResourceAssembler {
    public static CreateEventCommand toCommandFromResource(CreateEventResource resource) {
        return new CreateEventCommand(resource.title(), resource.description());
    }
}
