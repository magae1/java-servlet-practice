package com.demo.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
    private int sessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionCount++;
        System.out.println("[리스너]Session created: " + se.getSession().getId());
        System.out.println("[리스너]Session count: " + sessionCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionCount--;
        System.out.println("[리스너]Session destroyed: " + se.getSession().getId());
        System.out.println("[리스너]Session count: " + sessionCount);
    }
}
