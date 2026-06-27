package in.suraj.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.suraj.dto.DashboardResponse;
import in.suraj.entity.Counsellor;
import in.suraj.entity.Enquiry;
import in.suraj.repo.CounsellorRepo;
import in.suraj.repo.EnquiryRepo;
@Service
public class CounsellorServiceImpl implements CounsellorService {
	@Autowired
	private CounsellorRepo counsellorRepo;
	@Autowired
	private EnquiryRepo enquiryRepo;

	@Override
	public Counsellor findByEmail(String email) {

		return counsellorRepo.findByEmail(email);
	}

	@Override
	public boolean register(Counsellor counsellor) {
		Counsellor savedCounsellor = counsellorRepo.save(counsellor);
		if (null != savedCounsellor.getCounsellor_id()) {
			return true;
		}
		return false;
	}

	@Override
	public Counsellor login(String email, String pwd) {
		Counsellor counsellor = counsellorRepo.findByEmailAndPwd(email, pwd);
		return counsellor;
	}

	@Override
	public DashboardResponse getDashboardInfo(Integer CounsellorId) {
		DashboardResponse response = new DashboardResponse();
		List<Enquiry> enqList = enquiryRepo.getEnquriesByCounsellorId(CounsellorId);
		int totalEnq = enqList.size();
		int enrolledEnqs = enqList.stream().filter(e -> e.getEnqStatus().equals("Enrolled"))
				.collect(Collectors.toList()).size();
		int lostenqs = enqList.stream().filter(e -> e.getEnqStatus().equals("Lost")).collect(Collectors.toList())
				.size();
		int openEnqs = enqList.stream().filter(e -> e.getEnqStatus().equals("Open")).collect(Collectors.toList())
				.size();
		response.setTotalEnqs(totalEnq);
		response.setEnrolledEnqs(enrolledEnqs);
		response.setLostEnqs(lostenqs);
		response.setOpenEnqs(openEnqs);
		return response;
	}

}
