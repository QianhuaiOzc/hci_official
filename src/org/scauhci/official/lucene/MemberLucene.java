package org.scauhci.official.lucene;

import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;
import org.apache.lucene.search.IndexSearcher;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.ioc.loader.json.JsonLoader;
import org.scauhci.official.Config;
import org.scauhci.official.bean.Member;
import org.scauhci.official.bean.Project;
import org.scauhci.official.service.DepartmentService;
import org.scauhci.official.service.MemberService;


public class MemberLucene extends BaseLucene<Member> {
	

	private static MemberLucene instance;
	
	public static MemberLucene getInstance(){
		if(instance==null){
			Ioc ioc = new NutIoc(new JsonLoader("ioc/mysql.js"));
			Dao dao= ioc.get(NutDao.class, "dao");
			instance=new MemberLucene(dao);
		}
		
		return instance;
	}
	

	private MemberService memberService;

	private DepartmentService departmentService;

	private MemberLucene(Dao dao) {
		super(dao);
		memberService=new MemberService(dao);
		departmentService=new DepartmentService(dao);
		this.clazz=Member.class;
		this.loadIndexFile();
		// TODO Auto-generated constructor stub
	}

	
	public void loadIndexFile() {
		try {
			
			List<Document> docs = new ArrayList<Document>();
			 
			  for (Member m:memberService.getAll()) 
			  { 
				  Document doc = new Document(); 
				  StringBuilder sb=new StringBuilder();
				  memberService.dao().fetchLinks(m, "extend|projects");
				  sb.append(m.getName()).append(",");
				  sb.append(m.getStudentId()).append(",");
				  if(m.getState()==Member.STATE_PROBATIONER){
					  sb.append("实习生").append(",");
				  }else  if(m.getState()==Member.STATE_GRADUATE){
					  sb.append("毕业生").append(",");
				  }
				  
				  if(m.getType()==Member.TYPE_TEACHER){
					  sb.append("老师").append(",");
				  }else  if(m.getType()==Member.TYPE_GRADUATE_STUDENT){
					  sb.append("研究生").append(",");
				  }
				  
				  sb.append(m.getExtend().getAcademy()).append(",");
				  sb.append(m.getExtend().getMajor()).append(",");
				  sb.append(m.getExtend().getNativeplace()).append(",");
				  sb.append(m.getExtend().getFamilyaddress()).append(",");
				  for(Project p:m.getProjects()){
					  sb.append(p.getName()).append(",");
					  sb.append(p.getDetail()).append(",");
				  }
				  sb.append(departmentService.getDepartment(m.getId())!=null?departmentService.getDepartment(m.getId()).getName():"无部门");
				  doc.add(new Field("ID", String.valueOf(m.getId()), Field.Store.YES, Index.NOT_ANALYZED));
				  doc.add(new Field("content",sb.toString(),Field.Store.YES, Index.ANALYZED));
				  
				  //对象序列化
				  ByteArrayOutputStream out = new ByteArrayOutputStream();
				  ObjectOutputStream oos=new ObjectOutputStream(out);
				  oos.writeObject(m);
				  oos.flush();
				  out.flush();							  
				  doc.add(new Field("data",out.toByteArray()));				  
				  docs.add(doc); 
			  } 
			
			Directory dir = SimpleFSDirectory.open(new File(Config.memberIndexPath));
			Analyzer analyzer = new IKAnalyzer();
			IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_35,analyzer);
			config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
			IndexWriter writer = new IndexWriter(dir, config);
			for (Document doc : docs) 
			  { 
				  writer.addDocument(doc); 
			  } 
			  writer.commit(); 
			  writer.close(); 
			  searcher = new IndexSearcher(IndexReader.open(dir)); 

		} catch (CorruptIndexException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
