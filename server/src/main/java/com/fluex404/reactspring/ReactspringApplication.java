package com.fluex404.reactspring;

import com.fluex404.reactspring.domain.ProjectTask;
import com.fluex404.reactspring.repository.ProjectTaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ReactspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactspringApplication.class, args);
	}

}

@Component
@ConditionalOnProperty(name = "com.fluex404.database.reset", havingValue = "true")
class MyCommandLineRunnder implements CommandLineRunner {
	@Autowired
	private ProjectTaskDao dao;

	@Override
	public void run(String... args) throws Exception {
//		List<ProjectTask> projectTasks = Stream.of(
//				new ProjectTask("new Project Task1", "create Project Board", "TO_DO"),
//				new ProjectTask("new Project Task2", "create Project Board", "TO_DO"),
//				new ProjectTask("new Project Task3", "create Project Board", "TO_DO")
//		).collect(Collectors.toList());

		List<ProjectTask> projectTasks = Arrays.asList(
				new ProjectTask("new Project Task1", "create Project Board", "TO_DO"),
				new ProjectTask("new Project Task2", "create Project Board", "TO_DO"),
				new ProjectTask("new Project Task3", "create Project Board", "TO_DO")
		);
		dao.saveAll(projectTasks);
	}
}