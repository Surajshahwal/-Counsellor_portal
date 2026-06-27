package in.suraj.service;

import java.util.List;

import in.suraj.dto.ViewEnqFilterRequest;
import in.suraj.entity.Enquiry;

public interface EnquiryService {
	public boolean addEnquiry(Enquiry enquiry, Integer counsellorId) throws Exception;

	public List<Enquiry> getAllEnquiries(Integer counsellorId);

	public List<Enquiry> getEnquiriesWithFilter(ViewEnqFilterRequest filterRequest, Integer counsellorId);

	public Enquiry getEnquiryById(Integer enqId);
}

