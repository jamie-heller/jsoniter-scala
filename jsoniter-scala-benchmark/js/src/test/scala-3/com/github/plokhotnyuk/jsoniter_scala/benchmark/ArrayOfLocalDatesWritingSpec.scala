package com.github.plokhotnyuk.jsoniter_scala.benchmark

class ArrayOfLocalDatesWritingSpec extends BenchmarkSpecBase {
  def benchmark: ArrayOfLocalDatesWriting = new ArrayOfLocalDatesWriting {
    setup()
  }

  "ArrayOfLocalDatesWriting" should {
    "write properly" in {
      val b = benchmark
      toString(b.borer()) shouldBe b.jsonString
      toString(b.jsoniterScala()) shouldBe b.jsonString
      toString(b.preallocatedBuf, 64, b.jsoniterScalaPrealloc()) shouldBe b.jsonString
    }
  }
}