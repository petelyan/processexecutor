package com.processexecutor.test

import org.scalatest._
import org.apache.spark._
import com.dataprocessor._
import org.apache.spark.rdd._

/**
  * Created by cloudera on 8/8/16.
  */
class ExecuteProcessSuiteTest extends FunSuite with Matchers with BeforeAndAfter{

  /* var context: SparkContext = _

   before{
     val sparkConf = new SparkConf()
       .setMaster("local[*]")
       .setAppName("Execute process test")
     context = new SparkContext(sparkConf)
   }

   after{
     context.stop()
   }

   test("sum data on input"){
     val counter = context.accumulator(0)
     val input: RDD[String] = context.parallelize(List("1,2","2,3","3,4"))
     val result: RDD[Double] = ProcessData.handleInput(counter,input)

     result.collect() should equal (Array[Int](3,5,7))
   }*/
}
