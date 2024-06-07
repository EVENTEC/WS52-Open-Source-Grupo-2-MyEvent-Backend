package backend.myevent.MyEvent.news.interfaces.rest.resources;

import java.util.Date;

public record CreateEventResource(String name, String date, String organizer, String location, Boolean resale, String description, Double price, Integer capacity, String image, String category, String eventApiKey){

        public CreateEventResource {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("name cannot be null or empty");
            }
            if (date == null || date.isBlank()) {
                throw new IllegalArgumentException("date cannot be null");
            }
            if (organizer == null || organizer.isBlank()) {
                throw new IllegalArgumentException("organizer cannot be null or empty");
            }
            if (location == null || location.isBlank()) {
                throw new IllegalArgumentException("location cannot be null or empty");
            }
            if (resale == null) {
                throw new IllegalArgumentException("resale cannot be null");
            }
            if (description == null || description.isBlank()) {
                throw new IllegalArgumentException("description cannot be null or empty");
            }
            if (price == null) {
                throw new IllegalArgumentException("price cannot be null");
            }
            if (capacity == null) {
                throw new IllegalArgumentException("capacity cannot be null");
            }
            if (image == null || image.isBlank()) {
                throw new IllegalArgumentException("image cannot be null or empty");
            }
            if (category == null || category.isBlank()) {
                throw new IllegalArgumentException("category cannot be null or empty");
            }
            if (eventApiKey == null || eventApiKey.isBlank()) {
                throw new IllegalArgumentException("eventApiKey cannot be null or empty");
            }
        }
}