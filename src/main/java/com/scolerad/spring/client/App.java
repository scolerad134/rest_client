package com.scolerad.spring.client;

import com.scolerad.spring.client.communication.Communication;
import com.scolerad.spring.client.configuration.MyConfig;
import com.scolerad.spring.client.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
    }
}
