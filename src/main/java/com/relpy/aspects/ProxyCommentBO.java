package com.relpy.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ProxyCommentBO {
	@Pointcut("execution(* com.relpy.bo.Comment.isValid*(..))")
	public void CommentBO() {}
	
	@Pointcut("execution(* com.relpy.bo.Comment.enough*(..))")
	public void CommentBO2() {}
	
	@Before("CommentBO()")
	public void beforeAdvice(JoinPoint jp) {
		System.out.println("Before execution of "+jp.getSignature());
	}
	
	@After("CommentBO()")
	public void afterAdvice(JoinPoint jp) {
		System.out.println("After execution of "+jp.getSignature());
	}
	
	@Before("CommentBO2()")
	public void beforeAdvice2(JoinPoint jp) {
		System.out.println("Before execution of "+jp.getSignature());
	}
	
	@After("CommentBO2()")
	public void afterAdvice2(JoinPoint jp) {
		System.out.println("After execution of "+jp.getSignature());
	}
}
