package com.dmall.user.infrastructure.persistent;

import com.dmall.user.domain.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
