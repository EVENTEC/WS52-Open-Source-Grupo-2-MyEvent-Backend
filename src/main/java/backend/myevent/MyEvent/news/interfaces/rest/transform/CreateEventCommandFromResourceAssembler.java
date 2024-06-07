package backend.myevent.MyEvent.news.interfaces.rest.transform;

import backend.myevent.MyEvent.news.domain.model.commands.CreateEventCommand;
import backend.myevent.MyEvent.news.interfaces.rest.resources.CreateEventResource;

public class CreateEventCommandFromResourceAssembler {

    public static CreateEventCommand toCommandFromResource(CreateEventResource resource) {
        return new CreateEventCommand(
            resource.name(),
            resource.date(),
            resource.organizer(),
            resource.location(),
            resource.resale(),
            resource.description(),
            resource.price(),
            resource.capacity(),
            resource.image(),
            resource.category(),
            resource.eventApiKey());
    }
}
