package com.processexecutor

import com.readerwriter.reader.InputReader
import com.readerwriter.writer.OutputWriter
import com.dataprocessor._
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.rdd._
import java.io._

/**
  * Created by cloudera on 8/8/16.
  */
object ExecuteProcess {

  def main(args: Array[String]): Unit =
  {
    if(args.length != 2){
      System.err.println("Usage: ExecuteProcess <master> <inputfile>")
    }


    val inputFile = args(0)
    val outputDir = args(1)
    val outputFile = outputDir + "/" + "dummyOutput.csv"

    val sparkConf = new SparkConf().setAppName("Execute Process")
    val context = new SparkContext(sparkConf)

    val inFileRDD = InputReader.getFileRDD(context,inputFile)

    val outputRDD: RDD[(String,Int)] = ProcessData.mapStringLength(inFileRDD)

    OutputWriter.writeFile(outputFile,outputRDD)
    context.stop()




  }


}
