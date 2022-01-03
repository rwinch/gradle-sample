package sample;

import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckAntoraVersionPluginTest {
	@Test
	void checkAntoraVersionTaskDefaults() {
		Project project = ProjectBuilder.builder().build();
		project.getPluginManager().apply(CheckAntoraVersionPlugin.class);

		Task checkAntoraVersionTask = project.getTasks().findByName(CheckAntoraVersionPlugin.CHECK_ANTORA_VERSION_TASK_NAME);
	}

}