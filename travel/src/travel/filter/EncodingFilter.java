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
		System.out.println("doFilter메소드호출");
		if(encoding!=null){
			req.setCharacterEncoding(encoding);
		}
		//다음에 수행할 필터가 있으면 필터를 수행하고 더 이상 수행할 필터가 없으면 요청페이지로 이동
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		//web.xml에 설정된 초기화 파라미터 읽어오기
		encoding=config.getInitParameter("encoding");
	}

}
