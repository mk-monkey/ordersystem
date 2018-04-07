package com.mkmonkey.sell.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Class Name: WebSocketConfig
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-04-07 15:16
 **/
@Component
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
