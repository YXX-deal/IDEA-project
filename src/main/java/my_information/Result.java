package my_information;

import lombok.Data;

@Data
// 如果你报错，记得在pom.xml引入Lombok依赖
public class Result<T> {
    private Integer code; // 状态码
    private String msg;  // 消息
    private T data;      // 数据

    // 私有构造器，强制通过静态方法创建
    private Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /** 成功返回 (带数据) */
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    /** 成功返回 (带消息和数据) */
    public static <T> Result<T> success(String msg, T data) {
        return new Result<>(200, msg, data);
    }

    /** 失败返回 */
    public static <T> Result<T> fail(Integer code, String msg) {
        return new Result<>(code, msg, null);
    }
}