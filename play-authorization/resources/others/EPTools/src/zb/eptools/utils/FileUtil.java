/**
 * 
 */
package zb.eptools.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * �ļ�������صı�ݷ���
 * @author <a href="mailto:zou.b@neusoft.com">�޲�</a>
 */
public class FileUtil {

	
	public static List<File> findFileByExtensionRecurse(String dir,String extension){
		if(StringUtil.isEmpty(dir))
			throw new IllegalArgumentException("Invalid parameter input ("+dir+").");
		
		File dirFile=new File(dir);
		if(!dirFile.exists())
			throw new IllegalArgumentException("Directory specified ("+dir+") doesn't exist");
		
		List<File> files=new LinkedList<File>(); 
		listFileByExtensionRecurse(new File(dir),extension,files);
		
		return files;
	}
	
	
	/**
	 * �����ַ������ȡ�ı��ļ�����
	 * @param file �ļ�
	 * @param fileEncoding �ļ����룬����UTF-8��GB2312�����ʱͳһΪUTF-8
	 * @return
	 */
	public static String readFile(File file,String fileEncoding){
		if(file==null || !file.exists())
			return null;
		
		fileEncoding=fileEncoding==null?"UTF-8":fileEncoding;
		
		StringBuilder buf=new StringBuilder();
		BufferedReader br=null;
		try{
			br=new BufferedReader(new FileReader(file));
			while(true){
				String line=br.readLine();
				if(line==null)
					break;
				line=new String(line.getBytes(fileEncoding),"UTF-8");
				buf.append(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return buf.toString();
	}
	
	
	protected static List<File> listFileByExtensionRecurse(File dirFile,String extension, List<File> result){
		if(result==null)
			result=new LinkedList<File>();
		
		if(dirFile==null || !dirFile.exists())
			throw new IllegalArgumentException("Directory specified ("+(dirFile==null?null:dirFile.getAbsolutePath())+") doesn't exist");
		
		if(dirFile.isDirectory()){
			File[] files=dirFile.listFiles();
			for(File f:files){
				if(f.isDirectory()){
					// recursively invocation
					listFileByExtensionRecurse(f,extension,result);
				}
				_appendAfterFilter(f,extension,result);
			}
			
		}else{
			_appendAfterFilter(dirFile,extension,result);
		}
		return result;
	}
	
	
	private static void _appendAfterFilter(File file,String extension, List<File> result){
		if(file.isDirectory()){
			// filtered
		}else{
			if(StringUtil.isEmpty(extension))
				result.add(file);
			else if(file.getName().endsWith(extension))
				result.add(file);
			else
				;// filtered
		}
	}
}
