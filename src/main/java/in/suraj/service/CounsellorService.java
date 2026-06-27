package in.suraj.service;

import in.suraj.dto.DashboardResponse;
import in.suraj.entity.Counsellor;

public interface CounsellorService {
	public Counsellor findByEmail(String email);

	public boolean register(Counsellor counsellor);

	public Counsellor login(String email, String pwd);

	public DashboardResponse getDashboardInfo(Integer CounsellorId);

}
