package com.carmanager.controllers.admin;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carmanager.constant.WebConstant;
import com.carmanager.entities.FaultCode;
import com.carmanager.entities.Page;
import com.carmanager.services.FaultCodeService;

@Controller
@RequestMapping("/admin/faultcode")
public class AdminFaultCodeController {

	@Autowired
	private FaultCodeService faultCodeService;
	private Page<FaultCode> p = null;
	private int pageSize = WebConstant.PAGE_SIZE;

	@RequiresPermissions(value="faultcode:query")
	@RequestMapping(value="/list/{pageNo}",method=RequestMethod.GET)
	public String list(@PathVariable("pageNo") int pageNo, Map<String,Object> map){
		p = faultCodeService.listFaultCodePage(pageNo,pageSize);
		map.put("page", p);
		return "fault/list";
	}
}
