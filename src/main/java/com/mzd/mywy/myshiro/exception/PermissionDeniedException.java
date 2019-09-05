package com.mzd.mywy.myshiro.exception;

/**
 * Permission denied
 *
 * @author Theodore
 * @since 2019/9/5 10:41
 */
public class PermissionDeniedException extends Exception {
    public PermissionDeniedException() {
        //权限不足
        super("Permission denied!");
    }
}
