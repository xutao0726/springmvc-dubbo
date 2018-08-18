package com.jsw.interceptor;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import static org.slf4j.LoggerFactory.getLogger;
import java.lang.reflect.Field;
import org.slf4j.Logger;
/**
 * AOP日志记录实现
 * @author xutao
 * @version 1.0
 */
public class AopLog {
	private Logger logger = getLogger(getClass());
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
	private static String[] types = { "java.lang.Integer", "java.lang.Double", "java.lang.Float", "java.lang.Long","java.lang.Short", "java.lang.Byte", "java.lang.Boolean", "java.lang.Char", "java.lang.String", "int","double", "long", "short", "byte", "boolean", "char", "float" };
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = joinPoint.proceed();
		String classType = joinPoint.getTarget().getClass().getName();
		Class<?> clazz = Class.forName(classType);
		String clazzName = clazz.getName();
		String methodName = joinPoint.getSignature().getName();
		try {
			String logContent = logMsg(getFieldsName(this.getClass(), clazzName, methodName), joinPoint);
			if("".equals(logContent) || null == logContent)
			return result;
			logger.info(sdf.format(new Date())+"AOP log parameter:"+logContent);
			logger.info(sdf.format(new Date())+"AOP log qualified name:"+joinPoint.getSignature().toString());
			logger.info(sdf.format(new Date())+"AOP log simple name:"+methodName);
		} catch (Exception e) {
			logger.error(sdf.format(new Date())+"AOP log error",e);
		}
		return result;
	}
	private static String logMsg(String[] paramNames, JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		StringBuilder sb = new StringBuilder();
		boolean clazzFlag = true;
		for (int k = 0; k < args.length; k++) {
			Object arg = args[k];
			sb.append(paramNames[k] + " ");
			String typeName = args[k].getClass().getSimpleName();
			for (String t : types) {
				if (t.equals(typeName))
				sb.append("=" + arg + "; ");
			}
			if (clazzFlag)
			sb.append(getFieldsValue(arg));
		}
		return sb.toString();
	}
	private static String[] getFieldsName(@SuppressWarnings("rawtypes") Class cls, String clazzName, String methodName) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		ClassClassPath classPath = new ClassClassPath(cls);
		pool.insertClassPath(classPath);
		CtClass cc = pool.get(clazzName);
		CtMethod cm = cc.getDeclaredMethod(methodName);
		MethodInfo methodInfo = cm.getMethodInfo();
		CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
		LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
		String[] paramNames = new String[cm.getParameterTypes().length];
		int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
		for (int i = 0; i < paramNames.length; i++)
		paramNames[i] = attr.variableName(i + pos);
		return paramNames;
	}
	public static String getFieldsValue(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		String typeName = obj.getClass().getSimpleName();
		for (String t : types) {
			if (t.equals(typeName))
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Field f : fields) {
			f.setAccessible(true);
			try {
				for (String str : types) {
					if (f.getType().getName().equals(str))
					sb.append(f.getName() + " = " + f.get(obj) + "; ");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
