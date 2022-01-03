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
		File antoraYmlFile = getAntoraYmlFile().get();
		String version = getVersion().get();
		Yaml yaml = new Yaml(new Constructor(AntoraYml.class));
		AntoraYml antoraYml = yaml.load(new FileInputStream(antoraYmlFile));
		String expectedAntoraVersion = version.replace("-SNAPSHOT", "");
		String expectedAntoraPrerelease = version.endsWith("-SNAPSHOT") ? "-SNAPSHOT" : null;

		if (!antoraYml.getPrerelease().equals(expectedAntoraPrerelease) ||
				!antoraYml.getVersion().equals(expectedAntoraVersion)) {
			throw new GradleException("The Gradle version of " + version + " should have version: '" + expectedAntoraVersion + "' and prerelease: '" + expectedAntoraPrerelease + "' defined in " + antoraYmlFile);
		}
	}

	@InputFile
	public abstract Property<File> getAntoraYmlFile();

	public void setAntoraYmlFile(File antoraYmlFile) {
		getAntoraYmlFile().set(antoraYmlFile);
	}

	@Input
	public abstract Property<String> getVersion();

	public void setVersion(String version) {
		getVersion().set(version);
	}

	static class AntoraYml {
		private String version;

		private String prerelease;

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getPrerelease() {
			return prerelease;
		}

		public void setPrerelease(String prerelease) {
			this.prerelease = prerelease;
		}
	}
}
