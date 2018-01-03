package com.dmall.user.domain.model;

import java.util.List;

public interface ContactRepository {
    List<Contact> findByUserId(Long id);
    Contact save(Contact contact);
}
