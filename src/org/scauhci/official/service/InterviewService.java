package org.scauhci.official.service;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mongo.MongoConnector;

@IocBean(args = {"refer:connecotr", "interview"})
public class InterviewService extends CommonMongoService {
	
	public InterviewService(MongoConnector mongoConnector, String collectionName) {
		super(mongoConnector, collectionName);
	}
}
