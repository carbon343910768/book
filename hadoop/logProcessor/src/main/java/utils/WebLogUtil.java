package utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebLogUtil {
    public static SimpleDateFormat sdf_origin = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.ENGLISH);
    public static SimpleDateFormat sdf_standard = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static String[] items = {
            "(?<ip>\\S+)",                          // 远端主机
            "(?<loginname>[\\w.-]+)",               // 远端登录名
            "(?<username>[\\w.-]+)",                // 远程用户名
            "(?<receivetime>\\[[^\\[\\]]+\\])",     // 服务器接收时间
            "(?<url>\"((?:[^\"]|\")+)\")",        // 请求的路径*
            "(?<status>[[0-9].-]+)",                   // 最后请求的状态
            "(?<size>[[0-9].-]+)",                      // 以CLF格式显示的除HTTP头以外传送的字节数
            "(?<referurl>\"((?:[^\"]|\")+)\")",   // 上一个访问页面
            "(?<agent>\"((?:[^\"]|\")+)\")",      // 用户浏览器信息
            "(?<cookie>\"(.+)\")",                  // Cookie信息
            "(?<getsize>.*)",                       // 接收的字节数
            "(?<postsize>.*)",                      // 发送的字节数
            "(?<forwarded>.*)",                     // %{X-Forwarded-For}i
            "(?<host>.+)",                          // 访问主机的地址（域名）
            "(?<time>.*)"                           // 服务器处理本请求所用的时间，以微秒为单位
    };

    //自定义的将日志信息按日志创建的时间升序排序
    public Boolean dateComparator(String elementA, String elementB) throws ParseException {
        return sdf_standard.parse(elementA.split(" ")[3]).getTime() < sdf_standard.parse(elementB.split(" ")[3]).getTime();
    }

    /**
     * 为每一条访问记录添加一个SessionID
     */
    public static List<String> distinctLogInfoBySession(List<String> logInfoGroup) throws ParseException {
        List<String> logInfoBySession = new ArrayList<String>();
        long lastRequestTime = 0;
        String lastSessionID = "";

        for (String logInfo : logInfoGroup) {
            //某IP的用户第一次访问网站的记录做为该用户的第一个session日志
            if (lastRequestTime == 0) {
                lastSessionID = UUID.randomUUID().toString();
                //将该次访问日志记录拼上sessionID并放进按session分类的日志信息数组中
                logInfoBySession.add(lastSessionID + "|" + logInfo);
                //记录该次访问日志的时间,并用户和下一条访问记录比较,看时间间隔是否超过30分钟,是的话就代表新Session开始
                lastRequestTime = sdf_standard.parse(logInfo.split("\\|")[3]).getTime();
            } else {
                //当前日志记录和上一次的访问时间相比超过30分钟,所以认为是一个新的Session,重新生成sessionID
                if (sdf_standard.parse(logInfo.split("\\|")[3]).getTime() - lastRequestTime >= 30 * 60 * 1000) {
                    //和上一条访问记录相比,时间间隔超过了30分钟,所以当做一次新的session,并重新生成sessionID
                    lastSessionID = UUID.randomUUID().toString();
                    logInfoBySession.add(lastSessionID + "|" + logInfo);
                    //记录该次访问日志的时间,做为一个新session开始的时间,并继续和下一条访问记录比较,看时间间隔是否又超过30分钟
                    lastRequestTime = sdf_standard.parse(logInfo.split("\\|")[3]).getTime();
                } else {
                    //当前日志记录和上一次的访问时间相比没有超过30分钟,所以认为是同一个Session,继续沿用之前的sessionID
                    logInfoBySession.add(lastSessionID + "|" + logInfo);
                }
            }
        }
        return logInfoBySession;
    }

    /**
     * 过滤掉信息不全或者格式不正确的日志信息
     */
    public static String weblogParser(String logLine) throws ParseException {
        //过滤掉信息不全或者格式不正确的日志信息
        boolean isStandardLogInfo = logLine.split("`").length >= 6;
        if (isStandardLogInfo) {
            //过滤掉多余的符号
            String newLogLine = logLine.replace("- - ", "")
                    .replaceFirst("\\[", "")
                    .replace(" +0000]", "");

            //如果访问时间不存在，也是一个不正确的日志信息
            List<String> logInfoGroup = Arrays.asList(newLogLine.split("`"));
            String oldDateFormat = logInfoGroup.get(3);
            if (oldDateFormat == "-")
                return "";

//            //判断是否符合正则表达式要求
//            String[] items = {
//                    "(?<ip>\\S+)",                     // ip
//                    "(?<user>\\S*)",                   // user
//                    "(?<time>.+)",                     // time
//                    "(?<request>.*)",                  // request
//                    "(?<status>[0-9]+)",               // status
//                    "(?<size>[0-9-]+)",                // size
//                    "(?<referer>.*)",                  // referer
//                    "(?<agent>.*)"                     // user agent
//            };

            Pattern re = Pattern.compile(StringUtils.join(items, "`") + "\\s*\\Z");
            Matcher m = re.matcher(newLogLine);
            boolean res = m.matches();

            if (res) {
                Hashtable<Integer, String> dict = new Hashtable<>();
                dict.put(15, m.group("ip"));
                dict.put(14, m.group("loginname"));
                dict.put(13, m.group("username"));
                dict.put(12, m.group("receivetime"));
                dict.put(11, m.group("url"));
                dict.put(10, m.group("status"));
                dict.put(9, m.group("size"));
                dict.put(8, m.group("referurl"));
                dict.put(7, m.group("agent"));
                dict.put(6, m.group("cookie"));
                dict.put(5, m.group("getsize"));
                dict.put(4, m.group("postsize"));
                dict.put(3, m.group("forwarded"));
                dict.put(2, m.group("host"));
                dict.put(1, m.group("time"));

                if (dict.get(9).equals("-")) {
                    dict.put(9, "0");
                }
                for (int key : dict.keySet()) {
                    if (dict.get(key) == "-") {
                        dict.replace(key, "");
                    }
                }
                return StringUtils.join(dict.values(), "|");
            } else {
                return "";
            }
        } else {
            return "";
        }
    }
}
