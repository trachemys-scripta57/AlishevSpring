package ru.alishev.banana;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.alishev.banana")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

}
