package Model.BO;

import java.util.ArrayList;

import Model.Bean.CTVacxin;
import Model.DAO.CTVacxinDAO;

public class CTVacxinBO {
	
	CTVacxinDAO ct = new CTVacxinDAO();
	public ArrayList<CTVacxin> getCTVacxin(int mavacxin)throws Exception{
		return ct.getCTVacxin(mavacxin);
	}
}
