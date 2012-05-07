/**
 * 
 */
package org.scauhci.official;

import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.annotation.Views;
import org.nutz.mvc.ioc.provider.ComboIocProvider;
import org.nutz.web.ajax.AjaxViewMaker;
import org.scauhci.official.mvc.SmartViewMaker;

/**
 * @author clarenceau
 * 
 */
@Modules(scanPackage = true)
@Fail("json")
@IocBy(type = ComboIocProvider.class, args = {
		"*org.nutz.ioc.loader.json.JsonLoader", "ioc/",
		"*org.nutz.ioc.loader.annotation.AnnotationIocLoader",
		"org.scauhci.official",
		"org.scauhci.official.module",
		"org.scauhci.official.dao",
		"org.scauhci.official.lucene",
		"org.scauhci.official.service"})
@Encoding(input = "UTF-8", output = "UTF-8")
@Views({AjaxViewMaker.class, SmartViewMaker.class})
@SetupBy(OfficialSetup.class)
public class MainModule {
}
