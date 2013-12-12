package adt

import sbt._, Keys._

object AdtPlugin extends sbt.Plugin{

  val adtDirectory = settingKey[File]("EDSL source file directry")
  val adt = settingKey[Task[Seq[File]]]("generate java source files from EDSL")
  val adtPackage = settingKey[String]("package name")

  val adtSettings: Seq[Def.Setting[_]] = Seq(
    adtDirectory := (sourceDirectory in Compile).value / "adt",
    adt := task{
      val files = adtDirectory.value.*("*").get.toArray
      val out = (sourceManaged in Compile).value / "adt"
      // https://github.com/sbt/sbt/commit/d4aa7bf0e958909da0
      val firstArg = if(sbtVersion.value == "0.13.0") Array("immutable") else Array.empty[String]
      val args = firstArg ++ Array(
        adtPackage.value, out
      ) ++ files
      xsbt.datatype.GenerateDatatypes.main(args.map(_.toString))
      (out ** "*.java").get
    },
    sourceGenerators in Compile <+= adt
  )

}

