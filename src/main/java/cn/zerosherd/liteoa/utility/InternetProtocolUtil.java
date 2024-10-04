package cn.zerosherd.liteoa.utility;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InternetProtocolUtil {

//    public static String getIp(HttpServletRequest request) {
//
//        String ip = request.getHeader("x-forwarded-for");
//
//        if (ObjectUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("x-real-ip");
//        }
//
//        if (ObjectUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//
//        return ip;
//    }

    public static String getIp() throws UnknownHostException {

        InetAddress ia = null;
        ia = InetAddress.getLocalHost();

        return ia.getHostAddress();
    }

}
