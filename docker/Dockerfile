FROM jenkins/jenkins:lts
#Realizar la instalacion de Maven con usuario root
USER root
ARG MAVEN_VERSION=3.5.3
ARG USER_HOME_DIR="/root"
ARG SHA=b52956373fab1dd4277926507ab189fb797b3bc51a2a267a193c931fffad8408
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries

#Instalacion de maven
RUN mkdir -p /usr/share/maven /usr/share/maven/ref && \
     curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
     echo "${SHA}  /tmp/apache-maven.tar.gz" | sha256sum -c - && \
     tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 && \
     rm -f /tmp/apache-maven.tar.gz && \
     ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

#Variables de entorno para configurar maven a utilizar dentro de Jenkins
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
ENV MAVEN /usr/bin/mvn
# Copiar archivo con plugins a instalar
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
# Instalar plugins
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

ENTRYPOINT /sbin/tini -- /usr/local/bin/jenkins.sh













