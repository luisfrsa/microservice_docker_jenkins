package com.allanperes.mentoria.batch.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rest")
public class ServicesProperties {

    private String gatewayUri;

    public String getGatewayUri() {
        return gatewayUri;
    }

    public void setGatewayUri(String gatewayUri) {
        this.gatewayUri = gatewayUri;
    }
}
