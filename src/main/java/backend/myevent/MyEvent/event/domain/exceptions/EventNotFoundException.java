package backend.myevent.MyEvent.event.domain.exceptions;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Long aLong) {
        super("Course with id " + aLong + " not found");
    }
}
