package sample;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class CheckAntoraVersionPlugin implements Plugin<Project> {

	public static final String CHECK_ANTORA_VERSION_TASK_NAME = "checkAntoraVersion";

	@Override
	public void apply(Project project) {
		project.getTasks().register(CHECK_ANTORA_VERSION_TASK_NAME, CheckAntoraVersionTask.class);
	}
}
