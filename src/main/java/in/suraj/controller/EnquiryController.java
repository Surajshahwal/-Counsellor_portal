package in.suraj.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.suraj.dto.DashboardResponse;
import in.suraj.dto.ViewEnqFilterRequest;
import in.suraj.entity.Enquiry;
import in.suraj.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

	private EnquiryService enquiryService;

	public EnquiryController(EnquiryService enquiryService) {
		this.enquiryService = enquiryService;
	}

	@PostMapping("/filter-enqs")
	public String filterEnquries(@ModelAttribute("viewEnqFilter") ViewEnqFilterRequest viewEnqFilterRequest,
			HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");

		List<Enquiry> enqList = enquiryService.getEnquiriesWithFilter(viewEnqFilterRequest, counsellorId);
		model.addAttribute("enquiries", enqList);

		return "viewEnqsPage";

	}

	@GetMapping("/view-enquiries")
	public String getEnquries(HttpServletRequest request, Model model) {

		// get exiting session obj
		HttpSession session = request.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");
		List<Enquiry> enqList = enquiryService.getAllEnquiries(counsellorId);
		model.addAttribute("enquiries", enqList);

		// search form biniding object
		ViewEnqFilterRequest filterReq = new ViewEnqFilterRequest();
		model.addAttribute("viewEnqFilter", filterReq);
		return "viewEnqsPage";

	}

	@GetMapping("/enquiry")
	public String addEnquiryPage(Model model) {
		Enquiry enquiry = new Enquiry();
		model.addAttribute("enquiry", enquiry);
		return "enquiryForm";

	}

	@GetMapping("/editEnq")
	public String editEnquiry(@RequestParam("enqId") Integer enqId, Model model) {

		Enquiry enquiry = enquiryService.getEnquiryById(enqId);
		model.addAttribute("enquiry", enquiry);
		return "enquiryForm";

	}

	@PostMapping("/addEnq")
	public String handleAddEnquiry(Enquiry enquiry, Model model, HttpServletRequest req) throws Exception {

		// get existing session obj
		HttpSession session = req.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");
		boolean isSaved = enquiryService.addEnquiry(enquiry, counsellorId);
		if (isSaved) {
			model.addAttribute("smsg", "Enquiry Added");

		} else {
			model.addAttribute("emsg", "Failed To Add Enquiry");
		}
		enquiry = new Enquiry();
		model.addAttribute("enquiry", enquiry);

		return "enquiryForm";

	}
}