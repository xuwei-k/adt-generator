sbtPlugin := true

name := "adt-generator"

organization := "com.github.xuwei-k"

scalacOptions := Seq("-deprecation", "-unchecked")

licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT"))

startYear := Some(2013)

scmInfo := Some(ScmInfo(
  url("https://github.com/xuwei-k/adt-generator"),
  "scm:git:git@github.com:xuwei-k/adt-generator.git"
))

pomExtra := (
<url>https://github.com/xuwei-k/adt-generator</url>
<developers>
  <developer>
    <id>xuwei-k</id>
    <name>Kenji Yoshida</name>
    <url>https://github.com/xuwei-k</url>
  </developer>
</developers>
)

ScriptedPlugin.scriptedSettings

ScriptedPlugin.scriptedBufferLog := false

watchSources <++= sbtTestDirectory.map{_.***.get}

libraryDependencies ++= Seq(
  "org.scala-sbt" % "datatype-generator" % sbtVersion.value
)

scriptedLaunchOpts += "-Dplugin.version=" + version.value
