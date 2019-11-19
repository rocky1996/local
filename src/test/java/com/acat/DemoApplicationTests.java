package com.acat;

import com.acat.common.CacheConst;
import com.acat.entity.ChildEntity;
import com.acat.entity.ChildQueueEntity;
import com.acat.service.cache.RedisService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {

	private Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

	@Autowired
	private RedisService redisService;

	@Test
	void contextLoads() {

		ChildQueueEntity childQueueEntity = new ChildQueueEntity();

		List<ChildEntity> childEntityList = new ArrayList<>();
		ChildEntity childEntity1 = new ChildEntity(UUID.randomUUID().toString(),"小明");
		ChildEntity childEntity2 = new ChildEntity(UUID.randomUUID().toString(),"小华");
		ChildEntity childEntity3 = new ChildEntity(UUID.randomUUID().toString(),"小丽");
		childEntityList.add(childEntity1);
		childEntityList.add(childEntity2);
		childEntityList.add(childEntity3);

		childQueueEntity.setQueueId(UUID.randomUUID().toString());
		childQueueEntity.setTimeDuanId("1");
		childQueueEntity.setQueueName("第三列");
		childQueueEntity.setChildNum(childEntityList.size());
		childQueueEntity.setChildsName(childEntityList);

		String key = MessageFormat.format(CacheConst.childPlayState,childQueueEntity.getQueueId(),childQueueEntity.getTimeDuanId());
		redisService.set(key,childQueueEntity);
		logger.info("[初始化队列缓存信息]start,queueId:{},timeDuanId:{}",childQueueEntity.getQueueId(),childQueueEntity.getTimeDuanId());
	}

}
