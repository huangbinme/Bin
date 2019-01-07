package com.jmx;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class HelloAgent {
    public static void main(String[] args) throws Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("chengang:name=HelloWorld");
        server.registerMBean(new Hello(), helloName);

        //#1 Managed by UI
//        ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
//        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
//        server.registerMBean(adapter, adapterName);
//        adapter.start();

        //#2 Managed by IP address
//        try {
//            //这个步骤很重要，注册一个端口，绑定url后用于客户端通过rmi方式连接JMXConnectorServer
//            LocateRegistry.createRegistry(9999);
//            //URL路径的结尾可以随意指定，但如果需要用Jconsole来进行连接，则必须使用jmxrmi
//            JMXServiceURL url = new JMXServiceURL
//                    ("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
//            JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, server);
//            System.out.println("begin rmi start");
//            jcs.start();
//            System.out.println("rmi start");
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //#3 use MBean's Notification
        ServerConfigureNotificationListener listener = new ServerConfigureNotificationListener();
        // 加入MBeanServer
        server.addNotificationListener(helloName, listener, null, null);
        Thread.sleep(Long.MAX_VALUE);

    }
}
