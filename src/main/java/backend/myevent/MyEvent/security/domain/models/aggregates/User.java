package backend.myevent.MyEvent.security.domain.models.aggregates;

import backend.myevent.MyEvent.security.domain.models.entities.Role;
import backend.myevent.MyEvent.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class User extends AuditableAbstractAggregateRoot<User> {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    private String correo;

    @NotBlank
    @Size(max = 120)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String dni;

    @Column(nullable = false)
    private String tipoDeCuenta;

    @Column(nullable = false)
    private String premium;

    @Column(nullable = false, updatable = false)
    private LocalDate dayCreate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // Eager fetch to load the roles when loading the user en españo
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
        this.roles = new HashSet<>();
    }

    public User(String name, String surname, String correo, String password, String phone, String dni, String tipoDeCuenta, String premium, List<Role> roles) {
        this.name = name;
        this.surname = surname;
        this.correo = correo;
        this.password = password;
        this.phone = phone;
        this.dni = dni;
        this.tipoDeCuenta = tipoDeCuenta;
        this.premium = premium;
        this.dayCreate= LocalDate.now();
        this.roles = new HashSet<>(roles);
        addRoles(roles);
    }

    public User addRoles(List<Role> roles) {
        var validatedRoleSet = Role.validateRoleSet(roles);
        this.roles.addAll(validatedRoleSet);
        return this;
    }
    public Set<Role> getRoles() {
        return this.roles;
    }
    public String getUsername() {
        return this.name;
    }

}
