package com.carmanager.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.carmanager.entities.User;
import com.carmanager.utils.SenderMailUtils;

@Service("senderMailService")
public class SenderMailService {

	@Autowired
	private TaskExecutor taskExecutor;// 异步线程执行器 在文档的最后有说明
	@Autowired
	private SenderMailUtils senderMailUtils;

	// 下面是关键部分，为了将会员的注册和发送邮件不在一个线程下执行我们需要将发送邮件的操作另开启一个线程去完成，这样一来会员的注册就不会因为发送邮件而发生等待的过程。
	public void sendMail(final User user) {
		taskExecutor.execute(new Runnable() {
			public void run() {
				senderMailUtils.sendMail(user);
			}
		});

	}
}