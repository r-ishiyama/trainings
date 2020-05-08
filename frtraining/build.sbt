name := """frtraining"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.13.1"

libraryDependencies += guice

libraryDependencies += "org.projectlombok" % "lombok" % "1.16.10"
libraryDependencies += "com.h2database" % "h2" % "1.4.192"
libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.9"

// LESS compile setting
includeFilter in (Assets, LessKeys.less) := "*.less"
excludeFilter in (Assets, LessKeys.less) := "_*.less"


