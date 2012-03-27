/**
 * 
 */
package org.scauhci.official.service;

import org.nutz.dao.Dao;
import org.nutz.mongo.MongoConnector;
import org.nutz.mongo.MongoDao;

/**
 * @author clarenceau
 *
 */
public abstract class AbstractService {

	protected MongoDao mongoDao;
	
	protected Dao dao;
	
	public AbstractService(MongoConnector conn, String dbName) {
		this.mongoDao = conn.getDao(dbName);
	}
	
	public MongoDao mongoDao() {
		return mongoDao;
	}
	
	public Dao dao() {
		return dao;
	}
	
}
