package com.hospiatlmangement.Service;

import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Nursing_staff;

public interface Nursing_staffService {
	
	public FinalResponse GetNursingStaff();
	
	public FinalResponse DeleteNurseByid(int nurse_id);
	
    public FinalResponse AddNurse(Nursing_staff nurse);
    
    public FinalResponse  GetNursebyid(int nurse_id);

    public FinalResponse UpdateNurse(Nursing_staff nursingdtaff);

}
