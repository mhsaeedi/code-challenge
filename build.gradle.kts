plugins {
	`java-library`
}
repositories {
	mavenCentral()
}

dependencies {
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
	testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.1")
	testImplementation("org.junit.platform:junit-platform-runner:1.8.2")
	testImplementation("org.mockito:mockito-junit-jupiter:4.3.1")
}

configurations {
	implementation {
		resolutionStrategy.failOnVersionConflict()
	}
}

sourceSets {
	main {
		java.srcDir("src/main/java")
	}
}
java {
	sourceCompatibility = JavaVersion.VERSION_11
	targetCompatibility = JavaVersion.VERSION_11
}
tasks.test {
	useJUnitPlatform()
	extensions
}
