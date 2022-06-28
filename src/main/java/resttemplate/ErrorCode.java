package resttemplate;

public enum ErrorCode {

    //特殊情况，客户端登录校验错误码
    CLIENT_USER_NOT_LOGIN(571001,"客户端未登录"),
    PARAMS_NOT_FULL(900001,"参数传输不全"),
    TASK_IS_WORKING(900002,"任务还在进行"),
    SYSTEM_BUSY(900003,"请求失败，请稍后重试"),
    REQUEST_TIMEOUT(900004,"请求超时，请稍后再试"),
    PARAMS_BIND_EXCEPTION(900005,"请求入参异常"),
    HTTP_REQUEST_EXCEPTION(900006,"http请求出错"),
    DECRYPT_EXCEPTION(900007,"参数加解密异常"),
    NULL_POINT_EXCEPTION(900008,"空指针异常"),
    CLIENT_EXCEPTION(900009,"服务发现异常"),
    IO_ERROR_CODE(900010, "IO错误"),
    SQL_EXCEPTION(900011,"数据库操作异常"),
    JSON_FORMAT_EXCEPTION(900012, "JSON反序列失败异常"),
    LOGIN_VALIDATE_FAIL(900013,"登录失效,请重新登录"),
    LOGIN_TOKEN_INVALID(900014, "令牌失效"),
    HTTP_MESSAGE_NOT_READABLE_EXCEPTION(900015, "http消息读取失败异常"),
    USER_INFO_GET_FAILED(900016, "获取用户信息失败"),
    OBTAINED_DATA_EMPTY(900017, "获取数据为空"),
    OPEN_MEMBER_NUM_ERROR(900018,"开通会员数量大于限制数量99999"),
    MQ_MEMBER_CONSUME_UNKNOWN_ORDER_NO(900019,"会员消费未知订单号"),
    BOOK_CITY_RESULT_CODE(900020,"书城统一返回异常码"),
    SYSTEM_ERROR(999999, "系统错误");

    public final int code;
    public final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}