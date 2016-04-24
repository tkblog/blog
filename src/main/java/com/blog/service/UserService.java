package com.blog.service;

import com.blog.common.Sdo;
import com.blog.domain.User;
import com.blog.help.dto.LoginDto;

/**
 * Created by tk on 16-4-24.
 */
public interface UserService {
    Sdo<User> login(LoginDto dto);
}
