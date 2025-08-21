import chisel3._
import chisel3.stage.ChiselStage

class Counter(size: Int, maxValue: Int)extends Module{
    val io = IO(new Bundle{
        val result = Output(Bool())
    })

    def genCounter(n:Int, max:Int)={
        val count = RegInit(0.U(n.W))
        val maxUInt = max.U(n.W)

        when(count === maxUInt){
            count := 0.U
        }.otherwise{
            count := count + 1.U 
        }
        count 
    }

    // genCounter instantiation
    val counter1 = genCounter(size, maxValue)
    io.result := counter1(size - 1)
}

object Main extends App {
  println(new ChiselStage().emitVerilog(new Counter(8, 255)))
}