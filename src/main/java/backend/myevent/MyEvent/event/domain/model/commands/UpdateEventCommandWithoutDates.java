package backend.myevent.MyEvent.event.domain.model.commands;

public record UpdateEventCommandWithoutDates(Long id, String eventName, String eventDescription) {
}
