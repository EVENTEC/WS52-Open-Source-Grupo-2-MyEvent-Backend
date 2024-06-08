package backend.myevent.MyEvent.news.domain.model.commands;

public record CreateUserCommand(String name, String surname, String correo, String password, String phone, String dni, String tipoDeCuenta, String premium) {

    public CreateUserCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("surname cannot be null or empty");
        }
        if (correo == null || correo.isBlank()) {
            throw new IllegalArgumentException("correo cannot be null or empty");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("password cannot be null or empty");
        }
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("phone cannot be null or empty");
        }
        if (dni == null || dni.isBlank()) {
            throw new IllegalArgumentException("dni cannot be null or empty");
        }
        if (tipoDeCuenta == null || tipoDeCuenta.isBlank()) {
            throw new IllegalArgumentException("tipoDeCuenta cannot be null or empty");
        }
        if (premium == null || premium.isBlank()) {
            throw new IllegalArgumentException("premium cannot be null or empty");
        }
    }

}