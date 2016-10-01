name := "processexecutor"

organization := "com.processexecutor"

version := "1.0"

scalaVersion := "2.10.5"

ivyScala := ivyScala.value map{_.copy(overrideScalaVersion = true)}

javaOptions ++= Seq("-Xms512M","-Xmx2048M","-XX:MaxPermsize=2048M","-XX:+CMSClassUnloadingEnabled")

parallelExecution in Test := false

resolvers += "Maven Central" at "http://central.maven.org/maven2/"
resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases"
resolvers += "Sonatype OSS Maven Repository" at "https://oss.sonatype.org/content/repositories/public"
resolvers += "Spring Releases" at "http://repo.spring.io/libs-release-remote/"

resolvers += "Local Ivy Repository" at "file:///" + Path.userHome.absolutePath + "/.ivy2/cache"

//mainClass in assembly := Some("com.processexecutor.ExecuteProcess")


/*assemblyMergeStrategy in assembly := {


}*/

libraryDependencies ++= Seq(

  "org.scalatest" %% "scalatest" % "2.2.5"
  ,"org.apache.spark" %% "spark-core" % "1.6.0"
  ,"com.readerwriter" % "readerwriter_2.10" % "1.1"
  ,"com.dataprocessor" %% "dataprocessor" % "1.1"
  ,"junit" % "junit" % "4.12"
  ,"com.holdenkarau" %% "spark-testing-base" % "1.6.1_0.3.3"
  ,"org.apache.spark" %% "spark-hive" % "1.6.0"
)


publishTo := Some(Resolver.file("file",new File(Path.userHome.absolutePath + "/.ivy2/cache")))


