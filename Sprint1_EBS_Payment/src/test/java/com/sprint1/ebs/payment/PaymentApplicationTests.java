/*
 * package com.sprint1.ebs.payment;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.mockito.Mockito.when;
 * 
 * import java.time.LocalDate;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean;
 * 
 * import com.sprint1.ebs.payment.entity.Payment; import
 * com.sprint1.ebs.payment.repo.PaymentRepository; import
 * com.sprint1.ebs.payment.service.PaymentService;
 * 
 * @SpringBootTest class PaymentApplicationTests {
 * 
 * @Autowired private PaymentService service;
 * 
 * @MockBean PaymentRepository repo;
 * 
 * @Test void contextLoads() { }
 * 
 * @Test void createPayment(){ Payment p = new Payment((long) 1,(long)
 * 1,LocalDate.of(2022, 05, 05)); when(repo.save(p)).thenReturn(p);
 * //when(service.createPayment(p)).thenReturn(p); //
 * doReturn(p).when(service).createPayment(p);
 * assertEquals(service.createPayment(p),p); }
 * 
 * @Test void checkPaymentByID() throws PaymentIdNotFoundException{ Payment p =
 * new Payment((long) 1,new Bill(),LocalDate.of(2022, 05, 05));
 * when(repo.findById((long) 1).get()).thenReturn(p);
 * //when(service.createPayment(p)).thenReturn(p); //
 * doReturn(p).when(service).createPayment(p);
 * assertEquals(service.getPaymentById((long) 1),p); }
 * 
 * 
 * }
 */
