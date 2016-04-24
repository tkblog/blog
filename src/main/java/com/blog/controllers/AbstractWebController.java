package com.blog.controllers;

import com.blog.common.Sdo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by tk on 16-4-24.
 */
public class AbstractWebController {
    /**
     * 返回成功信息
     *
     * @param o
     * @return
     */
    protected String success(Object o) {
        return success(o, null);
    }

    /**
     * 返回成功信息
     *
     * @param o
     * @param message
     * @return
     */
    protected String success(Object o, String message) {
        Map map = new HashMap<>();
        map.put("notice", "success");
        map.put("message", message);
        map.put("obj", o);
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 返回错误信息
     *
     * @param message
     */
    protected String error(String message) {
        Map map = new HashMap<>();
        map.put("notice", "error");
        map.put("message", message);
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    protected String sdoAsViewData(Sdo sdo) {
        final String message = sdo.getMessage();
        return sdo.isSuccess() ? success(sdo.getObj(), message) : error(message);
    }

    protected String getErrorMessage(BindingResult result) {
        if (result.hasErrors()) {
            final Iterator<ObjectError> iterator = result.getAllErrors().iterator();
            if (iterator.hasNext()) {
                return error(iterator.next().getDefaultMessage());
            }
        }
        return error("");
    }
}
