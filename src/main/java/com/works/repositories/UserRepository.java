package com.works.repositories;

import com.works.entities.Users;
import com.works.utils.EUser;
import com.works.utils.EUserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {


    Page<Users> findByUsernameLike(String username, Pageable pageable);

    Page<Users> findByRoleIn(Collection<EUserRole> roles, Pageable pageable);

    List<Users> findByStatusIn(Collection<EUser> statuses);

    List<Users> findByAgeEquals(Integer age);


}