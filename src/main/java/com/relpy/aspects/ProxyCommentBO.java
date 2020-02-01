package com.relpy.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;

@Aspect
public class ProxyCommentBO {
	@Pointcut("execution(* com.relpy.CommentServiceImpl.add*(..))")
	public void CommentService() {}
	
	//@Pointcut("execution(* com.relpy.bos.CommentBoImpl.enough*(..))")
	//public void CommentBO() {}
	
	@Before("CommentService()")
	public void beforeAdvice(JoinPoint jp) {
		System.out.println("Before execution of "+jp.getSignature());
		System.out.println("Before execution of "+jp.getSignature());
		System.out.println("Before execution of "+jp.getSignature());
		System.out.println("Before execution of "+jp.getSignature());
		System.out.println("Before execution of "+jp.getSignature());
		System.out.println("Before execution of "+jp.getSignature());
		System.out.println("Before execution of "+jp.getSignature());
		System.out.println("Before execution of "+jp.getSignature());
		System.out.println("Before execution of "+jp.getSignature());
		System.out.println("Before execution of "+jp.getSignature());
		System.out.println("Before execution of "+jp.getSignature());
		System.out.println("Before execution of "+jp.getSignature());
		System.out.println("Before execution of "+jp.getSignature());
		System.out.println("Before execution of "+jp.getSignature());
		System.out.println("Before execution of "+jp.getSignature());
	}
	
	@After("CommentBoImpl()")
	public void afterAdvice(JoinPoint jp) {
		System.out.println("After execution of "+jp.getSignature());
		System.out.println("After execution of "+jp.getSignature());
		System.out.println("After execution of "+jp.getSignature());
		System.out.println("After execution of "+jp.getSignature());
		System.out.println("After execution of "+jp.getSignature());
		System.out.println("After execution of "+jp.getSignature());
		System.out.println("After execution of "+jp.getSignature());
		System.out.println("After execution of "+jp.getSignature());
		System.out.println("After execution of "+jp.getSignature());
		System.out.println("After execution of "+jp.getSignature());
		System.out.println("After execution of "+jp.getSignature());
	}
	
//	@Before("CommentBO()")
//	public void beforeAdvice2(JoinPoint jp) {
//		System.out.println("Before execution of "+jp.getSignature());
//	}
//	
//	@After("CommentBO()")
//	public void afterAdvice2(JoinPoint jp) {
//		System.out.println("After execution of "+jp.getSignature());
//	}
	
	

}

