package pack.exception;



/**
 * 业务异常
 *
 * @author chenchensi2000
 */
public class BizException extends RuntimeException {
    private Integer errorCode = ErrorCodeConstants.BIZ_ERROR.ordinal();
    private String errorMessage;

    public BizException() {
        super();
    }

    public BizException(ErrorCodeConstants errorCodeEnum) {
        super();
        this.errorMessage = errorCodeEnum.getText();
        this.errorCode = errorCodeEnum.getCode();
    }

    public BizException(Integer errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BizException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
