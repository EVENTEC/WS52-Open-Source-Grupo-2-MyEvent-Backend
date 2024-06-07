package backend.myevent.MyEvent.news.domain.model.queries;

public record GetAllEventByEventApiKeyQuery(String eventApiKey) {
    public GetAllEventByEventApiKeyQuery {
        if (eventApiKey == null || eventApiKey.isBlank()) {
            throw new IllegalArgumentException("API Key cannot be null or empty");
        }
    }
}
