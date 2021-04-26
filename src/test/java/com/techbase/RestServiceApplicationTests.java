package com.techbase;

import com.techbase.dto.EmployeeDTO;
import com.techbase.service.EmployeeService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestServiceApplication.class)
public class RestServiceApplicationTests {
	@Autowired
	private EmployeeService employeeService;

	@DisplayName("get normal list")
	@Test
	public void testNormal() {
		Pageable pageable = PageRequest.of(0, 20);
		Page<EmployeeDTO> list = employeeService.getList(pageable);
		assertNotEquals(list.getContent().size(),0);
	}
	@Test
	public void textNextPage() {
		Pageable pageable = PageRequest.of(1, 2);
		Page<EmployeeDTO> list = employeeService.getList(pageable);
		assertNotEquals(list.getContent().size(),0);
	}
	@Test
	public void testMax() {
		Pageable pageable = PageRequest.of(0, 1500);
		Page<EmployeeDTO> list = employeeService.getList(pageable);
		assertEquals(list.getContent().size(), 1500);
	}
}
