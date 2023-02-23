package com.hospitalmanagement.Repository;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalmangement.bean.Admin;

@Repository
public class AdminRepositoryImplementation implements AdminRepository {

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> GetAdmin() {
		Query query = entityManager.createNativeQuery("select * from admin");
		List<Object[]> admin = query.getResultList();
		return admin;
	}

	@Transactional
	@Override
	public String InsertAdmin(Admin admin) {
		Query query = entityManager.createNativeQuery("insert Into admin values(?,?,?,?,?,?,?)");
		query.setParameter(1, admin.getAdminId());
		query.setParameter(2, admin.getFirstName());
		query.setParameter(3, admin.getLastName());
		query.setParameter(4, admin.getContactNo());
		query.setParameter(5, admin.getCity());
		query.setParameter(6, admin.getUsername());
		query.setParameter(7, admin.getPassword());
		query.executeUpdate();
		return "inserted";
	}

	@Transactional
	@Override
	public String DeleteAdminByid(int adminId) {
		Query query = entityManager.createNativeQuery("delete from admin where admin_id=?");
		query.setParameter(1, adminId);
		query.executeUpdate();
		return "Admin was deleted";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> GetAdminByid(int adminId) {
		Query query = entityManager.createNativeQuery("select * from admin where admin_id=?");
		query.setParameter(1, adminId);
		List<Object[]> admin = query.getResultList();
		return admin;
	}

	@Override
	public Admin UpdateAdmin(Admin admin) {
		Query query = entityManager.createNativeQuery(
				"update admin set firstname=?,lastname=?,contact_no=?, city=? , username=? , password=? where adminid=?");
		query.setParameter(1, admin.getAdminId());
		query.setParameter(2, admin.getFirstName());
		query.setParameter(3, admin.getLastName());
		query.setParameter(4, admin.getContactNo());
		query.setParameter(5, admin.getCity());
		query.setParameter(6, admin.getUsername());
		query.setParameter(7, admin.getPassword());
		query.executeUpdate();
		return admin;
	}

	@Override
	public Admin GetAdminBy(int adminId) {
		Query query = entityManager.createNamedQuery("select * from admin where admin_id=?");
		Admin admin = (Admin) query.getSingleResult();
		return admin;
	}

	@Override
	public Object Login1(String password) {
		Query query = entityManager.createNativeQuery("select * from admin where password=?");
		query.setParameter(1, password);
		Object admin = null;
		try {
			admin = query.getSingleResult();
		} catch (NoResultException ex) {
			System.out.println(ex);
		}
		return admin;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> checkUsersName() {
		Query query = entityManager.createNativeQuery("SELECT USERNAME FROM Admin");
		List<Object> userList = null;
		try {
			userList = query.getResultList();
		} catch (NoResultException e) {
			e.getMessage();
		}
		return userList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> checkUsersPassword() {
		Query query = entityManager.createNativeQuery("SELECT PASSWORD FROM Admin");
		List<Object> passwordList = null;
		try {
			passwordList = query.getResultList();
		} catch (NoResultException e) {
			e.getMessage();
		}
		return passwordList;
	}

	// login by mobile number
	public Admin adminLoginByMobileNumber(String mobileNumber, String password) {
		Query query = entityManager.createNativeQuery("select * from admin where contact_no=? and password=?");
		query.setParameter(1, mobileNumber);
		query.setParameter(2, password);
		Admin admin = null;
		try {
			admin = (Admin) query.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return admin;
	}

	@Override
	public String checkadminIsPresentByMobileNumber(String mobileNumber) {
		Query query = entityManager.createNativeQuery("select password from admin where contact_no=?");
		query.setParameter(1, mobileNumber);
		String password = null;
		try {
			password = (String) query.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return password;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllmobile() {
		Query query = entityManager.createNativeQuery("select contact_no  from admin ");
		List<String> mobile = null;
		try {
			mobile = query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mobile;
	}

	@Override
	@Transactional
	public String UpdateOtp(int otp, Date OtpDate, String mobileNumber) {
		Query query = entityManager.createNativeQuery("update admin set otp=?,otp_expirytime=? where contact_no=?");
		query.setParameter(1, otp);
		query.setParameter(2, OtpDate);
		query.setParameter(3, mobileNumber);
		try {
			query.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "update is done";
	}

	@Override
	public int checkotp(String mobileNumber) {
		Query query = entityManager.createNativeQuery("select otp from admin where contact_no=?");
		query.setParameter(1, mobileNumber);
		int otp = 0;
		try {
			otp = (int) query.getSingleResult();

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return otp;
	}

	@Override
	public String verficationotp(int otp, String mobileNumber) {
		Query query = entityManager.createNativeQuery("select * from admin where otp=? and contact_no=?");
		query.setParameter(1, otp);
		query.setParameter(2, mobileNumber);
		try {
			query.getSingleResult();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return "verification is done";
	}

	@Override
	public Date toGetDBOtpTime(String mobileNo) {
		Query query = entityManager.createNativeQuery("SELECT otp_expirytime FROM admin WHERE contact_no = ?");
		query.setParameter(1, mobileNo);
		Date otp = null;
		try {
			otp = (Date) query.getSingleResult();
		} catch (InputMismatchException e) {
			e.getMessage();
		}
		return otp;
	}

	@Override
	public Object Login(String userName, String password) {
		 Query query
		 = entityManager.
		  createNativeQuery("select * from admin where username=? and password=?");
		  query.setParameter(1, userName); query.setParameter(2, password); Object
		  admin = null; try { admin = query.getSingleResult(); } catch
		  (NoResultException ex) { System.out.println(ex); } return admin;
	}
}

/*
 * @Override public Object Login(String userName, String password) { Query query
 * = entityManager.
 * createNativeQuery("select * from admin where username=? and password=?");
 * query.setParameter(1, userName); query.setParameter(2, password); Object
 * admin = null; try { admin = query.getSingleResult(); } catch
 * (NoResultException ex) { System.out.println(ex); } return admin;
 * 
 * }
 */