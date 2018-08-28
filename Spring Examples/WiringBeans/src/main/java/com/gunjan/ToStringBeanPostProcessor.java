package com.gunjan;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ToStringBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String name)
			throws BeansException {
		Field[] fields = bean.getClass().getDeclaredFields();
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(" [");
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				builder.append(field.getName());
				builder.append("=");
				builder.append(field.get(bean));
				builder.append(", ");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		builder.append("]");
		System.out.println(builder);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String name)
			throws BeansException {
		return bean;
	}

}
