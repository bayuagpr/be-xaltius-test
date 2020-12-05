package com.xaltius.be.route;

import com.xaltius.be.handler.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RouterFunctions.route;

@Component
public class PersonRoute {
    @Bean
    RouterFunction<ServerResponse> routes(PersonHandler personHandler){
        return route()
                .POST("/process/age",personHandler::handleGetPersonColor)
                .build();
    }
}
