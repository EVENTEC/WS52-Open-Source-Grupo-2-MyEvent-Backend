package backend.myevent.MyEvent.news.domain.model.commands;

public record UpdateEventCommand(Long id, String name, String date, String organizer, String location, boolean resale, String description, double price, int capacity, String image, String category, String eventApiKey) {
}