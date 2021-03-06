package ru.pravvich.user;

import java.sql.Timestamp;

/**
 * User's data.
 */
public class User {
    private int id;
    private String name;
    private String login;
    private String email;
    private String password;
    private Timestamp createAccount;
    private String successLevel;

    public User() {}

    public User(final int id,
                final String name,
                final String login,
                final String password,
                final String email,
                final Timestamp createAccount,
                final String successLevel) {

        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
        this.createAccount = createAccount;
        this.successLevel = successLevel;
    }

    public User(final String name,
                final String login,
                final String email) {

        this.name = name;
        this.login = login;
        this.email = email;
    }

    public User(final int id,
                final String name,
                final String login,
                final String email) {

        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
    }

    public User(final int id,
                final String name,
                final String login,
                final String email,
                final Timestamp createAccount) {

        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createAccount = createAccount;
    }


    public User(final String name,
                final String login,
                final String password,
                final String email,
                final String successLevel) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
        this.successLevel = successLevel;
    }

    public User(final String name,
                final String login,
                final String password,
                final String email) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSuccessLevel(String successLevel) {
        this.successLevel = successLevel;
    }

    public String getPassword() {
        return password;
    }

    public String getSuccessLevel() {
        return successLevel;
    }

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreateAccount() {
        return createAccount;
    }

    public void setCreateAccount(Timestamp createAccount) {
        this.createAccount = createAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!name.equals(user.name)) return false;
        if (!login.equals(user.login)) return false;
        if (!email.equals(user.email)) return false;
        if (!password.equals(user.password)) return false;
        return successLevel.equals(user.successLevel);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + createAccount.hashCode();
        result = 31 * result + successLevel.hashCode();
        return result;
    }
}
