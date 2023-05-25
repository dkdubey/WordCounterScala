package com.ms.wc.services

import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class WordCountServiceSpec extends AnyWordSpec with Matchers with ScalatestRouteTest {
  import WordCountService._

  "WordCountService" should {
    "return word count for a given text" in {
      val text = "Hello world, hello world, hello world!"
      Post("/wordcount", text) ~> route ~> check {
        status shouldEqual StatusCodes.OK
        responseAs[String] shouldEqual "{\"hello\":3,\"world\":3}"
      }
    }

    "return empty word count for empty text" in {
      val text = ""
      Post("/wordcount", text) ~> route ~> check {
        status shouldEqual StatusCodes.OK
        responseAs[String] shouldEqual "{}"
      }
    }
  }
}

