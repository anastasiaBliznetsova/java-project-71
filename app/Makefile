	.DEFAULT_GOAL := build-run

run-dist:
	./build/install/app/bin/app
	
setup:
	gradle wrapper --gradle-version 8.3

clean:
	./gradlew clean

build:
	./gradlew clean build

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release


build-run: build run

.PHONY: build
