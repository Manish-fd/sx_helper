package com.sx.sx_helper.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SxConfig {
    @JsonProperty("baseUrl")
    private String baseUrl;
    @JsonProperty("resourceUrl")
    private String resourceUrl;
    @JsonProperty("fcmKey")
    private String fcmKey;
    @JsonProperty("testMode")
    private boolean testMode;
    @JsonProperty("chunkSize")
    private int chunkSize;
    @JsonProperty("maxPoolLimit")
    private int maxPoolLimit;
    @JsonProperty("assetsPath")
    private String assetsPath;
    @JsonProperty("samplesPath")
    private String samplesPath;
    @JsonProperty("profilePath")
    private String profilePath;
    @JsonProperty("mediaPath")
    private String mediaPath;
    @JsonProperty("exportsPath")
    private String exportsPath;
    @JsonProperty("filesPath")
    private String filesPath;
    @JsonProperty("storagePath")
    private String storagePath;
    @JsonProperty("twilio_token")
    private String twilio_token;
    @JsonProperty("twilio_sid")
    private String twilio_sid;
    @JsonProperty("sendSmsNumberLimit")
    private int sendSmsNumberLimit;
    @JsonProperty("whatsappNumber")
    private String whatsappNumber;
    @JsonProperty("mongoUri")
    private String mongoUri;

    public static SxConfig getInstance() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String projectPath = new File("").getAbsolutePath();
            if(!projectPath.endsWith("sx")) {
                projectPath = projectPath.substring(0, projectPath.lastIndexOf("/"));
            }
            return mapper.readValue(new File(projectPath + "/config.json"), SxConfig.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
