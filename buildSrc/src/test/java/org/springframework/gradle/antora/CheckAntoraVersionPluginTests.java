package org.springframework.gradle.antora;

import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.provider.Property;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CheckAntoraVersionPluginTests {

	@Test
	void go() {
		Project project = ProjectBuilder.builder().build();
		project.setVersion("1.0.0-SNAPSHOT");
		project.getPluginManager().apply(CheckAntoraVersionPlugin.class);

		Task task = project.getTasks().findByName(CheckAntoraVersionPlugin.ANTORA_CHECK_VERSION_TASK_NAME);

	}

}
