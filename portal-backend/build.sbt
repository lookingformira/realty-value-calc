ThisBuild / scalaVersion     := "2.13.9"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "org.scalalazy"
ThisBuild / organizationName := "Scalalazy"

lazy val root = (project in file("."))
    .settings(
      name := "innoagency-hackathon",
      libraryDependencies ++= Dependencies.zio ++
          Dependencies.zioConfig ++
          Dependencies.liquibase ++
          Dependencies.testContainers ++
          Dependencies.quill ++
//          Dependencies.tapir ++
          Seq(
            Dependencies.zioHttp,
            Dependencies.scalaTest,
            Dependencies.catsCore,
            Dependencies.logback,
            Dependencies.zioJson,
            Dependencies.bcrypt,
            Dependencies.zioPrelude,
            Dependencies.poi
          ),
      testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"),
      addCompilerPlugin(Dependencies.kindProjector)
    )


enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

Docker / packageName        := "realty-value-calc-backend"
Docker / dockerExposedPorts := Seq(8080)