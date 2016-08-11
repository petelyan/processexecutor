package com.processexecutor

import com.readerwriter.reader.InputReader
import com.readerwriter.writer.OutputWriter
import com.dataprocessor._
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.rdd._

/**
  * Created by cloudera on 8/8/16.
  */
object ExecuteProcess {

  def main(args: Array[String]): Unit =
  {
    if(args.length != 2){
      System.err.println("Usage: ExecuteProcess <master> <inputfile>")
    }

    //val master = args(0)
    val inputFile = args(0)
    val outputFile = args(1)

    val sparkConf = new SparkConf().setAppName("Execute Process")
    //val context = new SparkContext(master,,System.getenv("SPARK_HOME"),Seq(System.getenv("JARS")))
    val context = new SparkContext(sparkConf)
    val inFileRDD = InputReader.getFileRDD(context,inputFile)
    //val invalidLineCounter = context.accumulator(0)
    //val outputRDD: RDD[Double] = ProcessData.handleInput(invalidLineCounter,inFileRDD)
    val outputRDD: RDD[(String,Int)] = ProcessData.mapStringLength(inFileRDD)

    //    val outputArray: Array[Double] = outputRDD.collect()
    OutputWriter.writeFile(outputFile,outputRDD)
    context.stop()

  }


}
