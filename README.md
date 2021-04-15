# sbt-scalac-opts-plugin 

[![Build Status](https://github.com/evolution-gaming/sbt-scalac-opts-plugin/workflows/CI/badge.svg)](https://github.com/evolution-gaming/sbt-scalac-opts-plugin/actions?query=workflow%3ACI)
[![Coverage Status](https://coveralls.io/repos/evolution-gaming/sbt-scalac-opts-plugin/badge.svg)](https://coveralls.io/r/evolution-gaming/sbt-scalac-opts-plugin)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/15f881be37fa48078219c9c9e8d9361c)](https://www.codacy.com/app/evolution-gaming/sbt-scalac-opts-plugin?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=evolution-gaming/sbt-scalac-opts-plugin&amp;utm_campaign=Badge_Grade)
[![Version](https://maven-badges.herokuapp.com/maven-central/com.evolution/sbt-scalac-opts-plugin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.evolution/sbt-scalac-opts-plugin)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellowgreen.svg)](https://opensource.org/licenses/MIT)

Scalac options for sbt projects. 

Check [scalacOptsAll](src/main/scala/com/evolution/scalacopts/ScalacOptsPlugin.scala#L22) out

Many ideas are borrowed from [sbt-tpolecat](https://github.com/DavidGregory084/sbt-tpolecat). Thanks!


## Settings

* `scalacOptsFailOnWarn: Option[Boolean]` Adds or removes `-Xfatal-warnings`, default is `Some(true)`


## Installation

Create a file in your project called `project/plugins.sbt` with the following content:

```scala
addSbtPlugin("com.evolution" % "sbt-scalac-opts-plugin" % "0.0.9")
```