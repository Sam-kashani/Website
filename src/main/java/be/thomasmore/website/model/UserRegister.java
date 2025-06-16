package be.thomasmore.website.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserRegister {


        @NotBlank(message = "Gebruikersnaam is verplicht")
        private String username;

        @NotBlank(message = "Wachtwoord is verplicht")
        private String password;

        @NotBlank(message = "Naam is verplicht")
        private String name;

        @NotBlank(message = "E-mailadres is verplicht")
        @Email(message = "Ongeldig e-mailadres")
        private String email;

        @NotNull(message = "Leeftijd is verplicht")
        @Min(value = 12, message = "Minimumleeftijd is 12")
        private Integer age;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

