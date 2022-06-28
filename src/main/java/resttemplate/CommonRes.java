package resttemplate;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonRes<T> implements Serializable {
    private static final long serialVersionUID = -1L;

    private int code;

    private String msg;

    private T data;

    private String totalRecord;

    public static final int SUCCESS = 200;

    public static <T> CommonRes<T> SUCCESS(T data) {
        return new CommonRes<>(SUCCESS, "success", data, "");
    }

    public static <T> CommonRes<T> SUCCESS(T data, String totalRecord) {
        return new CommonRes<>(SUCCESS, "success", data, totalRecord);
    }

    public static <T> CommonRes<T> FAIL(ErrorCode codeEnum) {
        return new CommonRes<>(codeEnum.code, getCodeMessage(codeEnum.code, codeEnum.message), null, null);
    }

    public static <T> CommonRes<T> FAIL(ErrorCode codeEnum, T data) {
        return new CommonRes<>(codeEnum.code, getCodeMessage(codeEnum.code, codeEnum.message), data, null);
    }

    public static <T> CommonRes<T> FAIL(int code, String msg, T data) {
        return new CommonRes<>(code, getCodeMessage(code, msg), data, null);
    }

    public static <T> CommonRes<T> FAIL(int code, String msg) {
        return new CommonRes<>(code, getCodeMessage(code,msg), null, null);
    }

    public static <T> CommonRes<T> FAIL_WITH_CODE(int code, String msg) {
        msg = getCodeMessage(code,msg);
        return new CommonRes<>(code, msg, null, null);
    }

    public static <T> CommonRes<T> FAIL_WITH_CODE(ErrorCode codeEnum) {
        return FAIL_WITH_CODE(codeEnum.code,codeEnum.message);
    }

    private static String getCodeMessage(int code, String msg){
        if (null != msg && !"".equals(msg) && !msg.contains("(")) {
            msg += "(" + code + ")";
        }
        return msg;
    }
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}