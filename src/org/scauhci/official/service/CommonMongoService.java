package org.scauhci.official.service;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mongo.MongoConnector;

@IocBean(name="commons", args={"refer:connector","official"})
public class CommonMongoService extends AbstractMongoService {
	
	public CommonMongoService(MongoConnector mongoConnector, String collectionName) {
		super(mongoConnector, collectionName);
	}
}
