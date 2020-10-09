package org.lanqiao.util;

import org.springframework.stereotype.Component;

@Component
public class ResultFactory {
    public static Result setResultError(Integer code,String msg){
        return setResult(code,msg,null);
    }
    //返回错误，可以传msg
    public static Result setResultError(){
        return setResult(ResultCode.HTTP_RES_CODE_500,ResultCode.HTTP_RES_CODE_500_VALUE,null);
    }
    //返回成功，可以传data值
    public static Result setResultSuccess(Object data){
        return setResult(ResultCode.HTTP_RES_CODE_200,ResultCode.HTTP_RES_CODE_200_VALUE,data);
    }
    //返回成功，没有data值
    public static Result setResultSuccess(){
        return setResult(ResultCode.HTTP_RES_CODE_200,ResultCode.HTTP_RES_CODE_200_VALUE,null);
    }


    //通用封装
    private static Result setResult(Integer code, String msg, Object data) {
        return new Result(code, msg,data);
    }
}
