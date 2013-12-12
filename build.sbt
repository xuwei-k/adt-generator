sbtPlugin := true

name := "adt-generator"

organization := "com.github.xuwei-k"

version := "0.1.0-SNAPSHOT"

scalacOptions := Seq("-deprecation", "-unchecked")

ScriptedPlugin.scriptedSettings

ScriptedPlugin.scriptedBufferLog := false

watchSources <++= sbtTestDirectory.map{_.***.get}

libraryDependencies ++= Seq(
  "org.scala-sbt" % "datatype-generator" % sbtVersion.value
)
