import ScriptedPlugin.autoImport._

sbtPlugin := true

name := "sbt-scalac-opts-plugin"

organization := "com.evolution"

description := "Scalac options for sbt projects"

homepage := Some(url("https://github.com/evolution-gaming/sbt-scalac-opts-plugin"))

startYear := Some(2019)

organizationName := "Evolution"

organizationHomepage := Some(url("https://evolution.com"))

scalaVersion := crossScalaVersions.value.head

crossScalaVersions := Seq("2.12.21", "3.8.4")

(pluginCrossBuild / sbtVersion) := {
  scalaBinaryVersion.value match {
    case "2.12" => "1.5.0"
    case _      => "2.0.3"
  }
}

scriptedSbt := {
  scalaBinaryVersion.value match {
    case "2.12" => "1.5.0"
    case _      => "2.0.3"
  }
}

// the currently released sbt-scalac-opts-plugin (dogfooded on this very project via
// project/plugins.sbt) always adds -Xfatal-warnings, which Scala 3 flags as a deprecated
// alias and then fails on under -Werror; disable it for the Scala 3 leg until a Scala
// 3-aware release of this plugin can be dogfooded on itself.
scalacOptsFailOnWarn := (if (scalaBinaryVersion.value == "3") None else Some(true))

publishMavenStyle := true

licenses := Seq(("MIT", url("https://opensource.org/licenses/MIT")))

scmInfo := Some(ScmInfo(
  url("https://github.com/evolution-gaming/sbt-scalac-opts-plugin"),
  "git@github.com:evolution-gaming/sbt-scalac-opts-plugin.git"))

developers := List(
  Developer(
    "t3hnar",
    "Yaroslav Klymko",
    "t3hnar@gmail.comm",
    url("https://gitlab.com/t3hnar")))


versionScheme := Some("early-semver")

scriptedBufferLog := false

scriptedLaunchOpts := Seq("-Xmx1G", s"-Dplugin.version=${version.value}")

enablePlugins(SbtPlugin)

//addCommandAlias("check", "all versionPolicyCheck Compile/doc")
addCommandAlias("check", "show version")
addCommandAlias("build", ";clean; coverage; test; scripted")
