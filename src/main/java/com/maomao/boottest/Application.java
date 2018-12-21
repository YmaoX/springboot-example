package com.maomao.boottest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.ZoneId;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(final String[] args) throws UnknownHostException {
		final SpringApplication app = new SpringApplication(Application.class);
		final ConfigurableApplicationContext context = app.run(args);
		final ConfigurableEnvironment env = context.getEnvironment();

		//@formatter:off
        logger.info("\n----------------------------------------------------------\n\t"
        		+ "Application '{}' is running!\n\t"
        		+ "Local      : \thttp://127.0.0.1:{}\n\t"
        		+ "External   : \thttp://{}:{}\n\t"
        		+ "Locale     : \t{}\n\t"
        		+ "Timezone   : \t{}\n\t"
        		+ "Cores      : \t{}"
        		+ "\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            env.getProperty("server.port"),
            InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"),
            Locale.getDefault().toString(),
            ZoneId.systemDefault().toString(),
            Runtime.getRuntime().availableProcessors());
        //@formatter:on
	}

}
