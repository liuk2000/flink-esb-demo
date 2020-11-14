package com.example.demo;

import com.verbundo.boot.starter.FlinkEsbApplication;
import java.util.List;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.verbundo.boot, com.example.demo")
public class DemoApplication implements ApplicationRunner {

	public static void main(String[] args) {
		try {
			FlinkEsbApplication.start(DemoApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<String> appDefinition = args.getOptionValues("app.def");
		if (appDefinition == null || appDefinition.isEmpty()) {
			System.out.println("ERROR : Missing mandatory argument: --app.def=PATH_TO_APP_DEFINITION_FILE");
			System.exit(1);
		}
		FlinkEsbApplication.appDefinitionPath = appDefinition;
	}

}
