package com.blog.help.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by tk on 16-4-24.
 */
public class RegDto {
    @NotBlank(message = "用户名不能为空")
    @Size(min = 6, message = "用户名长度必须大于6")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, message = "密码长度必须大于6")
    private String password;
    @NotBlank(message = "验证码不能为空")
    @Pattern(regexp = "^1234$", message = "验证码错误")
    private String code;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
