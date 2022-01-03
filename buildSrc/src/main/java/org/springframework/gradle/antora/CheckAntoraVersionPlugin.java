package org.springframework.gradle.antora;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class CheckAntoraVersionPlugin implements Plugin<Project> {
	public static final String ANTORA_CHECK_VERSION_TASK_NAME = "antoraCheckVersion";

	@Override
	public void apply(Project project) {
		project.getTasks().register(ANTORA_CHECK_VERSION_TASK_NAME, CheckAntoraVersionTask.class, new Action<CheckAntoraVersionTask>() {
			@Override
			public void execute(CheckAntoraVersionTask antoraCheckVersion) {
				String version = String.valueOf(project.getVersion());
				antoraCheckVersion.getVersion().convention(version);
				antoraCheckVersion.getAntoraYmlFile().convention(project.file("antora.yml"));
			}
		});
	}
}
