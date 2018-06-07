package com.karthik.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
@WebListener
public class MyServletContextListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MyServletContextListener() {
        System.out.println(this.getClass().getName() + " instantiated");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("Listener : New Session Created => " + se.getSession().getId());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("Listener : Session destroyed => " + se.getSession().getId());
    }
	
}
