.PHONY: build run test format check lint clean

ifeq ($(OS),Windows_NT)
MVN := mvnw.cmd
else
MVN := ./mvnw
endif

build:
	$(MVN) clean package

run:
	$(MVN) spring-boot:run

test:
	$(MVN) test

format:
	$(MVN) spotless:apply

lint:
	$(MVN) spotless:check checkstyle:check

check:
	$(MVN) clean verify

clean:
	$(MVN) clean