./gradlew build

docker build --tag=fauzdar-dev .
docker run --publish=8080:8080 --rm=true --name=fauzdar-dev fauzdar-dev