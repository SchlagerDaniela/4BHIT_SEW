package model;

import java.util.Objects;

/*
        Author: Schlager Daniela
        Date: 07.11.2019
        Class: 4BHIT
        Zuletzt bearbeitet: 07.11.2019

 */

public class Login {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return username.equals(login.username) &&
                password.equals(login.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
