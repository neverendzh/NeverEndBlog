package com.neverend.blog.exception;

public class ServiceException extends RuntimeException {
    /*无参构造函数*/
    public ServiceException(){
        super();
    }

    //用详细信息指定一个异常
    public ServiceException(String message){
        super(message);
    }

    //用指定的详细信息和原因构造一个新的异常
    public ServiceException(String message, Throwable cause){
        super(message,cause);
    }

    //用指定原因构造一个新的异常
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
