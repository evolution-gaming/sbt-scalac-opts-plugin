# sbt-scalac-opts-plugin 

[![Build Status](https://travis-ci.org/evolution-gaming/sbt-scalac-opts-plugin.svg)](https://travis-ci.org/evolution-gaming/sbt-scalac-opts-plugin)
[![Coverage Status](https://coveralls.io/repos/evolution-gaming/sbt-scalac-opts-plugin/badge.svg)](https://coveralls.io/r/evolution-gaming/sbt-scalac-opts-plugin)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/15f881be37fa48078219c9c9e8d9361c)](https://www.codacy.com/app/evolution-gaming/sbt-scalac-opts-plugin?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=evolution-gaming/sbt-scalac-opts-plugin&amp;utm_campaign=Badge_Grade)
[![version](https://api.bintray.com/packages/evolutiongaming/sbt-plugins/sbt-scalac-opts-plugin/images/download.svg)](https://bintray.com/evolutiongaming/sbt-plugins/sbt-scalac-opts-plugin/_latestVersion)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellowgreen.svg)](https://opensource.org/licenses/MIT)

Scalac options for sbt projects. 

Check [scalacOptsAll](src/main/scala/com/evolutiongaming/scalacopts/ScalacOptsPlugin.scala#L22) out

Many ideas are borrowed from [sbt-tpolecat](https://github.com/DavidGregory084/sbt-tpolecat). Thanks!


## Settings

* `scalacOptsFailOnWarn: Option[Boolean]` Adds or removes `-Xfatal-warnings`, default is `Some(true)`


## Installation

Create a file in your project called `project/plugins.sbt` with the following content:

```scala
externalResolvers += Resolver.bintrayIvyRepo("evolutiongaming", "sbt-plugins") 
 
addSbtPlugin( "com.evolutiongaming" % "sbt-scalac-opts-plugin" % "0.0.4")
```