package com.sx.sx_helper.helpers;

import com.sx.sx_helper.config.SxConfig;

class ResourceType {

    static String STORAGE_DIR = "";
    static String FILES = "files";
    static String EXPORT = "exports";
    static String MEDIA = "media";
    static String PROFILE = "profile";
    static String SAMPLES = "samples";
    static String ASSETS = "assets";

    static String url(String type) {
        return SxConfig.getInstance().getResourceUrl() + "/" + type + "/";
    }
}