/**
 * 
 */
package zb.eptools.ep;

import java.util.List;

/**
 * ҵ�����
 * 
 * @author <a href="mailto:zou.b@neusoft.com">�޲�</a>
 * 
 */
public class Bo {

	public List<Bo> reliedBos;

	public String name;
	public String clazz;

	public List<MethodTransactionPolicy> methTransactionPolicies;

	/**
	 * ������Ҫ�����������֧��
	 */
	public class MethodTransactionPolicy {
		public String name;
		public String propagation;
	}
}
