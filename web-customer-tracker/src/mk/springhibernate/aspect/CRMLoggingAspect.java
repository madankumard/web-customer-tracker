package mk.springhibernate.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger logger = Logger.getLogger(getClass().getName());

	// setup pointcut declaration
	@Pointcut("execution(* mk.springhibernate.controller.*.*(..))")
	public void forControllerPackage() {
	}

	// for service package
	@Pointcut("execution(* mk.springhibernate.service.*.*(..))")
	public void forServicePackage() {
	}

	// for dao package
	@Pointcut("execution(* mk.springhibernate.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {

		String method = joinPoint.getSignature().toShortString();
		logger.info("=====>> in @Before: calling method: " + method);

		Object[] args = joinPoint.getArgs();

		for (Object arg : args) {
			logger.info("=====>> Argument: " + arg);
		}
	}

	// add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {

		String method = joinPoint.getSignature().toShortString();
		logger.info("=====>> in @AfterReturning: calling method: " + method);

		logger.info("=====>> result: " + result);
	}

}
