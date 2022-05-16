package ru.bigmaestrov.restapi.model.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client_table")
public class Client {
    @Id
    @Column(name = "id", length = 8)
    private String id;
    @Pattern(regexp = "[\\-А-Яа-яЁё]+", message = "В имени допускаются только русские буквы и знак -")
    @Column(name = "first_name", length = 32, nullable = false)
    private String firstName;
    @Pattern(regexp = "[\\-А-Яа-яЁё]+", message = "В фамилии допускаются только русские буквы и знак -")
    @Column(name = "last_name", length = 32, nullable = false)
    private String lastName;
    @Pattern(regexp = "[\\-А-Яа-яЁё]+", message = "В отчестве допускаются только русские буквы и знак -")
    @Column(name = "middle_name", length = 32)
    private String middleName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    @Pattern(regexp = "^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$", message = "Неверный формат телефона!")
    @Column(name = "phone", length = 20, nullable = false, unique = true)
    private String phone;
    @Email
    @Column(name = "email", length = 64, nullable = false)
    private String email;
    @Column(name = "registration_date", nullable = false, unique = true)
    private LocalDateTime registrationDate;
    @Column(name = "deletion_date")
    private LocalDateTime deletionDate;
}
