/**
 * 
 */
package org.scauhci.official.mvc;

import org.nutz.aop.InterceptorChain;
import org.nutz.aop.MethodInterceptor;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * @author clarenceau
 *
 */
@IocBean
public class LogInterceptor implements MethodInterceptor {

	/* (non-Javadoc)
	 * @see org.nutz.aop.MethodInterceptor#filter(org.nutz.aop.InterceptorChain)
	 */
	@Override
	public void filter(InterceptorChain ic) throws Throwable {
		// TODO Auto-generated method stub
		ic.getArgs();
		

	}

}
