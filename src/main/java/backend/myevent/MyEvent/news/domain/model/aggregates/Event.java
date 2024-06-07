package backend.myevent.MyEvent.news.domain.model.aggregates;

import backend.myevent.MyEvent.news.domain.model.commands.CreateEventCommand;
import backend.myevent.MyEvent.news.domain.model.commands.UpdateEventCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Event {


    //Creacion de las tablas usando los parametros usados en el diagrama de clases
    // ID, NAME, DATE, ORGANIZER, LOCATION, RESALE, DESCRIPTION, PRICE, CAPACITY, IMAGE, CATEGORY

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String date;

    @Column(nullable = true)
    private String organizer;

    @Column(nullable = true)
    private String location;

    @Column(nullable = true)
    private Boolean resale;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private Double price;

    @Column(nullable = true)
    private Integer capacity;

    @Column(nullable = true)
    private String image;

    @Column(nullable = true)
    private String category;

    /** The API key for the news source.
    //@Column(nullable = false)
    private String newsApiKey; */
    /** The API key for the news source. */
    @Column(nullable = false)
    private String eventApiKey;

    protected Event() {}

    public Event(CreateEventCommand command) {
        this.name = command.name();
        this.date = command.date();
        this.organizer = command.organizer();
        this.location = command.location();
        this.resale = command.resale();
        this.description = command.description();
        this.price = command.price();
        this.capacity = command.capacity();
        this.image = command.image();
        this.category = command.category();
        this.eventApiKey = command.eventApiKey();
    }

    public void update(UpdateEventCommand command) {
        this.name = command.name();
        this.date = command.date();
        this.organizer = command.organizer();
        this.location = command.location();
        this.resale = command.resale();
        this.description = command.description();
        this.price = command.price();
        this.capacity = command.capacity();
        this.image = command.image();
        this.category = command.category();
        this.eventApiKey = command.eventApiKey();
    }

}
