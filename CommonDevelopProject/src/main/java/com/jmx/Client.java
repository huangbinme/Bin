package com.jmx;

import javax.management.Attribute;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.Arrays;

public class Client {
    public static void main(String[] args) throws Exception{
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
        JMXConnector jmxc = JMXConnectorFactory.connect(url,null);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
        ObjectName mbeanName = new ObjectName("chengang:name=HelloWorld");

        System.out.println("Domains ......");
        String[] domains = mbsc.getDomains();

        System.out.println(Arrays.asList(domains));
        System.out.println("We have "+domains.length+" domains!");

        //mbsc.setAttribute(mbeanName, new Attribute("Name","杭州"));
        String name = (String)mbsc.getAttribute(mbeanName, "Name");
        System.out.println("name=" +name);

        HelloMBean proxy = MBeanServerInvocationHandler.newProxyInstance(mbsc, mbeanName, HelloMBean.class, false);
        proxy.setName("From Client!");
        proxy.printHello();


    }
}
