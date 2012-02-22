package zb.eptools.ep;

import java.util.List;

/**
 * ָ����ҳ�棨View������������Controller����ҵ���ࣨModel����һ�鹦��
 * @author <a href="mailto:zou.b@neusoft.com">�޲�</a>
 *
 */
public class Module {

	/**
	 * �����ϵ������
	 * Module(1) ---- Component(1) ---- View(1-*)
	 * Module(1) ---- Component(1) ---- Bo(1-*)
	 */
	
	public String name;
	
	public List<View> views;
	
	/**
	 *  ʵ���ϣ�ÿ����������Ӧһ��ģ�飻
	 *  View�����ж��ҳ�棨��ÿ�����Ӧ��js��
	 */
	public Component component;
}
