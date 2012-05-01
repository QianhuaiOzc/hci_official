package org.scauhci.official.lucene;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;
import org.scauhci.official.Config;
import org.scauhci.official.bean.Member;
import org.scauhci.official.bean.Project;
import org.scauhci.official.service.DepartmentService;
import org.scauhci.official.service.MemberService;
import org.scauhci.official.service.ProjectService;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class ProjectLucene extends BaseLucene<Project> {

private static ProjectLucene instance;
	
	public static ProjectLucene getInstance(){
		if(instance==null){
			Ioc ioc = new NutIoc(new JsonLoader("ioc/mysql.js"));
			Dao dao= ioc.get(NutDao.class, "dao");
			instance=new ProjectLucene(dao);
		}
		
		return instance;
	}
	

	private DepartmentService departmentService;

	private ProjectService projectService;

	private ProjectLucene(Dao dao) {
		super(dao);
		departmentService=new DepartmentService(dao);
		projectService=new ProjectService(dao);
		this.clazz=Project.class;
		this.loadIndexFile();
		// TODO Auto-generated constructor stub
	}

	
	public void loadIndexFile() {
		try {
			
			List<Document> docs = new ArrayList<Document>();
			 
			  for (Project p:projectService.getAll()) 
			  { 
				  Document doc = new Document(); 
				  StringBuilder sb=new StringBuilder();
				  projectService.dao().fetchLinks(p, "members");
				  sb.append(p.getName()).append(",");
				  sb.append(p.getDetail()).append(",");
				  
				  if(p.getState()==Project.STATE_DEVELOPING){
					  sb.append("正在开发").append(",");
				  }else if(p.getState()==Project.STATE_FINISHED){
					  sb.append("结题").append(",");
				  }else{
					  sb.append("难产").append(",");
				  }

				  for(Member m:p.getMembers()){
					  sb.append(m.getName()).append(",");
					  sb.append(m.getStudentId()).append(",");
				  }
				  sb.append(departmentService.fetch(p.getDepartmentId())!=null?departmentService.fetch(p.getDepartmentId()).getName():"无部门");
				  doc.add(new Field("ID", String.valueOf(p.getId()), Field.Store.YES, Index.NOT_ANALYZED));
				  doc.add(new Field("content",sb.toString(),Field.Store.YES, Index.ANALYZED));
				  //对象序列化
				  ByteArrayOutputStream out = new ByteArrayOutputStream();
				  ObjectOutputStream oos=new ObjectOutputStream(out);
				  oos.writeObject(p);
				  oos.flush();
				  out.flush();							  
				  doc.add(new Field("data",out.toByteArray()));				  
				  docs.add(doc); 
			  } 
			
			Directory dir = SimpleFSDirectory.open(new File(Config.projectIndexPath));
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
