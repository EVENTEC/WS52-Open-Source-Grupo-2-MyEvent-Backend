package backend.myevent.MyEvent.event.domain.model.commands;

import java.util.Date;

public record UpdateEventCommand(Long id, String eventName, String eventDescription) {
}
