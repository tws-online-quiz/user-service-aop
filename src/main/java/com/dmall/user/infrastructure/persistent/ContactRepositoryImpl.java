package com.dmall.user.infrastructure.persistent;

import com.dmall.user.domain.model.Contact;
import com.dmall.user.domain.model.ContactRepository;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepositoryImpl extends ContactRepository, CrudRepository<Contact, Long> {
}
