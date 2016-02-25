package cn.ihealthbaby.hospital.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;

/**
 * @author zuoge85 on 15/5/17.
 */
public class LoginForm {
    @NotEmpty
    @Length(min = 5, max = 16)
    private String name;

    @NotEmpty
    @Length(min = 6, max = 16)
    private String password;

    public LoginForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
