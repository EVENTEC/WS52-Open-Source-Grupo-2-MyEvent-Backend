package backend.myevent.MyEvent.news.domain.model.queries;

public record GetEventByNameAndOrganizerQuery(String name, String organizer) {
    public GetEventByNameAndOrganizerQuery {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (organizer == null || organizer.isBlank()) {
            throw new IllegalArgumentException("Organizer cannot be null or empty");
        }
    }
}
