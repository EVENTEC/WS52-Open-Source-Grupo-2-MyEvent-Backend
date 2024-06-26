package backend.myevent.MyEvent.security.interfaces.acl;

import backend.myevent.MyEvent.security.domain.models.commands.SignUpCommand;
import backend.myevent.MyEvent.security.domain.models.entities.Role;
import backend.myevent.MyEvent.security.domain.models.queries.GetUserByEmailQuery;
import backend.myevent.MyEvent.security.domain.models.queries.GetUserByIdQuery;
import backend.myevent.MyEvent.security.domain.services.UserCommandService;
import backend.myevent.MyEvent.security.domain.services.UserQueryService;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;

public class IamContextFacade {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public IamContextFacade(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    /**
     * Creates a user with the given username and password.
     * @param correo The username of the user.
     * @param password The password of the user.
     * @return The id of the created user.
     */
    public Long createUser(String name, String surname, String correo, String password, String phone, String dni, String tipoDeCuenta, String premium) {
        var signUpCommand = new SignUpCommand(name, surname, correo, password, phone, dni, tipoDeCuenta, premium,List.of(Role.getDefaultRole()));
        var result = userCommandService.handle(signUpCommand);
        if (result.isEmpty()) return 0L;
        return result.get().getId();
    }

    /**
     * Creates a user with the given username, password and roles.
     * @param correo The username of the user.
     * @param password The password of the user.
     * @param roleNames The names of the roles of the user. When a role does not exist, it is ignored.
     * @return The id of the created user.
     */
    public Long createUser(String name, String surname, String correo, String password, String phone, String dni, String tipoDeCuenta, String premium, List<String> roleNames) {
        var roles = roleNames != null ? roleNames.stream().map(Role::toRoleFromName).toList() : new ArrayList<Role>();
        var signUpCommand = new SignUpCommand(name, surname, correo, password, phone, dni, tipoDeCuenta, premium, roles);
        var result = userCommandService.handle(signUpCommand);
        if (result.isEmpty()) return 0L;
        return result.get().getId();
    }

    /**
     * Fetches the id of the user with the given username.
     * @param correo The username of the user.
     * @return The id of the user.
     */
    public Long fetchUserIdByEmail(String correo) {
        var getUserByUsernameQuery = new GetUserByEmailQuery(correo);
        var result = userQueryService.handle(getUserByUsernameQuery);
        if (result.isEmpty()) return 0L;
        return result.get().getId();
    }

    /**
     * Fetches the username of the user with the given id.
     * @param userId The id of the user.
     * @return The username of the user.
     */


    public String fetchEmailByUserId(Long userId) {
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var result = userQueryService.handle(getUserByIdQuery);
        if (result.isEmpty()) return Strings.EMPTY;
        return result.get().getCorreo();
    }

}