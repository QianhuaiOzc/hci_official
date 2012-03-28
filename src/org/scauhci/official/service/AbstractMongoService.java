package org.scauhci.official.service;

import org.nutz.mongo.MongoConnector;
import org.nutz.mongo.MongoDao;

public abstract class AbstractMongoService {
	
	private MongoDao mongoDao;
	
	public AbstractMongoService(MongoConnector mongoConnector, String collectionName) {
		mongoDao = mongoConnector.getDao(collectionName);
	}
	
	public MongoDao dao() {
		return mongoDao;
	}
}
