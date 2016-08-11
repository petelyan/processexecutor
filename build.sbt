name := "processexecutor"

organization := "com.processexecutor"

version := "1.0"

scalaVersion := "2.10.5"

ivyScala := ivyScala.value map{_.copy(overrideScalaVersion = true)}

javaOptions ++= Seq("-Xms512M","-Xmx2048M","-XX:MaxPermsize=2048M","-XX:+CMSClassUnloadingEnabled")

resolvers += "Maven Central" at "http://central.maven.org/maven2/"
resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases"
resolvers += "Sonatype OSS Maven Repository" at "https://oss.sonatype.org/content/repositories/public"
resolvers += "Spring Releases" at "http://repo.spring.io/libs-release-remote/"



resolvers += "Local Ivy Repository" at "file:///" + Path.userHome + "/.ivy2/cache"

resolvers += "Second Local" at "file:///C:/Users/PLyani/.ivy2/cache"




libraryDependencies ++= Seq(

  "org.scalatest" %% "scalatest" % "2.2.6"
  ,"org.apache.spark" % "spark-core_2.10" % "1.5.1"
  ,"com.readerwriter" % "readerwriter_2.10" % "1.1"
  ,"com.dataprocessor" %% "dataprocessor" % "1.1"
  ,"org.scala-lang" % "scala-library" % "2.10.5" % "provided"
  ,"junit" % "junit" % "4.12"
/*  ,"org.apache.spark" % "spark-sql_2.10" % "1.5.1"
  ,"org.apache.spark" % "spark-hive_2.10" % "1.5.1"
  ,"org.apache.spark" % "spark-mllib_2.10" % "1.5.1"*/
  ,"com.holdenkarau" %% "spark-testing-base" % "1.5.1_0.3.3"
)


publishTo := Some(Resolver.file("file",new File(Path.userHome.absolutePath + "/.ivy2/cache/")))
