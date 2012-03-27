package org.scauhci.official.lucene;

import java.util.List;

public interface BaseLucene<T> {
	
	void BuildIndex(String dirPath);
	
	List<T> SearchIndex(String value);
	
	List<T> SearchIndex(String field, String value);

}
