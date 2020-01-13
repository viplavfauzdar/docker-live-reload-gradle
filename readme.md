# Remote Live Reload

This is a demo of Remote Live Reloading of an application in development running inside of a docker container (or a remote VM or server) using spring-boot-devtools.

## Spring Boot Devtools

Spring boot devtools is meant to bs used in inside of the IDE. For that reason spring by default blocks the detools jar from being packaged inside of the application jar, because it assumes that its for production deployment.

### Devtools config

***Gradle***
```
bootJar {
	excludeDevtools = false
}
```
***Maven***  
```
<configuration>
    <excludeDevtools>false</excludeDevtools>
</configuration>
```

### Run Configuration

***IntelliJ***
Next create a run configuration as follows. What this does is it uses devtols remote spring application feature. Which essentially is an embeded application with end points that listen to class changes.
```
Main Class: org.springframework.boot.devtools.RemoteSpringApplication
Program Argument: http://localhost:8080
```

### Running the application ###
Execute the included dockerbuild.sh
```
$ ./dockerbuild.sh
```
This will build and deploy the application jar inside the docker container.

Next, run the spring remote application locally inside the IDE.

### Testing remote reload
Now make changes to a class or classes and you'll see in your console output that the changes are pushed to the docker container.

```
LiveReload server is running on port 35729
Uploaded 1 class resource
Remote server has changed, triggering LiveReload
```

In the docker container logs you'll see it reloading the application

```
/.~~spring-boot!~/restart
```

