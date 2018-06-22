## Microservices architecture with Jenkis CI

# Compiling Microservices

After cloning project open folder micro-services and run the command below:
```
mvn clean install
```

# Running microservices

To run the micro-services you can just use any idea that can compile spring projects or using docker running the command below:
```
docker-compose up --build
```

If you are running for the seccond time without changes, the flag --build is not necessary