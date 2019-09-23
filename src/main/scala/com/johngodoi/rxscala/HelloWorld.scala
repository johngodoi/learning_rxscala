package com.johngodoi.rxscala

import io.reactivex.Flowable
import rx.lang.scala.Observable

import scala.concurrent.duration._

object HelloWorld extends App {

  Flowable.just("Hello World").subscribe(println(_))

  def hello(names: String*) {
    Observable.from(names) subscribe (n => println(s"Hello $n!"))
  }

  hello("John", "Johann", "Yasmin", "Joshua", "Elizabeth")

  private val compliments: Array[String] = Array[String]("hi", "holla", "bonjour")
  private val observable: Observable[String] = Observable from compliments
  private val intergerList = (1 to 10).toList
  private val integerObservable: Observable[Int] = Observable from intergerList
  private val singleValueObservable: Observable[String] = Observable just "Just one string"
  private val applyRange = Observable.apply[Int]{
    observer => try {
      (1 to 10).foreach(println(_))
      observer.onCompleted()
    } catch {
      case e:Exception  => observer.onError(e)
    }
  }

  Observable.interval(100.millis)

  integerObservable.subscribe(v => print(v + " "))

  def printObservable[T](v:T):Unit = print(v)

  integerObservable.subscribe(printObservable(_))
}
