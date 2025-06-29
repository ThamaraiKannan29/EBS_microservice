package com.sprint1.ebs.user.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sprint1.ebs.user.dto.EbsConnection;

@FeignClient(name="ebs-connection", url = "http://ebsconnection-service-container:9595/")
public interface EbsConnectionProxy {

	@GetMapping("/electricity-billing-service/connection/customer/{custId}/connection")
	public List<EbsConnection> getAllConnectionsForCustomer(@PathVariable("custId") Long custId);
}
