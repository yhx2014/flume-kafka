Since this plugin for flume is going to merge into flume, I've splited this plugin to two dependent plugin [flumg-ng-kafka-source](https://github.com/baniuyao/flume-ng-kafka-source) and [flume-ng-kafka-sink](https://github.com/baniuyao/flume-ng-kafka-sink). ASFv2 branch is okay, but I advised to use new plugin.
===========
Flume-ng Kafka
===========

This project is used for [flume-ng](https://github.com/apache/flume) to communicate with [kafka 0.8.1](https://github.com/apache/kafka/tree/0.8.1).

”√kafka0.8.1

----------

    agent_log.sinks.kafka.type = com.vipshop.flume.sink.kafka.KafkaSink
    agent_log.sinks.kafka.channel = all_channel
    agent_log.sinks.kafka.metadata.broker.list=127.0.0.1:9092
    agent_log.sinks.kafka.topic = all
    agent_log.sinks.kafka.batchsize = 200
    agent_log.sinks.kafka.producer.type = async
    agent_log.sinks.kafka.serializer.class = kafka.serializer.StringEncoder


Configuration of Kafka Source
----------

    agent_log.sources.kafka0.type = com.vipshop.flume.source.kafka.KafkaSource
    agent_log.sources.kafka0.zookeeper.connect = 127.0.0.1:2181
    agent_log.sources.kafka0.topic = all
    agent_log.sources.kafka0.group.id = es
    agent_log.sources.kafka0.channels = channel0

Speical Thanks
---------
 
 Speical Thanks

In fact I'm a newbie in Java. I have learnt a lot from flumg-ng-rabbitmq. Thanks to [baniuyao](https://github.com/baniuyao/flume-kafka).