package com.cpjb011.springrest.taskapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpjb011.springrest.taskapp.bean.TaskIO;
import com.cpjb011.springrest.taskapp.dao.PtaskDao;
import com.cpjb011.springrest.taskapp.dao.TaskDao;
import com.cpjb011.springrest.taskapp.entity.Ptask;
import com.cpjb011.springrest.taskapp.entity.Task;
import com.cpjb011.springrest.taskapp.exceptions.TaskNotFoundException;

@Service
@Transactional
public class TaskService {

	@Autowired
	private PtaskDao ptaskDao;

	@Autowired
	TaskDao taskDao;

	public List<TaskIO> allTaskDetails() {
		return taskDao.fetchTaskDetails();
	}

	public TaskIO addTask(TaskIO tio) {
		Ptask pt = ptaskDao.findByPtask(tio.getPtask());
		Task tsk = new Task();
		Task ntsk = new Task();
		Ptask ptsk = new Ptask();
		ptsk.setPtask(tio.getPtask());
		tsk.setTask(tio.getTask());
		tsk.setPriority(tio.getPriority());
		tsk.setSdate(tio.getSdate());
		tsk.setEdate(tio.getEdate());
		tsk.setTid(taskDao.getmaxTaskId() + 1);
		if (pt != null) {
			System.out.println(pt.getPid());
			tsk.setPid(pt.getPid());
			ntsk = taskDao.saveAndFlush(tsk);
		} else {
			ptsk.setPid(ptaskDao.getmaxPtaskId() + 1);
			// ptaskDao.save(ptsk);
			ptsk = ptaskDao.saveAndFlush(ptsk);
			tsk.setPid(ptsk.getPid());
			ntsk = taskDao.saveAndFlush(tsk);
		}
        tio.setTid(ntsk.getTid());
		return tio;
	}

	public List<TaskIO> delTask(int delid) {
		Optional opt = taskDao.findById(delid);
		if (opt.isPresent()) {
			taskDao.deleteById(delid);
			List<TaskIO> tlst = allTaskDetails();
			return tlst;
		} else {

			throw new TaskNotFoundException("id:" + delid + "is not found for delete");

		}

	}

	public TaskIO updTask(TaskIO tio) {

		Task tsk = new Task();
		Task ntsk = new Task();
		Optional opt = taskDao.findById(tio.getTid());
		if (opt.isPresent()) {
			Ptask pt = ptaskDao.findByPtask(tio.getPtask());
			if (pt != null) {
				tsk.setPid(pt.getPid());
			} else {

				Ptask npt = new Ptask();
				npt.setPtask(tio.getPtask());
				// System.out.println("Maximum Parent Task Id:"
				// +ptaskDao.getmaxPtaskId() + 1 );
				npt.setPid(ptaskDao.getmaxPtaskId() + 1);
				npt = ptaskDao.saveAndFlush(npt);
				tsk.setPid(npt.getPid());
			}

			tsk.setTask(tio.getTask());
			tsk.setPriority(tio.getPriority());
			tsk.setSdate(tio.getSdate());
			tsk.setEdate(tio.getEdate());
			tsk.setTid(tio.getTid());

			ntsk = taskDao.saveAndFlush(tsk);
			return tio;

		} else {
			throw new TaskNotFoundException("id:" + tio.getTid() + "is not found for update");
		}
	}

}
