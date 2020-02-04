package com.relpy.services.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class CommunityServicesAdvice {

	Logger log = LoggerFactory.getLogger(CommunityServicesAdvice.class);
	
	@Pointcut(value="execution(* com.relpy.services.CommunityService.*(..))")
	public void allMethodsPointCut() {
	}
	
	@Before("allMethodsPointCut()")
	public void beforeAllMethods(JoinPoint jp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String method = jp.getSignature().getName();
		String className = jp.getTarget().getClass().toString();
		Object[] arguments = jp.getArgs();
		log.info("Class: " + className + 
				"; Method: " + method + "()" + 
				"; Arguments : " + mapper.writeValueAsString(arguments));
	}
	
	@AfterThrowing(pointcut = "execution(* com.relpy.services.CommunityService.*(..))", throwing = "e")
	public void throwingAllMethods(JoinPoint jp, Throwable e) throws Throwable {
		System.out.println("Method Signature: "  + jp.getSignature());  
		System.out.println("Exception: "+e);  
	}


}
