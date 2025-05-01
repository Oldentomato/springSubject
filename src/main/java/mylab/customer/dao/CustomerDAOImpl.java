package mylab.customer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mylab.customer.dao.mapper.CustomerMapper;
import mylab.customer.vo.CustomerVO;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public List<CustomerVO> selectAllCustomer(){
		List<CustomerVO> customerList = customerMapper.selectAllCustomer();
		return customerList;
	}
	
	@Override
	public CustomerVO selectCustomer(int id) {
		CustomerVO customer = customerMapper.selectCustomerById(id);
		return customer;
	}

	@Override
	public void insertCustomer(CustomerVO customer) {
		// TODO Auto-generated method stub
		customerMapper.insertCustomer(customer);
		System.out.println("등록완료 id = "+customer.getId());
	}
}
