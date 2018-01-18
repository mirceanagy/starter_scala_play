name := """starter"""
organization := "com.hibob"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  guice,
  jdbc,
  ws,
  "com.typesafe.play" %% "anorm" % "2.5.3",
  "org.flywaydb" %% "flyway-play" % "4.0.0",
  "org.postgresql" % "postgresql" % "9.4.1208",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test,
  "org.mockito" % "mockito-core" % "1.9.5" % Test,
  "io.swagger" %% "swagger-play2" % "1.6.0",
  "org.webjars" % "swagger-ui" % "2.2.10",
  "com.neovisionaries" % "nv-i18n" % "1.22"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.hibob.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.hibob.binders._"

scalacOptions in Compile ++= Seq(
  "-Xfatal-warnings",
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-feature",
  "-unchecked",
  "-Ywarn-dead-code",
  "-Ywarn-value-discard",
  "-Xfuture"
)

resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(
  Resolver.ivyStylePatterns
)

flywayUrl := {
  val dbUrlRegex = "^postgres:\\/\\/([^:]+):([^\\.]+)@([^:]+):(\\d+)\\/(.+)$".r
  val herokuDbUrl = System.getenv("HEROKU_DATABASE_URL")
  herokuDbUrl match {
    case dbUrlRegex(user, password, host, port, dbName) =>
      f"jdbc:postgresql://$host:$port/$dbName?user=$user&password=$password&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory"
    case _ => {
      import com.typesafe.config._
      val confFile = System.getProperty("config.resource", "application.conf")
      val conf = ConfigFactory.parseFile(new File(s"conf/$confFile")).resolve()
      conf.getString("db.default.url")
    }
  }
}

flywayLocations := Seq("classpath:db.migration.default")

javaOptions in Test += "-Dlogger.file=test/logback-test.xml"

coverageExcludedPackages := "<empty>;Reverse.*"

herokuAppName in Compile := "hibob-provision"

herokuJdkVersion in Compile := "1.8"

herokuBuildpacks in Compile := Seq("heroku/metrics", "jvm-common")
