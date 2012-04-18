/**
 * 
 */
package org.scauhci.official;

import org.nutz.mongo.MongoDao;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.scauhci.official.service.CommonMongoService;

/**
 * @author clarenceau
 *
 */
public class OfficialSetup implements Setup {

	/* (non-Javadoc)
	 * @see org.nutz.mvc.Setup#destroy(org.nutz.mvc.NutConfig)
	 */
	@Override
	public void destroy(NutConfig nc) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.nutz.mvc.Setup#init(org.nutz.mvc.NutConfig)
	 */
	@Override
	public void init(NutConfig nutConfig) {
		CommonMongoService commonMongoService = nutConfig.getIoc().get(CommonMongoService.class, "commons");
		MongoDao dao =commonMongoService.dao();
		
//		dao.create(pojoType, dropIfExists)
		String mode = nutConfig.getInitParameter("mode");
	}

}
