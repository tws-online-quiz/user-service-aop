package com.dmall.user.domain.model;

public interface UserRepository {
    User findOne(Long id);

    User save(User user);
}
