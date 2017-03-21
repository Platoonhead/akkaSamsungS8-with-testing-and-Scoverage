package com.edu.knoldus

import akka.actor.{Actor, ActorRef, Props}

class PurchaseActor(requestHandlerRefProvider: ActorRef ) extends Actor{

  override def receive = {


    case x : BuyerInfo => sender() ! "insidePurchaseActor"
                          requestHandlerRefProvider ! x
  }

}
object PurchaseActor{

  def prop(RequestHandlerRef: ActorRef):Props = Props(classOf[PurchaseActor],RequestHandlerRef)

}