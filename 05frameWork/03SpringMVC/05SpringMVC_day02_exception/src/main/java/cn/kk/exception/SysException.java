package cn.kk.exception;

/*
        异常类
 */
public class SysException extends Exception{

    //存储信息
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SysException(String msg) {
        this.msg = msg;
    }
}
