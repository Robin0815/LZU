package org.hbrs.ooka.ws2020.uebung2.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication//(scanBasePackages = {"org.hbrs.ooka.ws2020.uebung2"})
public class StartEnv extends SpringBootServletInitializer {
    public static void main(String[] args) {
        /*RuntimeEnv re = new RuntimeEnv();
                re.initComponent("Counter");
                re.startComp("Counter");*/
        //System.setProperty("server.port", "8081");
        //System.setProperty("spring.profiles.active", "dev");
        SpringApplication.run(StartEnv.class, args);
        //CLI cli = new CLI();
        //cli.startCli();

        /*Component com = con.search("Client");
        Class cla = com.getC();
        Method method = null;
        Method[] meth = cla.getMethods();
        for (Method me : meth) {
            System.out.println(me.getName());
        }
        method = cla.getMethod("main", String[].class);
        System.out.println("Method was created successfully");

        String[] params = new String[0];

        method.invoke(null, (Object) params);
        System.out.println("Method run successfully");*/

    }
}