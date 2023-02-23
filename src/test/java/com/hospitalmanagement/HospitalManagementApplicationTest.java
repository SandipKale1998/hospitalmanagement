package com.hospitalmanagement;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
@SpringBootTest(classes =HospitalManagementApplication.class)
class HospitalManagementApplicationTest {


	@MockBean
	private HospitalManagementApplication hospital;
   
	@Test
	void ContextLoads() {
		Assertions.assertThat(hospital).isNotNull();
	  
	}
}
