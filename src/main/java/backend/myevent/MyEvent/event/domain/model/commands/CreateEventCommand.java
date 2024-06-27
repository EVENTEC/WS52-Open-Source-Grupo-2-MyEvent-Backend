package backend.myevent.MyEvent.event.domain.model.commands;

import java.util.Date;

public record CreateEventCommand(String eventName, String eventDescription) {
}
