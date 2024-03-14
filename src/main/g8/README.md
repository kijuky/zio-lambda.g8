# $name$ (by zio-lambda-template)

# Preparation

- Docker
- sbt (via coursier)

# Build

```shell
sbt GraalVMNativeImage/packageBin
```

## Use zip file

```shell
zip -j upload.zip bootstrap target/graalvm-native-image/$name$
```

## Use docker image

```shell
docker build -t $name$ .
pass=\$(aws ecr get-login-password --region <your_AWS_REGION>)
docker login --username <your_AWS_USERNAME> --password \$pass <your_AWS_ECR_REPO>
docker tag $name$ <your-particular-ecr-image-repository>:<your-tag>
docker push <your-particular-ecr-image-repository>:<your-tag>
```
