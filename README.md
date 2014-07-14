
# Getting started

1. Make sure you have java 1.6
2. git clone https://github.com/raghu-b/blackjack-java
3. Make sure you are in the BlackJack directory
4. java -jar trunk/target/BlackJack.jar

Javadocs for Project can be found in the docs directory.
Basic JUnit tests for each class can be found in the test directory.


# Compiling BlackJack

 1. make sure you have maven 3.4.0
 2. go to trunk folder 
 3. mvn clean install 
 

# Maven Installation 

 1.First of all, you need to install Java 1.7 JDK. Make sure to install Java JDK, not JRE.

 2.Then go ahead and download the latest Maven binary from its official site. For example, for version 3.0.4:

 3. wget http://mirror.cc.columbia.edu/pub/software/apache/maven/maven-3/3.0.5/binaries/apache-maven-3.0.5-bin.tar.gz
 4. sudo tar xzf apache-maven-3.0.5-bin.tar.gz -C /usr/local
 5. cd /usr/local
 6. sudo ln -s apache-maven-3.0.5 maven
 

 Next, set up Maven path system-wide:

 7. sudo vi /etc/profile.d/maven.sh
   export M2_HOME=/usr/local/maven
   export PATH=${M2_HOME}/bin:${PATH}

 8.Finally, log out and log in again to activate the above environment variables.
 To verify successful installation of maven, check the version of maven:

 9. mvn -version
