package in.suraj.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.suraj.entity.Enquiry;

public interface EnquiryRepo extends JpaRepository<Enquiry, Integer> {
	@Query(value = "select * from enquiries_tbl where counsellor_id = :counsellorId",
		       nativeQuery = true)
		public List<Enquiry> getEnquriesByCounsellorId(
		        @Param("counsellorId") Integer counsellorId);
}
