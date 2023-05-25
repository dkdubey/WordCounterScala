lazy val root = (project in file("."))
  .settings(
    name := "word-count-microservice",
    scalaVersion := "2.13.8",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.2.4",
      "com.typesafe.akka" %% "akka-http-spray-json" % "10.2.4",
      "com.typesafe.akka" %% "akka-stream" % "2.6.15",
      "com.typesafe.akka" %% "akka-actor-typed" % "2.6.15",
      "org.scalatest" %% "scalatest" % "3.2.10" % Test
    )
  )
