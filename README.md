# performancetop5
Fork of the benchmarks in the Hazelcast Performance Top 5 blog series.

This project illustrates the use of Externalizer4J support for Hazelcast's serialization APIs. 
Externalizer4J converts the original Serializable classes into DataSerializable or IdentifiedDataSerializable classes automatically.

In this project the conversion happens using Externalizer4J's maven plugin. But an Ant task and a plugin for IntelliJ IDEA exist too.

Conversion is controlled by the externalizer4j.properties file. More information can be found at http://www.externalizer4j.com/documentation


>Benchmark                                                                          Mode   Samples         Mean   Mean error    Units
>c.h.p.i.j.SerializableBenchmark.readPerformance                                   thrpt         5    11119,213      334,455    ops/s
>c.h.p.i.j.SerializableBenchmark.writePerformance                                  thrpt         5    14286,450      166,233    ops/s
>c.h.p.i.j.DataSerializableBenchmark.readPerformance                               thrpt         5    20569,027      624,522    ops/s
>c.h.p.i.j.DataSerializableBenchmark.writePerformance                              thrpt         5    18939,900      571,725    ops/s
>c.h.p.i.j.IdentifiedDataSerializableBenchmark.readPerformance                     thrpt         5    21302,503      455,478    ops/s
>c.h.p.i.j.IdentifiedDataSerializableBenchmark.writePerformance                    thrpt         5    18891,213      736,843    ops/s
>
>--- Below: automatically generated serialization methods - no coding
>c.h.p.i.j.SerializableAutoBasicBenchmark.readPerformance                          thrpt         5    20224,357      169,593    ops/s
>c.h.p.i.j.SerializableAutoBasicBenchmark.writePerformance                         thrpt         5    17996,060      150,531    ops/s
>c.h.p.i.j.SerializableAutoMediumBenchmark.readPerformance                         thrpt         5    19708,243     1949,785    ops/s
>c.h.p.i.j.SerializableAutoMediumBenchmark.writePerformance                        thrpt         5    19238,717     2928,968    ops/s
>c.h.p.i.j.SerializableAutoOptBenchmark.readPerformance                            thrpt         5    20469,020      450,932    ops/s
>c.h.p.i.j.SerializableAutoOptBenchmark.writePerformance                           thrpt         5    19275,213     1554,890    ops/s
>c.h.p.i.j.SerializableAutoIdentifiedDataSerializableBenchmark.readPerformance     thrpt         5    21304,563     1083,789    ops/s
>c.h.p.i.j.SerializableAutoIdentifiedDataSerializableBenchmark.writePerformance    thrpt         5    19189,893      422,018    ops/s
