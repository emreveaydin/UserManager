package com.works.restcontrollers;

import com.works.entities.Users;
import com.works.services.UserServices;
import com.works.utils.EUser;
import com.works.utils.EUserRole;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@Validated

public class UserRestControllers {

    final UserServices userServices;


    @PostMapping("save")
    public ResponseEntity save(@Valid @RequestBody Users user) { return this.userServices.save(user); }

    @PostMapping("saveAll")
    public List<Users> saveAll(@Valid @RequestBody List<Users> users) { return this.userServices.saveAll(users); }

    @PostMapping("list")
    public Page<Users> list(@RequestParam @Min(0) int page, @Min(0) @Max(20) int size) {
        return userServices.all(page, size);
    }


    @GetMapping("single")
    public Users singleUser(@RequestParam(defaultValue = "0") long uid)
    {
        return userServices.singleUser(uid);
    }

    @GetMapping("search")
    public Page<Users> search(
            @RequestParam(defaultValue = "") String q,
            @RequestParam(defaultValue = "0") int page,
            @Min(5) @Max(20) @RequestParam(defaultValue = "10") int size
    ) {
        return userServices.userSearch(q, page, size);
    }

    @GetMapping("/users/roles")
    public ResponseEntity<Page<Users>> getUsersByRoles(@RequestParam List<EUserRole> roles,
                                                       @RequestParam int page,
                                                       @RequestParam int size) {
        Page<Users> users = userServices.findUsersByRoles(roles, page, size);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping("/users/statuses")
    public ResponseEntity<List<Users>> getUsersByStatuses(@RequestParam List<EUser> statuses) {
        List<Users> users = userServices.findUsersByStatuses(statuses);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping("/users/age")
    public ResponseEntity<List<Users>> getUsersByAge(@RequestParam Integer age) {
        List<Users> users = userServices.findUsersByAge(age);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
