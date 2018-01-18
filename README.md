# starter_scala_play
Scala/Play/Flyway/Codacy starter project

This is a starter project in Scala with:
- Play framework
- Flyway migrate (including a sample migration)
- Heroku/Codacy infra support
- Anorm and PostgreSQL

To get started:
- Review conf/application.conf
- Set up a DB according to the DB db.default.url in application.conf
- Change package names if needed, project name in build.sbt
- Run SBT Task: flywayMigrate
- Run the Test: HomeControllerSpec.scala
- Run SBT Task: ~run

