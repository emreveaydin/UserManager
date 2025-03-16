package com.works.services;


import com.works.entities.Users;
import com.works.repositories.UserRepository;
import com.works.utils.EUser;
import com.works.utils.EUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserServices {

    final UserRepository userRepository;

    public ResponseEntity save(Users user) {
        userRepository.save(user);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public List<Users> saveAll(List<Users> users) {
        return userRepository.saveAll(users);
    }

    public Page<Users> all(int page, int size ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Users> pageProduct = userRepository.findAll(pageable);
        return pageProduct;
    }

    // Belirli bir kullanıcıyı ID ile getirme metodu
    public Users singleUser(long uid ) {
        Optional<Users> product = userRepository.findById(uid);
        return product.orElse(null);
    }

    public Page<Users> userSearch(String q, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findByUsernameLike(q, pageable);
    }

    public List<Users> findUsersByStatuses(Collection<EUser> statuses) {
        return userRepository.findByStatusIn(statuses);
    }

    public Page<Users> findUsersByRoles(Collection<EUserRole> roles, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findByRoleIn(roles, pageable);
    }

    public List<Users> findUsersByAge(Integer age) {
        return userRepository.findByAgeEquals(age);
    }



}
