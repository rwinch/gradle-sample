package org.springframework.gradle.antora;

import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.TaskAction;
import org.gradle.internal.impldep.org.yaml.snakeyaml.Yaml;
import org.gradle.internal.impldep.org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class CheckAntoraVersionTask extends DefaultTask {

	@TaskAction
	public void check() throws FileNotFoundException {

	}

	@Input
	public abstract Property<String> getVersion();

//	public void setVersion(String version) {
//		getVersion().set(version);
//	}

}
