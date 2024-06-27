package backend.myevent.MyEvent.event.domain.model.aggregates;

import backend.myevent.MyEvent.event.domain.exceptions.EventNotFoundException;
import backend.myevent.MyEvent.event.domain.model.commands.CreateEventCommand;
import backend.myevent.MyEvent.event.domain.model.commands.UpdateEventCommand;
import backend.myevent.MyEvent.event.domain.model.commands.UpdateEventCommandWithoutDates;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Lob
    @Column(length = 10000)
    private String description;
    private String category;
    private Date startDate;
    private Date endDate;
    @Embedded
    private Location location;
    @Embedded
    private Organizer organizer;
    private int totalTickets;
    private double priceTicket;

    // Constructor vacío (puede ser necesario para algunos frameworks y pruebas)
    public Event() {
    }

    // Constructor completo
    public Event(Long id, String name, String description, String category, Date startDate, Date endDate, Location location, Organizer organizer, int totalTickets, double priceTicket) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.organizer = organizer;
        this.totalTickets = totalTickets;
        this.priceTicket = priceTicket;
    }

    // Constructor que acepta un CreateEventCommand
    public Event(CreateEventCommand command) {
        this.name = command.eventName();
        this.description = command.eventDescription();
        this.startDate = command.eventStartDate();
        this.endDate = command.eventEndDate();
        // Los campos location, organizer y totalTickets no están presentes en CreateEventCommand

    }

    // Método para actualizar un evento con un UpdateEventCommand
    public void update(UpdateEventCommand command) {
        if (!this.id.equals(command.id())) {
            throw new EventNotFoundException(this.id);
        }
        this.name = command.eventName();
        this.description = command.eventDescription();
        this.startDate = command.eventStartDate();
        this.endDate = command.eventEndDate();
        // Los campos location, organizer y totalTickets no están presentes en UpdateEventCommand
        // Puedes agregarlos si son necesarios
    }
    // Método para actualizar un evento con un UpdateEventCommandWithoutDates
    public void updateWithoutDates(UpdateEventCommandWithoutDates command) {
        if (!this.id.equals(command.id())) {
            throw new EventNotFoundException(this.id);
        }
        this.name = command.eventName();
        this.description = command.eventDescription();
        // No actualizamos startDate ni endDate
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(double priceTicket) {
        this.priceTicket = priceTicket;
    }
}
