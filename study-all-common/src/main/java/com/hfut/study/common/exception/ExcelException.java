package com.hfut.study.common.exception;

/**
 * @auther chenjia
 * @date 2017/7/7 14:20
 * @desc
 */
public class ExcelException extends Exception {

    public ExcelException() {
    }

    public ExcelException(String message) {
        super(message);
    }

    public ExcelException(Throwable cause) {
        super(cause);
    }

    public ExcelException(String message, Throwable cause) {
        super(message, cause);
    }


}
