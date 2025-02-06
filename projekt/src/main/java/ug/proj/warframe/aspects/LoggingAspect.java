package ug.proj.warframe.aspects;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Aspekt do logowania wywołań metod oznaczonych `@LogMethodCall`.
 */
@Aspect
@Component
public class LoggingAspect {

	@Around("@annotation(ug.proj.warframe.annotations.LogMethodCall)")
	public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().toShortString();
		Object[] methodArgs = joinPoint.getArgs();

		System.out.println("🟢 Wywołanie metody: " + methodName + " z argumentami: "
				+ Arrays.toString(methodArgs));

		Object result = joinPoint.proceed();

		System.out.println("✅ Metoda " + methodName + " zakończona. Wynik: " + result);

		return result;
	}
}
