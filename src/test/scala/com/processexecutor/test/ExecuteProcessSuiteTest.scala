package com.processexecutor.test

import org.scalatest._
import com.dataprocessor._
import org.apache.spark.rdd._
import com.holdenkarau.spark.testing.{RDDComparisons,RDDGenerator,SharedSparkContext}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
  * Created by cloudera on 8/8/16.
  */
@RunWith(classOf[JUnitRunner])
class ExecuteProcessSuiteTest extends FunSuite with Matchers with SharedSparkContext{
    //val sqlContext = new SQLContext(sc)

   test("each string should have a value equal to length * appearances"){
     val counter = sc.accumulator(0)
     val input: RDD[String] = sc.parallelize(List("green","red","blue","green","red","blue"))
     val resultRDD: RDD[(String,Int)] = ProcessData.mapStringLength(input)

     val expectedRDD: RDD[(String,Int)] = sc.parallelize(List(("green",10),("red",6),("blue",8)))

     RDDComparisons.assertRDDEquals(resultRDD,expectedRDD)
     //comment
   }
}
