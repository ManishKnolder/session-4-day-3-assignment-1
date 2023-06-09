
package com.knoldus

import scala.io.StdIn.readLine
import scala.util.{Failure, Success, Try}

object Driver extends App {
  private val paymentObject = new PaymentMethod
  private val addPaymentMethod = paymentObject.addAnotherPayment("credit-card") ++ paymentObject.addAnotherPayment("paypal")
  private val listOfPaymentMethod = addPaymentMethod ++ paymentObject.addAnotherPayment("bank-transfer")
  print("After Adding New Payment Methods to List :\n" + listOfPaymentMethod)

  private val viewPaymentMethod = paymentObject.listAllPaymentMethods(listOfPaymentMethod)
  print("\n\nView what are the payments option available for user:\n" + viewPaymentMethod)

  private val processPaymentType: String = readLine("\n\nEnter Only this payment type :\n1.credit-card\n2.paypal\n3.bank-transfer\nEnter :")
  private val afterProcessingPayment = Try(paymentObject.selectProcessPayment(listOfPaymentMethod, processPaymentType))
  private val finalResult = afterProcessingPayment match {
    case Success(value) => value
    case Failure(exception) => exception.getMessage
  }
  print("\n" + finalResult)
}
