package com.dmall.user.infrastructure.persistent;

import com.dmall.user.domain.model.User;
import com.dmall.user.domain.model.UserRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryImpl extends UserRepository, CrudRepository<User, Long> {
}
