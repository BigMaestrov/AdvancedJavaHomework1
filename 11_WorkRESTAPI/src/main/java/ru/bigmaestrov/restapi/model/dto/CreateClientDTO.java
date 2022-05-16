package ru.bigmaestrov.restapi.model.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateClientDTO {
    @NotNull
    @JsonProperty("id")
    private String id;
    @NotNull
    @JsonProperty("first_name")
    private String firstName;
    @NotNull
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("middle_name")
    private String middleName;
    @NotNull
    @JsonProperty("birth_date")
    private String birthDate;
    @NotNull
    @JsonProperty("phone")
    private String phone;
    @NotNull
    @JsonProperty("email")
    private String email;
    @NotNull
    @JsonProperty("gender")
    private String gender;
}
