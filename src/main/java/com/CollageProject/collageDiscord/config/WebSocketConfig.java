package com.CollageProject.collageDiscord.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;


// WebSocket configuration class. It tells Spring how to handle WebSocket connections and STOMP messaging. 

@Configuration
// make this class Spring configuration class so that spring can scan it and ue it to configure beans automatically !! 
@EnableWebSocketMessageBroker
// Enables WebSocket support in Spring.

// Enables STOMP messaging protocol over WebSocket.
// simple (streaming ) text orient message !!! 

public class WebSocketConfig  implements WebSocketMessageBrokerConfigurer {
 

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }
    // 
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}