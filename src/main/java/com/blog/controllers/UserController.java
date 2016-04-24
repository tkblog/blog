package com.blog.controllers;

import com.blog.common.Sdo;
import com.blog.domain.User;
import com.blog.help.dto.LoginDto;
import com.blog.help.dto.RegDto;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by tk on 16-4-24.
 */
@Controller
@Scope("singleton")
@RequestMapping("/user")
public class UserController extends AbstractWebController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String login(HttpSession httpSession,
                        @Validated LoginDto dto, BindingResult result) {
        if (result.hasErrors()) {
            return getErrorMessage(result);
        }

        final Sdo<User> sdo = userService.login(dto);
        if (sdo.isSuccess()) {
            httpSession.setAttribute("userId", sdo.getObj().getId());
        }
        return sdoAsViewData(sdo);
    }

    @RequestMapping(value = "reg", method = RequestMethod.GET)
    @ResponseBody
    public String reg(@Validated RegDto dto, BindingResult result) {
        if (result.hasErrors()) {
            return getErrorMessage(result);
        }
        return success("注册成功");
    }
}
