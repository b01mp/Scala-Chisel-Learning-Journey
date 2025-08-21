module Mux_5to1(
  input         clock,
  input         reset,
  input         io_s0, // @[src/main/scala/empty/Add.scala 14:14]
  input         io_s1, // @[src/main/scala/empty/Add.scala 14:14]
  input         io_s2, // @[src/main/scala/empty/Add.scala 14:14]
  output [31:0] io_out // @[src/main/scala/empty/Add.scala 14:14]
);
  wire [2:0] sel = {io_s2,io_s1,io_s0}; // @[src/main/scala/empty/Add.scala 17:16]
  wire [3:0] _io_out_T_1 = 3'h1 == sel ? 4'h8 : 4'h0; // @[src/main/scala/chisel3/util/Mux.scala 77:13]
  wire [4:0] _io_out_T_3 = 3'h2 == sel ? 5'h10 : {{1'd0}, _io_out_T_1}; // @[src/main/scala/chisel3/util/Mux.scala 77:13]
  wire [4:0] _io_out_T_5 = 3'h3 == sel ? 5'h18 : _io_out_T_3; // @[src/main/scala/chisel3/util/Mux.scala 77:13]
  wire [5:0] _io_out_T_7 = 3'h4 == sel ? 6'h20 : {{1'd0}, _io_out_T_5}; // @[src/main/scala/chisel3/util/Mux.scala 77:13]
  wire [5:0] _io_out_T_9 = 3'h5 == sel ? 6'h20 : _io_out_T_7; // @[src/main/scala/chisel3/util/Mux.scala 77:13]
  wire [5:0] _io_out_T_11 = 3'h6 == sel ? 6'h20 : _io_out_T_9; // @[src/main/scala/chisel3/util/Mux.scala 77:13]
  wire [5:0] _io_out_T_13 = 3'h7 == sel ? 6'h20 : _io_out_T_11; // @[src/main/scala/chisel3/util/Mux.scala 77:13]
  assign io_out = {{26'd0}, _io_out_T_13}; // @[src/main/scala/empty/Add.scala 19:10]
endmodule
