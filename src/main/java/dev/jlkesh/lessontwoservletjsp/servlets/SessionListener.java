package dev.jlkesh.lessontwoservletjsp.servlets;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.extern.java.Log;

import java.util.concurrent.atomic.AtomicLong;

@Log
public class SessionListener implements HttpSessionListener {
    private AtomicLong counter = new AtomicLong(0);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setMaxInactiveInterval(3 * 60);
        log.info("New Session Created : " + session.getId());
        log.info("Active Users Count : " + counter.getAndIncrement());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        log.info("Session Destroyed : " + session.getId());
        log.info("Active Users Count : " + counter.decrementAndGet());
    }
}
