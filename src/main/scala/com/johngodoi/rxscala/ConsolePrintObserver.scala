package com.johngodoi.rxscala

import rx.lang.scala.Observer


class ConsolePrintObserver extends Observer[Int]{
  override def onNext(t: Int): Unit = print(s"[$t]-")

  override def onError(e: Throwable): Unit = println(e.getMessage)

  override def onCompleted():Unit = println("Observable completed\n")
}
