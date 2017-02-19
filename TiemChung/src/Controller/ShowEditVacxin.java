package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.LoaiVacxinBO;
import Model.BO.VacxinBO;

/**
 * Servlet implementation class ShowEditVacxin
 */
@WebServlet("/ShowEditVacxin")
public class ShowEditVacxin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowEditVacxin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			VacxinBO vacxinBO = new VacxinBO();
			LoaiVacxinBO loaiVacxinBO = new LoaiVacxinBO();
			request.setAttribute("loaivacxin", loaiVacxinBO.getLoaiVacxin());
			int mavacxin = Integer.parseInt(request.getParameter("mavacxin"));
			request.setAttribute("motvacxin", vacxinBO.get1Vacxin(mavacxin));
			RequestDispatcher rd = request.getRequestDispatcher("ShowEditVacxin.jsp");
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
