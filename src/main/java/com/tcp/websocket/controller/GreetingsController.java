package com.tcp.websocket.controller;

import com.tcp.websocket.Greetings;
import com.tcp.websocket.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingsController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greetings greet(HelloMessage message){
        return  new Greetings("Hello, "+ HtmlUtils.htmlEscape(message.getName()));
    }

}
