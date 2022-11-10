package com.github.plokhotnyuk.jsoniter_scala.benchmark

import java.nio.charset.StandardCharsets.UTF_8

class IntMapOfBooleansReadingSpec extends BenchmarkSpecBase {
  def benchmark: IntMapOfBooleansReading = new IntMapOfBooleansReading {
    setup()
  }

  "IntMapOfBooleansReading" should {
    "read properly" in {
      benchmark.jsoniterScala() shouldBe benchmark.obj
    }
    "fail on invalid input" in {
      val b = benchmark
      b.jsonBytes = "[]".getBytes(UTF_8)
      intercept[Throwable](b.jsoniterScala())
    }
  }
}