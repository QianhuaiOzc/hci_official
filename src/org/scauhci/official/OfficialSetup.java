/**
 * 
 */
package org.scauhci.official;

import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

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
	public void init(NutConfig nc) {
		String mode = nc.getInitParameter("mode");
	}

}
