package com.file.manager.tools;

public class ToolsUtility {

    // 截取字符串
    public static String removePrefix(String str, String prefix) {
        if (str != null && str.startsWith(prefix)) {
            return str.substring(prefix.length());
        }
        return str; // 或抛异常/返回 null，根据需求
    }
}
