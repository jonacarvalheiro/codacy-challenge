FROM maven:3.5-alpine
MAINTAINER qae@jmc

RUN mkdir -p /opt/tests
ADD codacyTests.tar.gz /opt/tests
RUN chmod +x /opt/tests/codacyTests/build/run_tests.sh
RUN mvn install:install-file \
  -Dfile=/opt/tests/codacyTests/build/bugcatcher-0.1.0.jar \
  -DgroupId=qae \
  -DartifactId=bugcatcher \
  -Dversion=0.1.0 \
  -Dpackaging=jar
  
RUN cd /opt/tests/codacyTests/ && mvn install -Dmaven.test.skip=true

WORKDIR /opt/tests

CMD /opt/tests/codacyTests/build/run_tests.sh
