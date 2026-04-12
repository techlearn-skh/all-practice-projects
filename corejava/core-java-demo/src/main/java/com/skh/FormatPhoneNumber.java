package com.skh;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final public class FormatPhoneNumber {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("mobileNumber", "9066444878");
        map.put("homeNumber", "9848239232");
//        map.put("workNumber",null);
        Map<String, String> stringStringMap = new FormatPhoneNumber().formatPhoneNumbers23(map);
        System.out.println(stringStringMap);

    }

    public static String formatPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number. Must be 10 digits.");
        }
        return String.format("%s-%s-%s",
                phoneNumber.substring(0, 3),
                phoneNumber.substring(3, 6),
                phoneNumber.substring(6));
    }

    public static void formatPhoneNumbers(Map<String, String> phoneMap) {
        Arrays.asList("mobileNumber", "homeNumber", "workNumber")
                .stream()
                .filter(phoneMap::containsKey)
                .forEach(key -> phoneMap.computeIfPresent(key, (k, v) -> formatPhoneNumber(v)));
    }

    public static void checkForAdobeTargetExperienceToken() {
        Pattern pattern = Pattern.compile("<%[\\s]?(\\w+)([:][\\w,#.|]*)?[\\s]?%>");
        String content = "Hello <% PRIM_FIRST_NAME %> <% PRIM_LAST_NAME:CAMELCASE %>";
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public Map<String, String> formatPhoneNumbers2(Map<String, String> phoneMap) {
        Arrays.asList("mobileNumber", "homeNumber", "workNumber")
                .forEach(key -> {
                    phoneMap.computeIfAbsent(key, k -> "none added");
                    phoneMap.computeIfPresent(key, (k, v) -> {
                        if (v == null | v.equals("none added")) {
                            return "none added";
                        }
                        return formatPhoneNumber(v);
                    });
                });
        return phoneMap;
    }

    public Map<String, String> formatPhoneNumbers23(Map<String, String> phoneMap) {
        Arrays.asList("mobileNumber", "homeNumber", "workNumber")
                .forEach(key -> {
                    phoneMap.computeIfAbsent(key, k -> "none added");
                    phoneMap.
                            computeIfPresent(key, (k, v) -> v.replaceAll("(?<!\\d)(\\d{3})(\\d{3})(\\d{4})(?!\\d)", "$1-$2-$3"));
                });
        return phoneMap;
    }

}
