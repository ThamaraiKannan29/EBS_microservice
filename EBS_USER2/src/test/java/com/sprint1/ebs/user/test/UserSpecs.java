/*
 * package com.sprint1.ebs.user.test;
 * 
 * import static org.junit.jupiter.api.Assertions.*; import static
 * org.mockito.Mockito.verify; import static org.mockito.Mockito.when;
 * 
 * import java.util.ArrayList; import java.util.Arrays; import java.util.List;
 * import java.util.Optional; import org.junit.jupiter.api.AfterAll; import
 * org.junit.jupiter.api.AfterEach; import org.junit.jupiter.api.BeforeAll;
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * com.sprint1.ebs.user.entities.Customer; import
 * com.sprint1.ebs.user.exception.CustomerIdNotFoundException; import
 * com.sprint1.ebs.user.repo.CustomerRepository; import
 * com.sprint1.ebs.user.repo.UserRepository; import
 * com.sprint1.ebs.user.service.UserService; import
 * com.sprint1.ebs.user.service.UserServiceImpl;
 * 
 * 
 * @SpringBootTest class UserSpecs {
 * 
 * @Mock UserRepository repo2;
 * 
 * @Mock CustomerRepository repo;
 * 
 * @InjectMocks UserService service = new UserServiceImpl();
 * 
 * List<Customer> customers=new ArrayList<>();
 * 
 * 
 * 
 * Customer c1,c2,c3;
 * 
 * @BeforeAll static void setUpBeforeClass() throws Exception { }
 * 
 * @AfterAll static void tearDownAfterClass() throws Exception { }
 * 
 * @BeforeEach void setUp() throws Exception { c1 = new
 * Customer("Hari","8474857483","Mumbai",Arrays.asList(43L)); c2 = new
 * Customer("Vino","8220132468","Chennai",Arrays.asList(23L)); c3 = new
 * Customer("Jeeva","7383432329","Madurai",Arrays.asList(3L));
 * customers.add(c1); customers.add(c2); customers.add(c3); }
 * 
 * @AfterEach void tearDown() throws Exception { }
 * 
 * @Test void testAddCustomer() { when(repo.save(c1)).thenReturn(c1); Customer
 * retVal = service.addCustomer(c1); assertEquals(c1,retVal); }
 * 
 * @Test void testListAllCustomer() {
 * when(repo.findAll()).thenReturn(customers); List<Customer> cust =
 * service.listAllCustomers(); assertEquals(customers,cust); }
 * 
 * @Test void testGetCustomerById() throws CustomerIdNotFoundException {
 * when(repo.findById(c1.getUserID())).thenReturn(Optional.of(c1));
 * assertEquals(c1,service.findById(c1.getUserID())); }
 * 
 * @Test public void updateCustomerTest() throws CustomerIdNotFoundException {
 * when(repo2.findById(c1.getUserID())).thenReturn(Optional.of(c1));
 * when(repo2.save(c1)).thenReturn(c3);
 * assertEquals(c3,service.updateCustomer(c3,c1.getUserID())); }
 * 
 * @Test void testDeleteCustomer() {
 * when(repo.findById(c1.getUserID())).thenReturn(Optional.of(c1));
 * service.deleteCustomer(c2.getUserID());
 * verify(repo).deleteById(c1.getUserID()); }
 * 
 * @Test void testGetAllCustomers() {
 * when(repo.findAll()).thenReturn(customers); List<Customer> cust =
 * service.listAllCustomers(); assertEquals(3,cust.size()); } }
 */
