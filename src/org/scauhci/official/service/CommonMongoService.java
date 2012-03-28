package org.scauhci.official.service;

import org.nutz.mongo.MongoConnector;

public class CommonMongoService extends AbstractMongoService {
	
	public CommonMongoService(MongoConnector mongoConnector, String collectionName) {
		super(mongoConnector, collectionName);
	}
}
