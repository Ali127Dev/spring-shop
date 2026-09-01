.PHONY: build run test format check clean

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

check:
	$(MVN) clean verify

clean:
	$(MVN) clean