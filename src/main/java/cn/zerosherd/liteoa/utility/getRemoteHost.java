package cn.zerosherd.liteoa.utility;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.ObjectUtils;

public class getRemoteHost {

    public static String getIp(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");

        if (ObjectUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-real-ip");
        }

        if (ObjectUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

}
