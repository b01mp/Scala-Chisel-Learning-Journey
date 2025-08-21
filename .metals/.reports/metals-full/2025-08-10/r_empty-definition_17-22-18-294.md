error id: file://<WORKSPACE>/labs/lab1/ex3.scala:
file://<WORKSPACE>/labs/lab1/ex3.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb

found definition using fallback; symbol otherwise
offset: 316
uri: file://<WORKSPACE>/labs/lab1/ex3.scala
text:
```scala
import chisel3._

class Counter()extends Module{
    val io = IO(new Bundle{
        val result = Output(Bool())
    })

    def genCounter(n:Int, max: Int)={
        val count = RegInit(0.U(n.W))
        val maxI = max.asInstanceOf[UInt]

        when ( count === max ) {
            count := 0. U
        } .otherw@@ise {
            count := count + 1. U
        }
    }

    val counter1 = genCounter ( size , maxValue )
    io . result := counter1 ( size -1)
}

println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new Counter (8 , 255. U ) ) )
```


#### Short summary: 

empty definition using pc, found symbol in pc: 