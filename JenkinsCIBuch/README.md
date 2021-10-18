# Continuous Integration mit Jenkins

## Das Handbuch für Entwickler und DevOps-Teams

Moderne Softwareentwicklung  besteht aus viel mehr als nur aus Code und Kaffee. Ohne passende  Deployment-Strategien und eine saubere Release-Verwaltung laufen selbst  kleine Projekte schnell aus dem Ruder und werden unbeherrschbar. 

Dieses Praxisbuch zeigt Ihnen, wie Sie mit Jenkins, Git und Nexus eine  CI-Pipeline aufbauen. Erfahren Sie direkt aus der Praxis, was für  erfolgreiche Software-Projekte essentiell ist: Source Control  Management, flächendeckende Softwaretests mit einer sinnvollen  Qualitätskontrolle und ein gut organisiertes Deployment. Marco Schulz  gibt Ihnen seine Erfahrung aus zahlreichen internationalen IT-Projekten  weiter und hält eine Menge Tipps und Überlegungen zu gutem Software  Engineering für Sie parat. 

- Schritt für Schritt durch die CI-Pipeline: fetch, build, deploy
- Source Control und Release Management mit Git und Nexus
- Integrations- und Unit-Tests, richtiges Merging, saubere Codeanalyse

Zum Buch: https://www.rheinwerk-verlag.de/continuous-integration-mit-jenkins/

Homepage: https://elmar-dott.com

Coding Beispiele:

- chapter04.1 Test Driven Development (Maven/Java)
  - JUnit5Test
  - JUnit5PrameterizedTest
  - BeanMatcherTest
  
- chapter04.2 Behavioral Driven Development (Maven/Java)

  - JGivenBddIT

- chapter04.3 Integration Test (Maven/Java)

  - RestEmbeddedServerTest

- chapter07.3

  - install docker on ubuntu 
  - create Jenkins docker container
  - Dockerfile - Listing 7.3
  - ssh_config - Listing 7.4

- chapter08.5 (.NET)

  - DbUP.cs

- chapter08.6 (Java Build Logiic)

  - Apache ANT Sample

  - Apache Maven Sample

  - Gradle Sample

- chapter08.7 (JavaScript)

  - NPM, Bower & Grunt

- chapter08.8 (Android)

  - Maven sample POM 

- chapter08.9

  - docker-compose for PHP / Apache / MySQL & PhpMyAdmin
  - Dockerfile (Ruby) - Listing 8.13

- chapter09.3 (Jenkins Job DSL)

  - LinearePipeline.groovy
  - ParalellPipeline.groovy

- chapter09.4 (Jenkins JobDSL)

  - Jenkins Seed Job

- chapter10 (Java/Maven)

  - pom.xml - full configured for reporting

- chapter11 (Java / Maven)

  - pom.xml - Full sample for publischig on MVN central
  - PipelineStep.groovy - Publish to Nexus OSS Repository Manager
