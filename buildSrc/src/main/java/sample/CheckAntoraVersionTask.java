package sample;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public abstract class CheckAntoraVersionTask extends DefaultTask {
	@Input
	public abstract Property<String> getVersion();

	@TaskAction
	public void run() {

	}
}
