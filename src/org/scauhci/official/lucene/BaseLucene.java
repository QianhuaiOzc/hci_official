package org.scauhci.official.lucene;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.util.Version;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.scauhci.official.Config;
import org.wltea.analyzer.lucene.IKAnalyzer;

public abstract class BaseLucene<T> {

	 protected IndexSearcher searcher;
	 protected Dao dao; 
	 protected Class<T> clazz;
	 
	 public BaseLucene(Dao dao) {
	        this.dao=dao;
	    }
	
	 public IndexSearcher getSearcher(){
		 return this.searcher;
	 }
	 
	 public List<T> searchIndex(String value){
			// 分析用户查询 
		  Query query = null;
		//实例化IKAnalyzer分词器
		  Analyzer analyzer = new IKAnalyzer();
		  List<T> list=new ArrayList<T>();
		  // the Query created by the QueryParser 
		  try 
		  { 
			  QueryParser qp = new QueryParser(Version.LUCENE_35,"content", analyzer);
			  qp.setDefaultOperator(QueryParser.AND_OPERATOR);
			  query = qp.parse(value);
			  //搜索相似度最高的 SEARCH_MAX_PAGE_SIZE 条记录
			 TopDocs topDocs = searcher.search(query,Config.SEARCH_MAX_PAGE_SIZE);	
			 for (ScoreDoc scoreDoc :topDocs.scoreDocs) {
				 Document doc = searcher.doc(scoreDoc.doc);
				 ByteArrayInputStream byteIn = new ByteArrayInputStream(doc.getBinaryValue("data"));  
				 ObjectInputStream in = new ObjectInputStream(byteIn);  
				 T t = (T) in.readObject();  				 
				 list.add(t);
			 }
			   
		  } catch (IOException ex)
		  { 
				System.err.println("分析用户查询出错");
				 ex.printStackTrace();
				 return list;
		  } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 return list;
	 };
	 
	 public List<T> searchIndex(String value,Pager pager){
		// 分析用户查询 
		  Query query = null;
		//实例化IKAnalyzer分词器
		  Analyzer analyzer = new IKAnalyzer();
		  List<T> list=new ArrayList<T>();
		  // the Query created by the QueryParser 
		  try 
		  { 
			  QueryParser qp = new QueryParser(Version.LUCENE_35,"content", analyzer);
			  qp.setDefaultOperator(QueryParser.AND_OPERATOR);
			  query = qp.parse(value);
			  //搜索相似度最高的 SEARCH_MAX_PAGE_SIZE 条记录
			 TopDocs topDocs = searcher.search(query,Config.SEARCH_MAX_PAGE_SIZE);
			 
			 if(pager==null){
				 for(int i= 0;i<Config.SEARCH_PAGE_SIZE;i++){
					 Document doc = searcher.doc(topDocs.scoreDocs[i].doc);
					 list.add(dao.fetch(clazz, Integer.parseInt(doc.get("ID"))));
				 }
				 
			 }else{
				 int start=(pager.getPageNumber()-1>0? pager.getPageNumber()-1:0)*pager.getPageSize();
				 int end=start+pager.getPageSize();
				 if(end>topDocs.totalHits)
					 end=topDocs.totalHits;
				 for(int i= start;i<end;i++){
					 Document doc = searcher.doc(topDocs.scoreDocs[i].doc);
					 ByteArrayInputStream byteIn = new ByteArrayInputStream(doc.getBinaryValue("data"));  
					 ObjectInputStream in = new ObjectInputStream(byteIn);  
					 T t = (T) in.readObject();  				 
					 list.add(t);
				 }
				 
			 }
			 
			   
		  } catch (IOException ex)
		  { 
				System.err.println("分析用户查询出错");
				 ex.printStackTrace();
				 return list;
		  } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 return list;
	 };
	 
	 public int countSearchIndex(String value){
			// 分析用户查询 
		  Query query = null;
		//实例化IKAnalyzer分词器
		  Analyzer analyzer = new IKAnalyzer();
		  // the Query created by the QueryParser 
		  try 
		  { 
			  QueryParser qp = new QueryParser(Version.LUCENE_35,"content", analyzer);
			  qp.setDefaultOperator(QueryParser.AND_OPERATOR);
			  query = qp.parse(value);
			  //搜索相似度最高的 SEARCH_MAX_PAGE_SIZE 条记录
			 TopDocs topDocs = searcher.search(query,Config.SEARCH_MAX_PAGE_SIZE);	
			 return topDocs.totalHits;
			   
		  } catch (IOException ex)
		  { 
				System.err.println("分析用户查询出错");
				 ex.printStackTrace();
				 return 0;
		  } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} 
		 
	 };
	 

	 public List<T> searchIndex(String field, String value){
			// 分析用户查询 
		  Query query = null;
		//实例化IKAnalyzer分词器
		  Analyzer analyzer = new IKAnalyzer();
		  List<T> list=new ArrayList<T>();
		  // the Query created by the QueryParser 
		  try 
		  { 
			  QueryParser qp = new QueryParser(Version.LUCENE_35,field, analyzer);
			  qp.setDefaultOperator(QueryParser.AND_OPERATOR);
			  query = qp.parse(value);
			  //搜索相似度最高的 SEARCH_PAGE_SIZE 条记录
			 TopDocs topDocs = searcher.search(query,Config.SEARCH_MAX_PAGE_SIZE);	
			 System.err.print(topDocs.totalHits);
			 for (ScoreDoc scoreDoc :topDocs.scoreDocs) {
				 Document doc = searcher.doc(scoreDoc.doc);
				 ByteArrayInputStream byteIn = new ByteArrayInputStream(doc.getBinaryValue("data"));  
				 ObjectInputStream in = new ObjectInputStream(byteIn);  
				 T t = (T) in.readObject();  				 
				 list.add(t);
			 }
			   
		  } catch (IOException ex)
		  { 
				System.err.println("分析用户查询出错");
				 ex.printStackTrace();
				 return list;
		  } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 return list;
	 };
	 
	 public List<T> searchIndex(String field, String value,Pager pager){
			// 分析用户查询 
		  Query query = null;
		//实例化IKAnalyzer分词器
		  Analyzer analyzer = new IKAnalyzer();
		  List<T> list=new ArrayList<T>();
		  // the Query created by the QueryParser 
		  try 
		  { 
			  QueryParser qp = new QueryParser(Version.LUCENE_35,field, analyzer);
			  qp.setDefaultOperator(QueryParser.AND_OPERATOR);
			  query = qp.parse(value);
			  //搜索相似度最高的 SEARCH_PAGE_SIZE 条记录
			 TopDocs topDocs = searcher.search(query,Config.SEARCH_PAGE_SIZE);	
			
			 if(pager==null){
				 for(int i= 0;i<Config.SEARCH_PAGE_SIZE;i++){
					 Document doc = searcher.doc(topDocs.scoreDocs[i].doc);
					 ByteArrayInputStream byteIn = new ByteArrayInputStream(doc.getBinaryValue("data"));  
					 ObjectInputStream in = new ObjectInputStream(byteIn);  
					 T t = (T) in.readObject();  				 
					 list.add(t);
				 }
				 
			 }else{
				 int start=(pager.getPageNumber()-1>0? pager.getPageNumber()-1:0)*pager.getPageSize();
				 int end=start+pager.getPageSize();
				 if(end>topDocs.totalHits)
					 end=topDocs.totalHits;
				 for(int i= start;i<end;i++){
					 Document doc = searcher.doc(topDocs.scoreDocs[i].doc);
					 list.add(dao.fetch(clazz, Integer.parseInt(doc.get("ID"))));
				 }
				 
			 }
			 
			   
		  } catch (IOException ex)
		  { 
				System.err.println("分析用户查询出错");
				 ex.printStackTrace();
				 return list;
		  } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 return list;
	 };
	 

}
