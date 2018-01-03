package com.dmall.user.apis;

import com.dmall.user.apis.dto.UserDTO;
import com.dmall.user.common.ApiForResponse;
import com.dmall.user.common.HttpFacadeBaseClass;
import com.dmall.user.domain.model.*;
import com.dmall.user.infrastructure.persistent.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController extends HttpFacadeBaseClass {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private ContactRepository contactRepository;


    @Autowired
    public UserController(UserRepository userRepository,
                          RoleRepository roleRepository, ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.contactRepository = contactRepository;
    }


    @Transactional
    @GetMapping("/{id}")
    public  ApiForResponse<UserDTO> findUserById(@PathVariable("id") final long id) {

        User user = userRepository.findOne(id);
        UserDTO userDTO = new UserDTO(user);
        userDTO.setContacts(String.format("/api/v1/users/%d/contacts", id));
        ApiForResponse<UserDTO> userApiForResponse = new ApiForResponse<>(user.getId(), userDTO);
        return userApiForResponse;
    }

    @Transactional
    @GetMapping("/{id}/contacts")
    public  ApiForResponse<List<Contact> > findContactsByUserId(@PathVariable("id") final long id) {

        List<Contact> contacts = contactRepository.findByUserId(id);
        ApiForResponse<List<Contact> > userApiForResponse = new ApiForResponse<>(id, contacts);
        return userApiForResponse;
    }


}

