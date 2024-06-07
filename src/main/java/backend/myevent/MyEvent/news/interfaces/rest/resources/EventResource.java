package backend.myevent.MyEvent.news.interfaces.rest.resources;

import java.util.Date;

public record EventResource(String name, String date, String organizer, String location, Boolean resale, String description, Double price, Integer capacity, String image, String category, String eventApiKey){
}

