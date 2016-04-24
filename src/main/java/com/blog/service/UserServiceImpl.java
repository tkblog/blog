package com.blog.service;

import com.blog.common.Sdo;
import com.blog.domain.User;
import com.blog.help.dto.LoginDto;
import org.springframework.stereotype.Service;

/**
 * Created by tk on 16-4-24.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public Sdo<User> login(LoginDto dto) {
        if ("admin123".equals(dto.getUsername()) && "admin123".equals(dto.getPassword())) {
            final User user = new User();
            user.setId(1L);
            return Sdo.success(user);
        }
        return Sdo.error("用户或密码错误");
    }
}
