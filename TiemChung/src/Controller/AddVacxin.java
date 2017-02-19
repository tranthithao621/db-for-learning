package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.VacxinBO;

/**
 * Servlet implementation class AddVacxin
 */
@WebServlet("/AddVacxin")
public class AddVacxin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVacxin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			VacxinBO vacxinBO = new VacxinBO();
			String tenvacxin= request.getParameter("tenvacxin");
			
			if( "".equals(tenvacxin)){
				request.setAttribute("loiten", "Thiếu thông tin");
				
			}else if(vacxinBO.kiemTraTen(tenvacxin)==false){
				request.setAttribute("loiten", "Tên Vacxin đả có !!");
			}else{
				int tuoitoithieu =Integer.parseInt(request.getParameter("tuoitoithieu"));
				int tuoitoida = Integer.parseInt(request.getParameter("tuoitoida"));
				int maloaivacxin=Integer.parseInt(request.getParameter("maloaivacxin"));
				int somui=Integer.parseInt(request.getParameter("somui"));
				if((tuoitoithieu<=0 || tuoitoithieu >100) || (tuoitoida <=0|| tuoitoida>100)){
					request.setAttribute("loituoi", "Tuổi phải nằm trong khoảng từ 0 đến 100 ");
				}else if(somui<=0){
					request.setAttribute("loisomui", "Số mũi phải lớn hơn 0 ");
				}else{
					vacxinBO.addVacxin(tenvacxin, tuoitoithieu, tuoitoida, somui,maloaivacxin);
					request.setAttribute("thanhcong", "Thêm vacxin thành công");
				}
				
			}
			RequestDispatcher rd = request.getRequestDispatcher("ShowAddVacxin");
			rd.forward(request, response);
		}catch(Exception tt){
			response.getWriter().println("<html><body> Loi : "+tt.getMessage()+"</body><html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
