package com.blog.common;

/**
 * Created by tk on 16-4-24.
 */
public class Sdo<T> {
    public static final String NOTICE_SUCCESS = "success";
    public static final String NOTICE_ERROR = "error";

    public Sdo() {

    }

    public Sdo(String notice, T obj, String message) {
        this.notice = notice;
        this.message = message;
        this.obj = obj;
    }

    public static Sdo success() {
        return success(null);
    }

    public static <D> Sdo<D> success(D d) {
        return success(d, "操作成功");
    }

    public static <D> Sdo<D> success(D d, String message) {
        Sdo<D> sdo = new Sdo();
        sdo.setNotice(NOTICE_SUCCESS);
        sdo.setMessage(message);
        sdo.setObj(d);
        return sdo;
    }

    public static Sdo error(String message) {
        Sdo sdo = new Sdo();
        sdo.setMessage(message);
        sdo.setObj(null);
        sdo.setNotice(NOTICE_ERROR);
        return sdo;
    }

    private String notice;
    private String message;
    private T obj;

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public Boolean isSuccess() {
        return NOTICE_SUCCESS.equals(getNotice());
    }
}
