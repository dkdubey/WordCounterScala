package com.ms.wc.services

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import akka.util.ByteString

import scala.concurrent.Future
import scala.util.{Failure, Success}

object WordCountService {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("word-count-service")
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher

    val route = path("wordcount") {
      post {
        entity(as[String]) { text =>
          val wordCount = countWords(text)
          complete(wordCount.toString)
        }
      }
    }

    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

    bindingFuture.onComplete {
      case Success(binding) =>
        println(s"Word Count Service is running at http://${binding.localAddress.getHostString}:${binding.localAddress.getPort}/")
      case Failure(ex) =>
        println(s"Failed to start Word Count Service: ${ex.getMessage}")
        system.terminate()
    }
  }

  def countWords(text: String): Map[String, Int] = {
    val words = text.split("\\W+")
    words.groupBy(_.toLowerCase).mapValues(_.length)
  }
}

