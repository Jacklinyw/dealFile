package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;


public class GetFile {

	public static void main(String[] args) throws Exception {
		read();
	}

	//读取svn变更文件列表
	private static void read() throws Exception {
		//获取文件
		File file = new File("C:/Users/Administrator/Desktop/电子档案监管发布文件/changedfile.txt");
		//使用缓冲流读
		BufferedReader reader = new BufferedReader(new FileReader(file));
		// 用来保存每次读取一行的内容
		 String line = "";
         while ((line = reader.readLine()) != null) {
              System.out.println("读取："+line);
              write(line);
         }
         // 关闭输入流
         reader.close();
	}
	//将变更文件按照原路径写到待定路径下
	private static void write(String line) throws Exception {
		//更改文件的储存规则
		String replace = line.replace("D:/software/Apache/apache-tomcat-7.0.69/me-webapps/",
				"C:/Users/Administrator/Desktop/电子档案监管发布文件/");
		System.out.println("输出："+replace);
		//创建要储存的文件
		String filePath = replace.substring(0, replace.lastIndexOf("/"));
		//创建文件夹
		File files = new File(filePath);
		files.mkdirs();
		//创建文件  
		File f = new File(replace);
		f.createNewFile();
		//写出文件
		File inFile = new File(line);
		//2、开始读取信息	
		File outFile = new File(replace);
		FileOutputStream  out = new FileOutputStream(outFile);
		FileInputStream is = new FileInputStream(inFile);  
	     int n = 512;  
	     byte buffer[] = new byte[n];  
	     // 读取输入流  
	     while ((is.read(buffer, 0, n) != -1) && (n > 0)) {  
	         out.write(buffer);  
	     }  
	   out.flush();
	   out.close();
	   is.close();
	}


}
