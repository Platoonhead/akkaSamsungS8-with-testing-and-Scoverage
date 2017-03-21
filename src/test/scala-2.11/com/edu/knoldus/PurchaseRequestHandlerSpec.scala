package com.edu.knoldus


import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
import org.scalatest.{BeforeAndAfterAll, MustMatchers, WordSpecLike}

class PurchaseRequestHandlerSpec extends TestKit(ActorSystem("test-system")) with WordSpecLike
  with BeforeAndAfterAll with MustMatchers with ImplicitSender {

  override protected def afterAll(): Unit = {
    system.terminate()
  }

  "PurchaseRequestHandler" must {
    "Reply with the same message it receives after telling" in {
      val ref = TestActorRef[PurchaseRequestHandler]
      ref ! BuyerInfo("ankit", "delhi", "8447145214", 123456789L)
      expectMsg("ok")
      assert(ref.underlyingActor.usersPhoneNumber.contains("8447145214"))
    }
  }
}


