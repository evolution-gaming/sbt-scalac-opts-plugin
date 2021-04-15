import ScriptedPlugin.autoImport._
import Artifactory._

sbtPlugin := true

name := "sbt-scalac-opts-plugin"

organization := "com.evolution"

description := "Scalac options for sbt projects"

homepage := Some(new URL("https://github.com/evolution-gaming/sbt-scalac-opts-plugin"))

startYear := Some(2019)

organizationName := "Evolution"

organizationHomepage := Some(url("https://evolution.com"))

scalaVersion := crossScalaVersions.value.head

crossScalaVersions := Seq("2.12.12")

crossSbtVersions := Seq("1.5.0")

publishTo := Some(Resolver.artifactory("evolution", "maven-local-sbt-plugins"))

publishMavenStyle := true

licenses := Seq(("MIT", url("https://opensource.org/licenses/MIT")))

releaseCrossBuild := true

scriptedBufferLog := false

scriptedLaunchOpts := Seq("-Xmx1G", s"-Dplugin.version=${version.value}")

enablePlugins(SbtPlugin)

addCommandAlias("build", ";clean; coverage; test; scripted")