package gg.zffu.skyblockessentials.utils;

public class StringUtils {
    public static String cleanColour(String in) {
        return in.replaceAll("(?i)\\u00A7.", "");
    }
}
