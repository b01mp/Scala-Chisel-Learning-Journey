package lab2

import chisel3._
import chisel3.util._

class BarrelShifter4 extends Module {
  val io = IO(new Bundle {
    val in = Vec(4, Input(Bool()))
    val sel = Vec(2, Input(Bool()))       // shift amount
    val shift_type = Input(Bool())        // 0 = logical, 1 = arithmetic
    val out = Vec(4, Output(Bool()))
  })

  // Convert sel Vec(Bool) to UInt
  val shiftAmt = Cat(io.sel(1), io.sel(0))

  // Determine fill value: 0 for logical, MSB for arithmetic
  val fill = Mux(io.shift_type, io.in(3), false.B)

  // Generate shifted outputs
  for (i <- 0 until 4) {
    // Calculate the input index for this output bit
    val idx = i.U + shiftAmt
    io.out(i) := Mux(idx < 4.U, io.in(idx), fill)
  }
}

object BarrelShifter4Main extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new BarrelShifter4(), Array("--target-dir", "generated"))
}
