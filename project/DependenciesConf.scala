import sbt.Keys._
import sbt._


object DependenciesConf {

  lazy val scala: Seq[Setting[_]] = Seq(
    scalaVersion := "2.12.2",
    resolvers ++= Seq(
      Resolver.jcenterRepo,
      Resolver.sonatypeRepo("releases")
    )
  )

  lazy val common: Seq[Setting[_]] = scala ++ Seq(
    libraryDependencies ++= commonDeps
  )

  lazy val akka: Seq[Setting[_]] = scala ++ Seq(
    libraryDependencies ++= akkaDeps
  )

  def commonDeps = Seq(
    // logging
    "ch.qos.logback" % "logback-classic" % "1.2.3",

    // scala
    "org.log4s" %% "log4s" % "1.3.6",
    "com.github.pathikrit" %% "better-files" % "3.1.0",
    "com.beachape" %% "enumeratum" % "1.5.12",
    "com.github.nscala-time" %% "nscala-time" % "2.16.0",

    // typelevel
    "com.chuusai" %% "shapeless" % "2.3.2",
    "com.github.pureconfig" %% "pureconfig" % "0.8.0",
    "com.github.pureconfig" %% "pureconfig-enumeratum" % "0.8.0",
    "eu.timepit" %% "refined" % "0.8.2",
    "eu.timepit" %% "refined-pureconfig" % "0.8.2",
    "org.typelevel" %% "cats" % "0.9.0",
    "org.typelevel" %% "cats-effect" % "0.4-09e64a7",

    // twitter
    "com.twitter" %% "util-core" % "7.0.0",

    // test
    "org.scalatest" %% "scalatest" % "3.2.0-SNAP9" % Test,
    "org.scalacheck" %% "scalacheck" % "1.13.5" % Test,
    "eu.timepit" %% "refined-scalacheck" % "0.8.2" % Test,
    "org.scalamock" %% "scalamock-scalatest-support" % "3.6.0" % Test
  )

  def akkaDeps = {
    val akkaVersion = "2.5.4"
    Seq(
      "com.typesafe.akka" %% "akka-actor" % akkaVersion,
      "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
      "com.typesafe.akka" %% "akka-remote" % akkaVersion,
      "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
      "com.typesafe.akka" %% "akka-multi-node-testkit" % akkaVersion % Test
    )
  }
}