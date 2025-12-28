package com.main;

import com.service.GreetingService;

public class MainApp {
    public static void main(String[] args) {
        GreetingService service = new GreetingService();
        String message = service.sayHello("JPMS");
        System.out.println(message);
    }
}
