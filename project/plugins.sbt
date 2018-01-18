import sbt.Resolver

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.7")

addSbtPlugin("org.flywaydb" % "flyway-sbt" % "4.2.0")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")

addSbtPlugin("com.heroku" % "sbt-heroku" % "2.1.0")

addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "1.3.0")

addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC13")

addSbtPlugin("com.codacy" % "sbt-codacy-coverage" % "1.3.11")

resolvers += Resolver.typesafeRepo("releases")

resolvers += "Flyway" at "https://davidmweber.github.io/flyway-sbt.repo"
