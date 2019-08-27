package com.neverend.blog.moudel;

public class MyServiceException extends RuntimeException {
    /*无参构造函数*/
    public MyServiceException(){
        super();
    }

    //用详细信息指定一个异常
    public MyServiceException(String message){
        super(message);
    }

    //用指定的详细信息和原因构造一个新的异常
    public MyServiceException(String message, Throwable cause){
        super(message,cause);
    }

    //用指定原因构造一个新的异常
    public MyServiceException(Throwable cause) {
        super(cause);
    }
}
