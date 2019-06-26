FROM java:8
WORKDIR /fauz
ADD ./build/libs/fauzdar-0.0.1-SNAPSHOT.jar /fauz/fauzdar.jar
CMD java -jar fauzdar.jar