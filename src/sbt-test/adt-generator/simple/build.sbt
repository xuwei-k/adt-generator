adtSettings

adtPackage := "com.example"

val printFiles = taskKey[Unit]("print generated java files")

printFiles := {
  (sourceManaged in Compile).value.**("*.java").get.foreach{
    f => 
      println(f)
      println(IO.read(f))
  }
}

