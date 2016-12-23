package com.niit.bank.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.bank.model.Job;
import com.niit.bank.model.JobApplication;


@EnableTransactionManagement
@Repository(value = "jobDAO")
public class JobDAOImpl implements JobDAO {
	public JobDAOImpl() {
		System.out.println("in JobDAO Impl");
	}

	@Autowired
	private SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public boolean save(Job job) {
		try {
			sessionFactory.getCurrentSession().save(job);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Job job) {
		try {
			sessionFactory.getCurrentSession().delete(job);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Job get(int jobid) {
		String hql = "from Job where jobid=" + "'" + jobid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Job> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}

	@Transactional
	public List<Job> list() {
		String hql = "from Job";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public boolean postjob(Job job) {

		try {
			sessionFactory.getCurrentSession().save(job);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean updatejob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean applyforjob(Job job) {

		try {
			sessionFactory.getCurrentSession().save(job);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean updatejobapplication(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public List<Job> getAllVacantJobs() {
		String hql = "From Job Where Status ='V'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public JobApplication get(int jobID, int userID) {
		String hql = " from JobApplication where userid= " + userID + "' and jobid= '" + jobID;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (JobApplication) query.list();
		}

	
	@Transactional
	public JobApplication getMyAppliedJobs(int userID) {
		String hql = " from Job where jobid in(select jobid from JobApplication where userid=" + userID + ")";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (JobApplication) query.list();
	}
	@Transactional
	public boolean updateJobApplication(JobApplication jobApplication) {
		try {
			sessionFactory.getCurrentSession().update(jobApplication);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Transactional
	public boolean applyForJob(JobApplication jobApplication) {
		try {
			sessionFactory.getCurrentSession().save(jobApplication);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public JobApplication getJobApplication(int jobID) {
		String hql = "from JobApplication where jobid=" + jobID;

		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<JobApplication> list = (List<JobApplication>) query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("job retrieved from DAOImpl");
			return list.get(0);
		} else {
			return null;
		}
	}

}
