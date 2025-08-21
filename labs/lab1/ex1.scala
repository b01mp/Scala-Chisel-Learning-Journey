import chisel3._

class Counter(counterBits: UInt) extends Module {
  val io = IO(new Bundle {
    val result = Output(Bool())  // Just output a Bool signal (for example)
  })

  val max = (1.S << counterBits.asUInt) - 1.S  // max value as SInt
  val count = RegInit(0.S(16.W))

  when(count === max) {
    count := 0.S
  } .otherwise {
    count := count + 1.S
  }

  // For example output the least significant bit of count as Bool
  io.result := count(0)

  println(s"Counter created with max value $max")
}
