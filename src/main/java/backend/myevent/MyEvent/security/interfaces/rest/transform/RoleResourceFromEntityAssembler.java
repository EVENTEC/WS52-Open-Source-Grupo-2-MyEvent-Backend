package backend.myevent.MyEvent.security.interfaces.rest.transform;

import backend.myevent.MyEvent.security.domain.models.entities.Role;
import backend.myevent.MyEvent.security.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
