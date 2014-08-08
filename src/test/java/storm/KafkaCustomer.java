/*  
 * @(#) KafkaCustomer.java Create on 2014-8-8 下午3:38:41   
 *   
 * Copyright 2014 by yhx.   
 */

package storm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.javaapi.producer.Producer;
import kafka.message.MessageAndMetadata;

/**
 * @KafkaCustomer.java
 * @created at 2014-8-8 下午3:38:41 by zhanghl
 * 
 * @desc
 * 
 * @author zhanghl({@link 253587517@qq.com})
 * @version $Revision$
 * @update: $Date$
 */
public class KafkaCustomer {

	static Logger logger = org.slf4j.LoggerFactory.getLogger(KafkaCustomer.class);

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("zookeeper.connect",  "192.168.174.132:2181");
		props.put("group.id", "test-consumer-group");
//		props.put("serializer.class", "kafka.serializer.StringEncoder");

		ConsumerConfig consumerConfig = new ConsumerConfig(props);
		ConsumerConnector consumer = Consumer.createJavaConsumerConnector(consumerConfig);

		try {
			Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
			String key = "topicT";
			topicCountMap.put(key, new Integer(1));
			Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
			KafkaStream<byte[], byte[]> stream = consumerMap.get(key).get(0);

			ConsumerIterator<byte[], byte[]> cI = stream.iterator();

			while (cI.hasNext()) {
				MessageAndMetadata<byte[], byte[]> mm = cI.next();
//				String mmKey = new String(mm.key());
				String message = new String(mm.message());
				System.out.println(message);
				logger.debug("key:{} | value:{}", "", message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
