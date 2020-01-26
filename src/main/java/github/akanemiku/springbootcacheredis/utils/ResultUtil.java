package github.akanemiku.springbootcacheredis.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 为测试swagger model而建
 */
public class ResultUtil {
    @Data
    public static class ResultVO<T> implements Serializable {
        private Integer code;
        private String msg;
        private T data;
    }

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(200);
        resultVO.setMsg("SUCCESS");
        return resultVO;
    }
}
