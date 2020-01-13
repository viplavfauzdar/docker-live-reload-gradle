# Remote Live Reload

This is a demo of Remote Live Reloading of an application in development running inside of a docker container (or a remote VM or Server) using spring-boot-devtools.

## Spring Boot Devtools

Spring boot devtools is meant to bs used in inside of the IDE. For that reason spring by default blocks the devtools jar from being packaged inside of the application jar, because it assumes that its for production deployment.

The below configurations need to be made to your application after you've added devtools.

### Devtools Config

First thing to do is to tell spring to not exclude devtools jar from being packaged inside the application jar.

**Gradle**
> Add below config to 
> `build.gradle` 
```
bootJar {
	excludeDevtools = false
}
```
**Maven**
> Add below config to 
> `pom.xml`
```
<configuration>
    <excludeDevtools>false</excludeDevtools>
</configuration>
```

### Run Configuration

**IntelliJ**

Next create a run configuration as follows. What this does is it uses devtols remote spring application feature. Which essentially is an embeded application with end points that listen to class changes.
```
Main Class: org.springframework.boot.devtools.RemoteSpringApplication
Program Argument: http://localhost:8080
```

### Security
One thing to note is that how will the local instance of your application authenticate with the remote instance. 
> To achieve that you need to add the below line in your `application.properties`

What this essentially does is that when local changes are deployed to the remote instance, this entry is compared to make sure that the local and remote instances are actually the same.

```spring.devtools.remote.secret=mysecret```

### Running the application
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

In the docker container logs you'll see devtools listening for changes in classes and reloading the application.

```
Listening for remote restart updates on /.~~spring-boot!~/restart
```

