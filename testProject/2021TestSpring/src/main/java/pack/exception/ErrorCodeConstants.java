package pack.exception;

/**
 * @Author: baidongliang@sogou-inc.com
 * @Date: 2020/6/17 16:00
 */
public enum ErrorCodeConstants {
    /*
     * 系统异常，1-9 预留系统级的异常码
     */
    SYSTEM_ERROR(1, "系统错误"),
    BIZ_ERROR(2, "业务异常"),
    WRONG_PARAMETER(3, "输入参数非法"),
    TEXT_TOO_LONG(4, "字数过长"),
    NO_PERMISSION(5, "当前用户没有权限操作"),

    /**
     * 业务相关异常
     */
    SITE_URL_NOT_FOUND(10001, "页面不存在"),
    SITE_URL_PREVIEW_TIME_OUT(10002, "链接已失效"),
    SITE_URL_INILLEGAL(10003, "站点非法"),
    TEMPLATE_SITE_NOT_EXIST(10004, "模板不存在"),
    VIDEO_FILE_NAME_ILLEGAL(10005, "文件标题过长"),
    VIDEO_SUFFIX_ILLEGAL(10006, "视频格式错误，仅支持mp4视频格式"),
    VIDEO_SIZE_ILLEGAL(10007, "请上传100MB内的视频文件"),
    UPLOAD_FILE_TO_CEPH_FAILED(10008, "上传文件至ceph失败"),
    NO_PERMISSION_TO_ACCESS_AGENT_SITE(10009, "无权限访问代理商站点"),
    URL_CONVERT_TO_TEMPLATE_FAIL(10010, "URL转换成模板转换失败"),
    SITE_MEMBER_IS_FROZEN(10011, "该站点归属用户已被冻结"),
    MODULE_NOT_EXIST(10012, "模块不存在"),
    SITE_TEMPLATE_IMPORT_ERROR(10013, "站点导入失败"),
    PRODUCT_BIND_NUM_GT_SIX(10014, "绑定失败，最多只能绑定6个产品");


    int code;
    String text;

    ErrorCodeConstants(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public static ErrorCodeConstants parse(int i) {
        return ErrorCodeConstants.values()[i];
    }
}
