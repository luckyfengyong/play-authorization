/**
 * 
 */
package zb.eptools.helpers;

import java.io.File;
import java.util.List;

/**
 * @author <a href="mailto:zou.b@neusoft.com">�޲�</a>
 *
 */
public interface ResourceHelper {
	
	public static final String FILE_ENCODING="GBK";
	

	/**
	 * ��ʵ�������й��˵�����Ҫ�������Դ��ֱ��return����
	 * @param resourcePath
	 */
	void process(File resourceFile);
	
	/**
	 * ��֤�ļ��Ƿ����Helper����
	 */
	boolean fit(File resourceFile);
	
	/**
	 * ��ȡ������
	 * @return
	 */
	List<Object> getResources();
	
	/**
	 * ����ͨ��getResourceClassָ��class���ͣ�����ȡת�ͺ������
	 * @param clazz
	 * @return
	 */
	<T> List<T> getResources(Class<T> clazz);
	
	/**
	 * ��ȡ��Դ����
	 * @return
	 */
	Class<?> getResourceClass();
}
