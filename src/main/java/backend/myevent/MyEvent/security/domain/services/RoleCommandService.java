package backend.myevent.MyEvent.security.domain.services;

import backend.myevent.MyEvent.security.domain.models.commands.SeedRoleCommand;

public interface RoleCommandService {
    void handle(SeedRoleCommand command);

}
