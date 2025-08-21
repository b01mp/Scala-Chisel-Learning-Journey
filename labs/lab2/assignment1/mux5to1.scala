// Task 1: Write Chisel code for a 5-to-1 multiplexer with specifications given in Table 2.3. A skeleton
// code is also given in Listing 2.13; use it as a starting point and remember: only write your code is the
// space specified.
package lab2 

import chisel3._
import chisel3.util._

class LM_IO_Interface extends Bundle{
  val s0 = Input(Bool())
  val s1 = Input(Bool())
  val s2 = Input(Bool())
  val out= Output(UInt(32.W))
}

class Mux_5to1 extends Module{
  val io = IO(new LM_IO_Interface)

  // Start you code here
  val sel = Cat(io.s2, io.s1, io.s0)

  io.out := MuxLookup(sel, 0.U, Seq(
    "b000".U -> 0.U,
    "b001".U -> 8.U,
    "b010".U -> 16.U,
    "b011".U -> 24.U,
    "b100".U -> 32.U,
    "b101".U -> 32.U,
    "b110".U -> 32.U,
    "b111".U -> 32.U
  ))
  // End your code here
}

object mux5to1 extends App {
  println("Generating the adder hardware")
  emitVerilog(new Mux_5to1(), Array("--target-dir", "generated"))
}