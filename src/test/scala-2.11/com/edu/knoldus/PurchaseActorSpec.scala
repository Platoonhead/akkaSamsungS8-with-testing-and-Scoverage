package com.edu.knoldus

import akka.actor.{ActorSystem}
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
import org.scalatest.{BeforeAndAfterAll, MustMatchers, WordSpecLike}

class PurchaseActorSpec extends TestKit(ActorSystem("test-system")) with WordSpecLike
  with BeforeAndAfterAll with MustMatchers with ImplicitSender {

  override protected def afterAll(): Unit = {
    system.terminate()
  }

  "forPurchaseActor" must {
    "reply with 'insidePurchaseActor'" in {
      val ref = TestActorRef(PurchaseActor.prop(TestActorRef(PurchaseRequestHandler.prop)))
      ref ! BuyerInfo("ankit","delhi","8447145214",123456789L)
      expectMsg ("insidePurchaseActor")
    }
  }
}





