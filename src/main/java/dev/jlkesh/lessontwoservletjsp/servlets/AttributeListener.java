package dev.jlkesh.lessontwoservletjsp.servlets;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import org.postgresql.util.OSUtil;

public class AttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();
        if (name.equals("username")) {
            System.out.println("Attribute Added With name : " + event.getName() + ", Value : " + event.getValue());
        } else {
            System.out.println(event.getName() + " = Attribute Added");
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        String name = event.getName();
        if (name.equals("username")) {
            System.out.println("Attribute removed With name : " + event.getName() + ", Value : " + event.getValue());
        } else {
            System.out.println(event.getName() + " = Attribute Removed");
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}
