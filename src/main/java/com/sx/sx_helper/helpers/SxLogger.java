package com.sx.sx_helper.helpers;

import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

public class SxLogger {

    private static final org.slf4j.Logger errorLogger = LoggerFactory.getLogger("com.scalexyz.error");
    private static final org.slf4j.Logger infoLogger = LoggerFactory.getLogger("com.scalexyz.info");
    private static final org.slf4j.Logger debugLogger = LoggerFactory.getLogger("com.scalexyz.debug");

    public static void error(Object error) {
        if (error instanceof Exception) {
            error = ((Exception) error).getMessage();
        }
        errorLogger.error(error == null ? "NULL" : error.toString());
    }

    public static void error(String tag, Object error) {
        if (error instanceof Exception) {
            error = ((Exception) error).getMessage();
        }
        errorLogger.error(MarkerFactory.getMarker(tag), error == null ? "NULL" : error.toString());
    }

    public static void info(Object info) {
        infoLogger.info(info == null ? "NULL" : info.toString());
    }

    public static void info(String tag, Object info) {
        infoLogger.info(MarkerFactory.getMarker(tag), info == null ? "NULL" : info.toString());
    }

    public static void debug(Object debug) {
        debugLogger.debug(debug == null ? "NULL" : debug.toString());
    }

    public static void debug(String tag, Object debug) {
        debugLogger.debug(MarkerFactory.getMarker(tag), debug == null ? "NULL" : debug.toString());
    }
}
