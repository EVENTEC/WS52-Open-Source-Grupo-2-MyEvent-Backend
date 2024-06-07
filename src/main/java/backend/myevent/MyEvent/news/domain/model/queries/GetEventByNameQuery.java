package backend.myevent.MyEvent.news.domain.model.queries;

public record GetEventByNameQuery(String name) {
    public GetEventByNameQuery {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }
}
