package in.suraj.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.suraj.dto.ViewEnqFilterRequest;
import in.suraj.entity.Counsellor;
import in.suraj.entity.Enquiry;
import in.suraj.repo.CounsellorRepo;
import in.suraj.repo.EnquiryRepo;
import io.micrometer.common.util.StringUtils;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	private EnquiryRepo enqRepo;

	private CounsellorRepo counsRepo;

	public EnquiryServiceImpl(EnquiryRepo enquiryRepo, CounsellorRepo counsellorRepo) {
		this.enqRepo = enquiryRepo;
		this.counsRepo = counsellorRepo;
	}

	@Override
	public boolean addEnquiry(Enquiry enquiry, Integer counsellorId) throws Exception {

		Counsellor counsellor = counsRepo.findById(counsellorId).orElse(null);
		if (counsellor == null) {
			throw new Exception("No Counsellor Found");

		}
		// associating counsellor to enquriy
		enquiry.setCounsellor(counsellor);

		Enquiry save = enqRepo.save(enquiry);
		if (save.getEnq_id() != null) {
			return true;

		}

		return false;
	}

	@Override
	public List<Enquiry> getAllEnquiries(Integer counsellorId) {

		return enqRepo.getEnquriesByCounsellorId(counsellorId);
	}

	@Override
	public Enquiry getEnquiryById(Integer enqId) {

		return enqRepo.findById(enqId).orElse(null);
	}

	@Override
	public List<Enquiry> getEnquiriesWithFilter(ViewEnqFilterRequest filterRequest, Integer counsellorId) {

		// QBE implementation (Dynamic Query Preparation)
		Enquiry enq = new Enquiry();

		if (StringUtils.isNotEmpty(filterRequest.getClassMode())) {
			enq.setClassMode(filterRequest.getClassMode());
		}

		if (StringUtils.isNotEmpty(filterRequest.getCourseName())) {
			enq.setCourseName(filterRequest.getCourseName());
		}

		if (StringUtils.isNotEmpty(filterRequest.getEnqStatus())) {
			enq.setEnqStatus(filterRequest.getEnqStatus());
		}

		Counsellor c = counsRepo.findById(counsellorId).orElse(null);
		enq.setCounsellor(c);
		Example<Enquiry> of = Example.of(enq);
		List<Enquiry> enqList = enqRepo.findAll(of);

		return enqList;
	}
}
