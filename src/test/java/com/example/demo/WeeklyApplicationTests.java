package com.example.demo;

import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ConstPool;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.LongMemberValue;
import javassist.bytecode.annotation.StringMemberValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeeklyApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void ReadTest() throws NotFoundException {
		ClassPool pool = ClassPool.getDefault();
		//获取要修改的类的所有信息
		CtClass ct = pool.get("com.example.demo.until.ScheduledTasks");
		//获取类中的方法
		CtMethod[] cms = ct.getDeclaredMethods();
		//获取第一个方法（因为只有一个方法）
		CtMethod cm = cms[0];
		System.out.println("方法名称====" + cm.getName());
		//获取方法信息
		MethodInfo methodInfo = cm.getMethodInfo();
		//获取类里的em属性
		CtField cf = ct.getField("Scheduled");
		//获取属性信息
		FieldInfo fieldInfo = cf.getFieldInfo();
		System.out.println("属性名称===" + cf.getName());

		//获取注解属性
		AnnotationsAttribute attribute = (AnnotationsAttribute) fieldInfo.getAttribute(AnnotationsAttribute.visibleTag);
		System.out.println(attribute);
		//获取注解
		Annotation annotation = attribute.getAnnotation("javax.persistence.PersistenceContext");
		System.out.println(annotation);
		//获取注解的值
		String text =((StringMemberValue) annotation.getMemberValue("unitName")).getValue() ;
		System.out.println("注解名称===" + text);

	}

	@Test
	public void UpdateTest() throws NotFoundException{
		ClassPool pool = ClassPool.getDefault();
		//获取需要修改的类
		CtClass ct = pool.get("com.tgb.itoo.collection.base.CollectionBase");

		//获取类里的所有方法
		CtMethod[] cms = ct.getDeclaredMethods();
		CtMethod cm = cms[0];
		System.out.println("方法名称====" + cm.getName());

		MethodInfo minInfo = cm.getMethodInfo();
		//获取类里的em属性
		CtField cf = ct.getField("em");
		FieldInfo fieldInfo = cf.getFieldInfo();

		System.out.println("属性名称===" + cf.getName());

		ConstPool cp = fieldInfo.getConstPool();
		//获取注解信息
		AnnotationsAttribute attribute2 = new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag);
		Annotation annotation = new Annotation("javax.persistence.PersistenceContext", cp);

		//修改名称为unitName的注解
		annotation.addMemberValue("unitName", new StringMemberValue("basic-entity", cp));
		attribute2.setAnnotation(annotation);
		minInfo.addAttribute(attribute2);

		//打印修改后方法
		Annotation annotation2 = attribute2.getAnnotation("javax.persistence.PersistenceContext");
		String text = ((StringMemberValue)annotation2.getMemberValue("unitName")).getValue();

		System.out.println("修改后的注解名称===" + text);
	}

	@Test
	public void aetTestCaseAtrributes() throws NotFoundException {

		ClassPool pool = ClassPool.getDefault();
		// 获取需要修改的类
		CtClass ct = pool.get("com.example.demo.until.ScheduledTasks");
		// 获取类里的所有方法
		CtMethod[] cms = ct.getDeclaredMethods();
		for (CtMethod cm : cms) {
			System.out.println("方法名称====" + cm.getName());

			MethodInfo methodInfo = cm.getMethodInfo();

			AnnotationsAttribute attribute = (AnnotationsAttribute) methodInfo
					.getAttribute(AnnotationsAttribute.visibleTag);
			System.out.println(attribute);

			ConstPool cPool = methodInfo.getConstPool();

			AnnotationsAttribute attribute2 = new AnnotationsAttribute(cPool, AnnotationsAttribute.visibleTag);
			Annotation[] anns= attribute2.getAnnotations();
			for(Annotation ann:anns){
				System.out.println(ann.getTypeName());
			}
			Annotation annotation = new Annotation("org.springframework.scheduling.annotation.Scheduled", cPool);
			annotation.addMemberValue("invocationCount", new LongMemberValue(10L, cPool));
			attribute2.setAnnotation(annotation);
			methodInfo.addAttribute(attribute2);

			Annotation annotation2 = attribute2.getAnnotation("org.springframework.scheduling.annotation.Scheduled");
			long text = ((LongMemberValue) annotation2.getMemberValue("invocationCount")).getValue();
			attribute = (AnnotationsAttribute) methodInfo.getAttribute(AnnotationsAttribute.visibleTag);

			System.out.println(attribute);
			System.out.println(text);
		}
	}
}
