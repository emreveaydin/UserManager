package com.works.entities;


import com.works.utils.EUser;
import com.works.utils.EUserGender;
import com.works.utils.EUserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Size(min = 1, max = 20)
    @NotBlank
    private String username;

    @Size(min = 1, max = 40)
    @NotBlank
    private String password;

    @Positive
    @Digits(integer = 2, fraction = 0)
    @Max(60)
    @Min(18)
    @NotNull
    private Integer age;

    @NotBlank
    @Email
    private String email;

    @Size(min = 10, max = 10)
    @NotBlank
    private String phone;

    @Size(min = 1, max = 200)
    @NotBlank
    private String bio;

    @NotNull
    private Boolean married;

    @Enumerated
    @NotNull
    private EUserRole role;

    @NotNull
    @Enumerated
    private EUserGender gender;

    @NotNull
    @Enumerated
    private EUser status;

    @NotBlank
    @URL
    private String image;


}
