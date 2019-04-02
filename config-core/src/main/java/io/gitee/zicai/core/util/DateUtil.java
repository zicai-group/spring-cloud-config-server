package io.gitee.zicai.core.util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Optional;

/**
 * DateUtil
 *
 * @author zicai
 * @since 2018-07-17
 */
public abstract class DateUtil {

    public static final String YMD = "yyyy-MM-dd";
    public static final String HMS = "HH:mm:ss";
    public static final String YMD_HMS = YMD + " " + HMS;

    public static LocalDateTime toLocalDateTime(Date date) {
        return Optional.ofNullable(date)
                .map(Date::toInstant)
                .map(Timestamp::from)
                .map(Timestamp::toLocalDateTime)
                .orElse(null);
    }

    public static LocalDate toLocalDate(Date date) {
        return Optional.ofNullable(date)
                .map(DateUtil::toLocalDateTime)
                .map(LocalDateTime::toLocalDate)
                .orElse(null);
    }

    public static LocalTime toLocalTime(Date date) {
        return Optional.ofNullable(date)
                .map(DateUtil::toLocalDateTime)
                .map(LocalDateTime::toLocalTime)
                .orElse(null);
    }

    public static Date toDate(LocalDateTime localDateTime) {
        return Optional.ofNullable(localDateTime)
                .map(Timestamp::valueOf)
                .map(Timestamp::toInstant)
                .map(Date::from)
                .orElse(null);
    }

    public static Date toDate(LocalDate localDate) {
        return Optional.ofNullable(localDate)
                .map(LocalDate::atStartOfDay)
                .map(DateUtil::toDate)
                .orElse(null);
    }

    public static Date toDate(LocalTime localTime) {
        return Optional.ofNullable(localTime)
                .flatMap(it -> Optional.of(LocalDate.now()).map(it::atDate))
                .map(DateUtil::toDate)
                .orElse(null);
    }

    public static LocalDateTime parseLocalDateTime(String date, String pattern) {
        return Optional.ofNullable(date)
                .map(DateTimeFormatter.ofPattern(pattern)::parse)
                .map(LocalDateTime::from)
                .orElse(null);
    }

    /**
     * 默认时间格式（yyyy-MM-dd HH:mm:ss）
     *
     * @param date 日期时间字符串
     * @return LocalDateTime
     */
    public static LocalDateTime parseLocalDateTime(String date) {
        return parseLocalDateTime(date, YMD_HMS);
    }

    public static LocalDate parseLocalDate(String date, String pattern) {
        return Optional.ofNullable(date)
                .map(DateTimeFormatter.ofPattern(pattern)::parse)
                .map(LocalDate::from)
                .orElse(null);
    }

    /**
     * 默认时间格式（yyyy-MM-dd）
     *
     * @param date 日期字符串
     * @return LocalDate
     */
    public static LocalDate parseLocalDate(String date) {
        return parseLocalDate(date, YMD);
    }

    public static LocalTime parseLocalTime(String date, String pattern) {
        return Optional.ofNullable(date)
                .map(DateTimeFormatter.ofPattern(pattern)::parse)
                .map(LocalTime::from)
                .orElse(null);
    }

    /**
     * 默认时间格式（HH:mm:ss）
     *
     * @param date 时间字符串
     * @return LocalTime
     */
    public static LocalTime parseLocalTime(String date) {
        return parseLocalTime(date, HMS);
    }

    public static String format(Date date, String pattern) {
        return Optional.ofNullable(date)
                .map(DateUtil::toLocalDateTime)
                .map(it -> DateUtil.formatter(it, pattern))
                .orElse(null);
    }

    public static String format(LocalDateTime localDateTime, String pattern) {
        return formatter(localDateTime, pattern);
    }

    public static String format(LocalDate localDate, String pattern) {
        return formatter(localDate, pattern);
    }

    public static String format(LocalTime localTime, String pattern) {
        return formatter(localTime, pattern);
    }

    private static String formatter(TemporalAccessor temporal, String pattern) {
        return Optional.ofNullable(temporal)
                .map(DateTimeFormatter.ofPattern(pattern)::format)
                .orElse(null);
    }
}
