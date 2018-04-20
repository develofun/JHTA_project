package travel.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	String encoding;
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter�޼ҵ�ȣ��");
		if(encoding!=null){
			req.setCharacterEncoding(encoding);
		}
		//������ ������ ���Ͱ� ������ ���͸� �����ϰ� �� �̻� ������ ���Ͱ� ������ ��û�������� �̵�
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		//web.xml�� ������ �ʱ�ȭ �Ķ���� �о����
		encoding=config.getInitParameter("encoding");
	}

}
