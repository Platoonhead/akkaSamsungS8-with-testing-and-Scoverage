package com.edu.knoldus



import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
import org.scalatest.{BeforeAndAfterAll, MustMatchers, WordSpecLike}

class ValidationActorSpec extends TestKit(ActorSystem("test-system")) with WordSpecLike
  with BeforeAndAfterAll with MustMatchers with ImplicitSender {

  override protected def afterAll(): Unit = {
    system.terminate()
  }

  "ValidationActor" must {

    "Reply with 'booked' if phones are in stock" in {
      val ref = TestActorRef[ValidationActor]
      ref ! BuyerInfo("ankit","delhi","8447145214",123456789L)
      expectMsg ("booked")
    }

    "Reply with 'sold' if phones are out of  stock" in {
      val ref = TestActorRef[ValidationActor]
      ref.underlyingActor.piecesAvailable = 0 //out of stock
      ref ! BuyerInfo("ankit","delhi","8447145214",123456789L)
      expectMsg ("sold")
    }
  }
}

