package uz.com.appwarehouse.config;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean(name = "velocityEngine")
    public VelocityEngine velocityEngineFactoryBean() {
        Properties properties = new Properties();
        properties.setProperty("resource.loader", "classpath");
        properties.setProperty("classpath.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        properties.setProperty("input.encoding", "UTF-8");
        properties.setProperty("output.encoding", "UTF-8");
        try {
            VelocityEngineFactoryBean velocity = new VelocityEngineFactoryBean();
            velocity.setPreferFileSystemAccess(false);
            velocity.setVelocityProperties(properties);
            return velocity.createVelocityEngine();
        } catch (IOException e) {
            throw new RuntimeException("Unable to create velocity engine instance");
        }
    }

}
