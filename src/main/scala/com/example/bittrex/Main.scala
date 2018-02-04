package com.example.bittrex

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.taintech.bittrex.client.BittrexClient
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.{Await, ExecutionContextExecutor}
import scala.concurrent.duration._
import scala.language.postfixOps

object Main extends App with LazyLogging {

  implicit val system: ActorSystem = ActorSystem("bittrex-system")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  val bittrexClient = BittrexClient()
  val marketSummaries = Await.result(bittrexClient.getMarketSummaries, 2 seconds)
  logger.info(marketSummaries.toString())
}
