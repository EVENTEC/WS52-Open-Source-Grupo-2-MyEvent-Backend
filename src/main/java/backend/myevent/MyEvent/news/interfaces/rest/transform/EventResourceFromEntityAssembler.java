package backend.myevent.MyEvent.news.interfaces.rest.transform;

import backend.myevent.MyEvent.news.domain.model.aggregates.Event;
import backend.myevent.MyEvent.news.domain.model.aggregates.User;
import backend.myevent.MyEvent.news.interfaces.rest.resources.EventResource;
import backend.myevent.MyEvent.news.interfaces.rest.resources.UserResource;

public class EventResourceFromEntityAssembler {
    public static EventResource toResourceFromEntity(Event entity) {
        return new EventResource(
                entity.getName(),
                entity.getDate(),
                entity.getOrganizer(),
                entity.getLocation(),
                entity.getResale(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getCapacity(),
                entity.getImage(),
                entity.getCategory(),
                entity.getEventApiKey());
    }
}
